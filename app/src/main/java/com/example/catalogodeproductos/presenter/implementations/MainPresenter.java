package com.example.catalogodeproductos.presenter.implementations;

import android.content.Context;

import com.example.catalogodeproductos.model.management.RetrofitApiService;
import com.example.catalogodeproductos.model.management.RetrofitClient;
import com.example.catalogodeproductos.model.pojos.Product;
import com.example.catalogodeproductos.presenter.callbacks.MainCallback;
import com.example.catalogodeproductos.presenter.implementations.BasePresenter;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter extends BasePresenter {

    private final MainCallback callback;
    private RetrofitApiService apiService = RetrofitClient.getApiService();
    private Disposable disposable;
    private String result = "";
    private List<Product> products = new ArrayList<>();

    public MainPresenter(Context context, MainCallback callback) {
        super(context);
        this.callback = callback;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (disposable != null && !disposable.isDisposed()) disposable.dispose();
    }

    public void getProducts(String criteria){

        result = "";

        if (disposable != null && !disposable.isDisposed()) disposable.dispose();
        disposable = Observable.fromCallable(() -> getProductsByCriteria(criteria))
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(subscription -> callback.onLoading("Buscando productos.."))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {

                }, throwable -> {
                    if (throwable instanceof ConnectException){
                        callback.onError("");
                    }else if (throwable instanceof SocketTimeoutException){
                        callback.onError("");
                    }else{
                        callback.onError(throwable.getMessage());
                    }
                });
    }

    private String getProductsByCriteria(String criteria){

        //Call<List<Product>> call = apiService.getProducts("adb8204d-d574-4394-8c1a-53226a40876e", criteria, "json");
        Call<List<Product>> call = apiService.getProducts(3);

        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {

                if (!response.isSuccessful()){
                    result = "HTTP code: " + response.code();
                    callback.onError(result);
                    return;
                }

                products.clear();
                products = response.body();

                callback.onSuccess(products);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

                if (t instanceof ConnectException){
                    callback.onError("");
                }else if (t instanceof SocketTimeoutException){
                    callback.onError("");
                }else{
                    callback.onError(t.getMessage());
                }
                return;
            }
        });

        return result;
    }
}
