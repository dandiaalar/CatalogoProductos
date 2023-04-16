package com.example.catalogodeproductos.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.catalogodeproductos.databinding.ActMainBinding;

public class MainActivity extends BaseActivity {

    private ActMainBinding binding;

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
    }
}