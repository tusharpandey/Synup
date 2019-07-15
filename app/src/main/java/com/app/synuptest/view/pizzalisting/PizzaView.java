package com.app.synuptest.view.pizzalisting;

import android.content.Context;

import com.app.synuptest.model.api.ErrorType;
import com.app.synuptest.model.api.ViewType;
import com.app.synuptest.model.pojo.Pizza;

public interface PizzaView {
    void getPizzaList();

    void onSuccess(Pizza pizza);

    void onFailure(@ErrorType int errorType);

    void handleView(@ViewType int viewType);

    Context getContext();
}
