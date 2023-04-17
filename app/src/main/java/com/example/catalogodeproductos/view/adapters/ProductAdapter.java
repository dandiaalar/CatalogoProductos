package com.example.catalogodeproductos.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.catalogodeproductos.R;
import com.example.catalogodeproductos.databinding.ItemProductBinding;
import com.example.catalogodeproductos.model.pojos.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Product> products = new ArrayList<>();
    private Context context;

    public ProductAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemProductBinding binding = ItemProductBinding.inflate(inflater, parent, false);

        return new ProductAdapter.ProductViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof ProductAdapter.ProductViewHolder){
            ProductAdapter.ProductViewHolder holder = (ProductAdapter.ProductViewHolder) viewHolder;

            Product product = products.get(position);

            holder.itemView.setTag(product);

            holder.binding.productTitle.setText(product.getTitle());
            holder.binding.productLocation.setText(product.getSellernames());
            holder.binding.productPrice.setText(product.getSalePrice());

            Glide.with(context)
                    .load(product.getThumbnailImage())
                    .apply(new RequestOptions()
                            .centerCrop()
                            .placeholder(R.drawable.ic_no_image_found_512px)
                            .error(R.drawable.ic_no_image_found_512px))
                    .into(holder.binding.productImage);


        }
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void update(List<Product> products){
        this.products.clear();
        this.products.addAll(products);
        notifyDataSetChanged();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        private final ItemProductBinding binding;

        ProductViewHolder(ItemProductBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
