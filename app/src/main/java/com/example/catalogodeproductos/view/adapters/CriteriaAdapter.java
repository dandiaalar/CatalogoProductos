package com.example.catalogodeproductos.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catalogodeproductos.databinding.ItemCriteriaBinding;
import com.example.catalogodeproductos.model.pojos.Criteria;

import java.util.ArrayList;
import java.util.List;

public class CriteriaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Criteria> criteriaList = new ArrayList<>();
    private Context context;

    public CriteriaAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemCriteriaBinding binding = ItemCriteriaBinding.inflate(inflater, parent, false);

        return new CriteriaAdapter.CriteriaViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof CriteriaAdapter.CriteriaViewHolder){
            CriteriaAdapter.CriteriaViewHolder holder = (CriteriaViewHolder) viewHolder;

            Criteria criteria = criteriaList.get(position);

            holder.itemView.setTag(criteria);

            holder.binding.criteriaDesc.setText(criteria.getCriteria());
        }
    }

    @Override
    public int getItemCount() {
        return criteriaList.size();
    }

    public void update(List<Criteria> criteriaList){
        this.criteriaList.clear();
        this.criteriaList.addAll(criteriaList);
        notifyDataSetChanged();
    }

    class CriteriaViewHolder extends RecyclerView.ViewHolder {
        private final ItemCriteriaBinding binding;

        CriteriaViewHolder(ItemCriteriaBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
