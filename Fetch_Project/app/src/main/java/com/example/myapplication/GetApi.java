package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface GetApi {

    @GET("/posts")
    Call<List<UserResponse>> getUser();
}
