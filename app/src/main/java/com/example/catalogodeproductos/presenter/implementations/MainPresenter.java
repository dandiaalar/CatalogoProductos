package com.example.catalogodeproductos.presenter.implementations;

import android.content.Context;

import com.example.catalogodeproductos.presenter.callbacks.MainCallback;
import com.example.catalogodeproductos.presenter.implementations.BasePresenter;

public class MainPresenter extends BasePresenter {

    private final MainCallback callback;

    public MainPresenter(Context context, MainCallback callback) {
        super(context);
        this.callback = callback;
    }
}
