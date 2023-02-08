package com.example.myapplication;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetApiClient {

    private static GetApiClient instance = null;

    static String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static GetApi getApi;

        private GetApiClient(){
//
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

            Retrofit retrofit = new Retrofit.Builder().
                    baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).
                    client(okHttpClient).
                    build();

            getApi = retrofit.create(GetApi.class);


        }


    public static GetApiClient getInstance() {

            if (instance == null){
                instance = new GetApiClient();
            }

            return instance;
    }

    public GetApi getUserService(){
            return getApi;
        }

    }


