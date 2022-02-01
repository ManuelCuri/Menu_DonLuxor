package com.example.applicationmenu.Recycler;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicationmenu.R;

import java.util.ArrayList;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ViewHolderProductos>
                implements View.OnClickListener{

    ArrayList<ProductoVo> listaProductos;
    private View.OnClickListener listener;

    public ProductosAdapter(ArrayList<ProductoVo> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @NonNull
    @Override
    public ViewHolderProductos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);

        //metodo Listener
        view.setOnClickListener(this);

        return new ViewHolderProductos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProductos holder, int position) {
        final ProductoVo item = listaProductos.get(position);
        holder.etiNombre.setText(item.getNombre());
        holder.etiInformacion.setText(item.getInfo());
        holder.etiPrecio.setText(item.getPrecio());
        holder.foto.setImageResource(item.getFoto());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                intent.putExtra("itemDetail", item);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    //Metodo OnClick Para la Navegacion De Fragments basico
    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolderProductos extends RecyclerView.ViewHolder {

        TextView etiNombre, etiInformacion, etiPrecio;
        ImageView foto;
        Button btnAdd;

        public ViewHolderProductos(@NonNull View itemView) {
            super(itemView);
            etiNombre=itemView.findViewById(R.id.idNombre);
            etiInformacion=itemView.findViewById(R.id.idInfo);
            etiPrecio=itemView.findViewById(R.id.idPrecio);
            foto=itemView.findViewById(R.id.idImagen);
            btnAdd=itemView.findViewById(R.id.btnAddProduct);

            btnAdd.setOnClickListener((e) -> {
                Toast.makeText(itemView.getContext(), "Producto Agregado", Toast.LENGTH_SHORT).show();
            });
        }
    }
}
