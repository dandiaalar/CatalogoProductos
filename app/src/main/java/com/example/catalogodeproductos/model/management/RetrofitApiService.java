package com.example.catalogodeproductos.model.management;

import com.example.catalogodeproductos.model.pojos.Product;
import com.example.catalogodeproductos.support.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface RetrofitApiService {

    // https://www.liverpool.com.mx/tienda?
    // s=nintendo
    // &
    // adb8204d-d574-4394-8c1a-53226a40876e=json

    @GET(Constants.CRITERIA_URL)
    Call<List<Product>> getProducts(@Header("apikey4") String header, @Query("s") String criterio, @Query("adb8204d-d574-4394-8c1a-53226a40876e") String type);

    @GET("planets")
    Call<List<Product>> getProducts(@Query("planets") int num);
}
