package com.app.synuptest.view.pizzalisting.callback;

import com.app.synuptest.model.api.ErrorType;
import com.app.synuptest.model.api.ViewType;
import com.app.synuptest.model.pojo.Pizza;
import com.app.synuptest.view.pizzalisting.PizzaView;

public class PizzaListingCallback extends OnPizzaListingReceived {

    private final PizzaView pizzaView;

    public PizzaListingCallback(PizzaView pizzaView) {
        this.pizzaView = pizzaView;
    }

    void onPizzaListingReceived(Pizza pizza) {
        if (pizzaView == null) {
            return;
        }
        pizzaView.handleView(ViewType.CONTENT);
        pizzaView.onSuccess(pizza);
    }

    void onError(@ErrorType int errorType) {
        if (pizzaView == null) {
            return;
        }
        pizzaView.handleView(ViewType.ERROR);
        pizzaView.onFailure(errorType);
    }
}
