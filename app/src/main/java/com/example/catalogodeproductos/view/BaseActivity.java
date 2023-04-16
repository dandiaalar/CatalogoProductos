package com.example.catalogodeproductos.view;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.catalogodeproductos.R;
import com.example.catalogodeproductos.databinding.ToolbarBinding;
import com.example.catalogodeproductos.presenter.BasePresenter;

public abstract class BaseActivity extends AppCompatActivity {

    private BasePresenter[] presenters;
    private BasePresenter presenter;
    private String scannedQRCode = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ToolbarBinding binding = ToolbarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenters = getPresenters();
        presenter = getPresenter();
        if (presenters != null) {
            for (BasePresenter basePresenter : presenters) {
                if (basePresenter != null) {
                    basePresenter.onCreate();
                }
            }
        }

        if (presenter != null) presenter.onCreate();
    }

    protected BasePresenter getPresenter() {
        return null;
    }

    protected BasePresenter[] getPresenters() {
        return null;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (presenters != null) {
            for (BasePresenter basePresenter : presenters) {
                if (basePresenter != null) {
                    basePresenter.onStart();
                }
            }
        }
        if (presenter != null) presenter.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (presenters != null) {
            for (BasePresenter basePresenter : presenters) {
                if (basePresenter != null) {
                    basePresenter.onResume();
                }
            }
        }
        if (presenter != null) presenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (presenters != null) {
            for (BasePresenter basePresenter : presenters) {
                if (basePresenter != null) {
                    basePresenter.onPause();
                }
            }
        }

        if (presenter != null) presenter.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (presenters != null) {
            for (BasePresenter basePresenter : presenters) {
                if (basePresenter != null) {
                    basePresenter.onStop();
                }
            }
        }
        if (presenter != null) presenter.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenters != null) {
            for (BasePresenter basePresenter : presenters) {
                if (basePresenter != null) {
                    basePresenter.onDestroy();
                }
            }
        }

        if (presenter != null) presenter.onDestroy();
    }

    public void setTitle(String title){
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    protected void setupToolbar(Toolbar toolbar, boolean homeAsUpEnabled, String title) {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setTitle(title);

            if(homeAsUpEnabled){
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back);
            }
        }
    }
    public void toast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

}
