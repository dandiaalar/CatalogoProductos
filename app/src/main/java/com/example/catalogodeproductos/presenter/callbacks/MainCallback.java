package com.example.catalogodeproductos.presenter.callbacks;

import com.example.catalogodeproductos.model.pojos.Product;

import java.util.List;

public interface MainCallback {
    void onLoading(String text);
    void onSuccess(List<Product> products);
    void onError(String error);
}
