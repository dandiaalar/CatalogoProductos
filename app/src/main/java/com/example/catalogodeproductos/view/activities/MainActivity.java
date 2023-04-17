package com.example.catalogodeproductos.view.activities;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.catalogodeproductos.databinding.ActMainBinding;
import com.example.catalogodeproductos.model.management.AppDataBase;
import com.example.catalogodeproductos.model.pojos.Criteria;
import com.example.catalogodeproductos.model.pojos.Product;
import com.example.catalogodeproductos.presenter.callbacks.MainCallback;
import com.example.catalogodeproductos.presenter.implementations.BasePresenter;
import com.example.catalogodeproductos.presenter.implementations.MainPresenter;
import com.example.catalogodeproductos.support.MessageUtilities;
import com.example.catalogodeproductos.view.adapters.CriteriaAdapter;
import com.example.catalogodeproductos.view.adapters.ProductAdapter;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class MainActivity extends BaseActivity implements MainCallback {

    private ActMainBinding binding;
    private AppDataBase dataBase;
    private MainPresenter presenter;

    private Dialog loading;

    private List<Criteria> criteriaList;
    private List<Product> products;
    private Calendar calendar;

    private CriteriaAdapter criteriaAdapter;
    private ProductAdapter productAdapter;
    public static void launch(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupToolbar(binding.mainToolbar.toolbar, false, "Consultar productos");

        // SETUP
        setupDatabase();
        initRecycler();
        getCriteriaList();

        binding.mainSearch.setOnClickListener(v -> {
            if (!Objects.requireNonNull(binding.mainProduct.getText()).toString().isEmpty()){
                String criteria = binding.mainProduct.getText().toString().trim();

                presenter.getProducts(criteria);

                //insertCriteria(criteria);
                //binding.mainProduct.setText("");

                getCriteriaList();
            }
        });
    }

    private void getCriteriaList() {

        criteriaList = dataBase.daoCriteria().getCriteriaList();

        if (criteriaList.size() > 0){
            criteriaAdapter.update(criteriaList);
        }
    }

    private void initRecycler() {
        criteriaAdapter = new CriteriaAdapter(this);

        binding.mainSearchRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.mainSearchRecycler.setItemAnimator(new DefaultItemAnimator());
        binding.mainSearchRecycler.setHasFixedSize(true);
        binding.mainSearchRecycler.setAdapter(criteriaAdapter);

        productAdapter = new ProductAdapter(this);

        binding.mainProductRecycler.setLayoutManager(new LinearLayoutManager(this));
        binding.mainProductRecycler.setItemAnimator(new DefaultItemAnimator());
        binding.mainProductRecycler.setHasFixedSize(true);
        binding.mainProductRecycler.setAdapter(productAdapter);

    }

    @Override
    protected BasePresenter getPresenter() {
        return presenter = new MainPresenter(MainActivity.this, this);
    }

    private void setupDatabase() {
        dataBase = AppDataBase.getInstance(this);
    }

    private void insertCriteria(String criteria){

        calendar = Calendar.getInstance();

        dataBase.daoCriteria().insertCriteria(
                new Criteria(
                        0,
                        criteria,
                        calendar.getTime()));
    }

    @Override
    public void onLoading(String text) {
        if (loading != null) loading.dismiss();
        loading = MessageUtilities.showLoadingMessage(MainActivity.this, text);
        loading.show();
    }

    @Override
    public void onSuccess(List<Product> products) {
        if (loading != null) loading.dismiss();

        if (products.size() > 0){
            productAdapter.update(products);
            binding.mainProductRecycler.setVisibility(View.VISIBLE);
        }else{
            binding.mainProductRecycler.setVisibility(View.GONE);
        }
    }

    @Override
    public void onError(String error) {
        if (loading != null) loading.dismiss();

        MessageUtilities.showErrorMessage(MainActivity.this, error);
    }
}