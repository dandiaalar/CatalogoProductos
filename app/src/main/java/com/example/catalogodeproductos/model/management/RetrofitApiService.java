package com.example.catalogodeproductos.model.management;

import com.example.catalogodeproductos.model.pojos.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface RetrofitApiService {


    @Headers("apikey4: adb8204d-d574-4394-8c1a-53226a40876e")
    @GET("tienda?s=criterio&d3106047a194921c01969dfdec083925=json")
    Call<List<Product>> getProducts(@Query("criterio") String criterio);
}
