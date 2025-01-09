package com.tonyliu.androidstore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    Context context;
    //products to display in recyclerView
    ArrayList<Product> productArrayList;
    OnItemClickListener onItemClickListener;

    public ProductAdapter(Context context, ArrayList<Product> productArrayList) {
        this.context = context;
        this.productArrayList = productArrayList;
    }
    public interface OnItemClickListener {
        void onItemClick(Product product);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }
    //inflates item and creates viewHolder for each item
    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.rv_list_item, parent, false);
        return new ProductAdapter.ProductViewHolder(view);
    }
    //binds data from product to views in viewHolder
    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        Product product = productArrayList.get(position);
        holder.ivProdImg.setImageResource(product.getImgID());
        holder.tvProdName.setText(product.getProdName());
        holder.tvProdDesc.setText(product.getProdDesc());
        holder.tvProdPrice.setText(product.getProdPrice());

        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {

                onItemClickListener.onItemClick(product);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    //class to hold references to views in each item layout
    public class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView ivProdImg;
        TextView tvProdName, tvProdDesc, tvProdPrice;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProdImg = itemView.findViewById(R.id.ivProdImage);
            tvProdName = itemView.findViewById(R.id.tvProdName);
            tvProdDesc = itemView.findViewById(R.id.tvProdDesc);
            tvProdPrice = itemView.findViewById(R.id.tvProdPrice);
        }
    }
}
