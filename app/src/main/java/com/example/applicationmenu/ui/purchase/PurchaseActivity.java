package com.example.applicationmenu.ui.purchase;

import android.os.Bundle;

import com.example.applicationmenu.Recycler.ProductoVo;
import com.example.applicationmenu.databinding.ActivityPurchaseBinding;
import com.example.applicationmenu.ui.purchase.recycler.PurchaseAdapter;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicationmenu.R;

import java.util.ArrayList;
import java.util.List;

public class PurchaseActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityPurchaseBinding binding;

    List<ProductoVo> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPurchaseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_purchase);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initPurchase();
    }

    private void initPurchase(){
        products = new ArrayList<>();
        products.add(new ProductoVo("Lomo saltado", R.drawable.lomo_carne));
        products.add(new ProductoVo("Ceviche", R.drawable.ceviche));
        products.add(new ProductoVo("Mil hojas", R.drawable.milhojas));

        PurchaseAdapter purchaseAdapter = new PurchaseAdapter(products, this);
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(purchaseAdapter);

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_purchase);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}