package com.app.synuptest.model.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAdapter {

    static PizzaApi api;

    public static synchronized PizzaApi getInstance() {
        if (api == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.myjson.com/bins/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            api = retrofit.create(PizzaApi.class);
        }
        return api;
    }
}
