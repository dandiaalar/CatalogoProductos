package com.example.catalogodeproductos.presenter.callbacks;

public interface MainCallback {
    void onLoading(String text);
    void onSuccess();
    void onError(String error);
}
