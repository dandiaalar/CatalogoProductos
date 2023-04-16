package com.example.catalogodeproductos.view;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.catalogodeproductos.databinding.ActMainBinding;
import com.example.catalogodeproductos.model.management.AppDataBase;
import com.example.catalogodeproductos.model.pojos.Criteria;
import com.example.catalogodeproductos.presenter.callbacks.MainCallback;
import com.example.catalogodeproductos.presenter.implementations.BasePresenter;
import com.example.catalogodeproductos.presenter.implementations.MainPresenter;
import com.example.catalogodeproductos.support.MessageUtilities;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class MainActivity extends BaseActivity implements MainCallback {

    private ActMainBinding binding;
    private AppDataBase dataBase;
    private MainPresenter presenter;

    private Dialog loading;

    private List<Criteria> criteriaList;
    private Calendar calendar;
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

        binding.mainSearch.setOnClickListener(v -> {
            if (!Objects.requireNonNull(binding.mainProduct.getText()).toString().isEmpty()){
                String criteria = binding.mainProduct.getText().toString().trim();
                insertCriteria(criteria);
                binding.mainProduct.setText("");
            }
        });
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
    public void onSuccess() {
        if (loading != null) loading.dismiss();
    }

    @Override
    public void onError(String error) {
        if (loading != null) loading.dismiss();

        MessageUtilities.showErrorMessage(MainActivity.this, error);
    }
}