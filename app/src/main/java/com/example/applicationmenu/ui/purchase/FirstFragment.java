package com.example.applicationmenu.ui.purchase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicationmenu.R;
import com.example.applicationmenu.Recycler.ProductoVo;
import com.example.applicationmenu.databinding.FragmentFirstBinding;
import com.example.applicationmenu.ui.purchase.recycler.PurchaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    List<ProductoVo> products;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        //initPurchase();
        return binding.getRoot();

    }

    private void initPurchase(){
        products = new ArrayList<>();
        products.add(new ProductoVo("Lomo saltado"));
        products.add(new ProductoVo("Chicharron de calamar"));
        products.add(new ProductoVo("Jalea mixta"));

        PurchaseAdapter purchaseAdapter = new PurchaseAdapter(products, requireContext());
        RecyclerView recyclerView = requireActivity().findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(purchaseAdapter);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}