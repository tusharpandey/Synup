package com.app.synuptest.model.repo.repoImplementation;

import com.app.synuptest.model.api.ApiAdapter;
import com.app.synuptest.model.pojo.Pizza;
import com.app.synuptest.model.repo.CloudRepository;

import retrofit2.Call;
import retrofit2.Callback;

public class CloudRepositoryImplementation implements CloudRepository {

    @Override
    public void getPizzaList(Callback callback) {
        Call<Pizza> call = ApiAdapter.getInstance().getPizzaList();
        call.enqueue(callback);
    }
}
