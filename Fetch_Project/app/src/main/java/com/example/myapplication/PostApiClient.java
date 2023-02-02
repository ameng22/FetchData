package com.example.myapplication;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostApiClient {

    static String BASE_URL = "https://reqres.in/api/";

    private static Retrofit getRetrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder().
                                baseUrl(BASE_URL).
                                addConverterFactory(GsonConverterFactory.create()).
                                client(okHttpClient).
                                build();

        return retrofit;
    }

    static UserService getUserService(){
        UserService userService = getRetrofit().create(UserService.class);

        return userService;
    }

}
