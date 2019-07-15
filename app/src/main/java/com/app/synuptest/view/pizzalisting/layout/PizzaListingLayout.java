package com.app.synuptest.view.pizzalisting.layout;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.app.synuptest.R;
import com.app.synuptest.model.api.ViewType;
import com.app.synuptest.model.pojo.ExcludeList;
import com.app.synuptest.model.pojo.Pizza;
import com.app.synuptest.model.pojo.VariantGroup;
import com.app.synuptest.presenter.PizzaListingPresenter;
import com.app.synuptest.view.pizzalisting.PizzaView;
import com.app.synuptest.view.pizzalisting.adapter.PizzaAdapter;

import java.util.List;

public class PizzaListingLayout extends LinearLayout implements PizzaView {
    PizzaListingPresenter pizzaListingPresenter;
    TextView error_message;
    View contentLayout;
    ProgressBar progressBar;
    RecyclerView recyclerView1;
    RecyclerView recyclerView2;
    RecyclerView recyclerView3;
    TextView crust;
    TextView size;
    TextView sauce;


    public PizzaListingLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        pizzaListingPresenter = new PizzaListingPresenter();
        init();
        initViews();
    }

    private void initViews() {

        crust = findViewById(R.id.crust);
        size = findViewById(R.id.size);
        sauce = findViewById(R.id.sauce);

        error_message = findViewById(R.id.error_message);
        contentLayout = findViewById(R.id.content);
        progressBar = findViewById(R.id.progress);

        recyclerView1 = findViewById(R.id.recycler_view_1);
        recyclerView2 = findViewById(R.id.recycler_view_2);
        recyclerView3 = findViewById(R.id.recycler_view_3);

        addDivider(recyclerView1);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));

        addDivider(recyclerView2);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));

        addDivider(recyclerView3);
        recyclerView3.setHasFixedSize(true);
        recyclerView3.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void init() {
        inflate(getContext(), R.layout.layout_pizza_listing, this);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        pizzaListingPresenter.attach(this);
        getPizzaList();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        pizzaListingPresenter.deAttach();
    }

    @Override
    public void getPizzaList() {
        pizzaListingPresenter.getPizzaList();
    }

    @Override
    public void onSuccess(Pizza pizza) {
        setDataInViews(pizza);
        setDatainList(pizza);
    }

    private void setDatainList(Pizza pizza) {
        PizzaAdapter mAdapter = new PizzaAdapter(createAdapterData(pizza, 0));
        recyclerView1.setAdapter(mAdapter);

        PizzaAdapter mAdapter2 = new PizzaAdapter(createAdapterData(pizza, 1));
        recyclerView2.setAdapter(mAdapter2);

        PizzaAdapter mAdapter3 = new PizzaAdapter(createAdapterData(pizza, 2));
        recyclerView3.setAdapter(mAdapter3);
    }

    private VariantGroup createAdapterData(Pizza pizza, int index) {
        List<List<ExcludeList>> excludedList = pizza.getVariants().getExcludeList();
        VariantGroup group = pizza.getVariants().getVariantGroups().get(index);
        group.createExcludedItem(excludedList);
        return group;
    }

    private void setDataInViews(Pizza pizza) {
        crust.setText(pizza.getVariants().getVariantGroups().get(0).getName());
        size.setText(pizza.getVariants().getVariantGroups().get(1).getName());
        sauce.setText(pizza.getVariants().getVariantGroups().get(2).getName());
    }

    private void addDivider(RecyclerView recyclerView) {
        DividerItemDecoration divider = new
                DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        divider.setDrawable(
                ContextCompat.getDrawable(getContext(), R.drawable.divider)
        );
        recyclerView.addItemDecoration(divider);
    }

    @Override
    public void onFailure(int errorType) {
        Toast.makeText(getContext(), "Failure", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void handleView(int viewType) {

        error_message.setVisibility(GONE);
        contentLayout.setVisibility(GONE);
        progressBar.setVisibility(GONE);

        switch (viewType) {
            case ViewType.ERROR:
                error_message.setVisibility(VISIBLE);
                break;
            case ViewType.CONTENT:
                contentLayout.setVisibility(VISIBLE);
                break;
            case ViewType.LOADER:
                progressBar.setVisibility(VISIBLE);
                break;
        }
    }
}
