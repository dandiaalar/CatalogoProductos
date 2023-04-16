package com.example.catalogodeproductos.view;

import android.os.Bundle;
import android.os.Handler;

import com.example.catalogodeproductos.databinding.ActSplashBinding;

public class SplashActivity extends BaseActivity {

    private ActSplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActSplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new Handler().postDelayed(() -> {

            MainActivity.launch(SplashActivity.this);
            finish();

        }, 3000);
    }
}