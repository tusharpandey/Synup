package com.app.synuptest.view.pizzalisting.callback;

import com.app.synuptest.model.api.ErrorType;
import com.app.synuptest.model.pojo.Pizza;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class OnPizzaListingReceived implements Callback<Pizza> {

    @Override
    public void onResponse(Call<Pizza> call, Response<Pizza> response) {
        if (response == null || response.body() == null) {
            onError(ErrorType.API_ERROR);
            return;
        }

        onPizzaListingReceived(response.body());
    }

    @Override
    public void onFailure(Call<Pizza> call, Throwable t) {
        onError(ErrorType.API_ERROR);
    }

    abstract void onPizzaListingReceived(Pizza pizza);

    abstract void onError(@ErrorType int errorType);
}
