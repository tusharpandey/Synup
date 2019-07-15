package com.app.synuptest.presenter;

import com.app.synuptest.model.api.ViewType;
import com.app.synuptest.model.repo.repoImplementation.CloudRepositoryImplementation;
import com.app.synuptest.view.pizzalisting.PizzaView;
import com.app.synuptest.view.pizzalisting.callback.PizzaListingCallback;
import com.app.synuptest.view.pizzalisting.util.Network;

public class PizzaListingPresenter {
    private PizzaView view;
    private CloudRepositoryImplementation cloudRepositoryImplementation;

    public PizzaListingPresenter() {
        this.cloudRepositoryImplementation = new CloudRepositoryImplementation();
    }

    public void attach(PizzaView pizzaView) {
        this.view = pizzaView;
    }

    public void deAttach() {
        this.view = null;
    }

    public void getPizzaList() {
        view.handleView(ViewType.LOADER);
        if (!Network.isNetworkAvailable(view.getContext())) {
            view.handleView(ViewType.ERROR);
            return;
        }
        cloudRepositoryImplementation.getPizzaList(new PizzaListingCallback(view));
    }
}
