package com.app.synuptest.model.api;

import com.app.synuptest.model.pojo.Pizza;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PizzaApi {
    @GET("19u0sf")
    Call<Pizza> getPizzaList();
}
