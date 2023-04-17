package com.example.catalogodeproductos.model.management;

import com.example.catalogodeproductos.support.Constants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static Retrofit retrofit = null;

    public static RetrofitApiService getApiService() {

        /*
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        * */

        /*
        private static Retrofit.Builder builder
        = new Retrofit.Builder()
          .baseUrl("https://api.domain.com/")
          .addConverterFactory(GsonConverterFactory.create())
          .client(httpClient.build());
        * */

        HttpLoggingInterceptor interceptor  = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();



        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(RetrofitApiService.class);

    }

}
