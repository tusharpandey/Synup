package com.app.synuptest.view.pizzalisting.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.app.synuptest.R;
import com.app.synuptest.model.pojo.VariantGroup;
import com.app.synuptest.model.pojo.Variation;

import java.util.ArrayList;
import java.util.List;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.MyViewHolder> {
    private final VariantGroup variationGroup;
    private List<Variation> mDataset = new ArrayList<>();

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public CheckBox checkBox;

        public MyViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.title);
            checkBox = v.findViewById(R.id.checkbox);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b) {
                        String variationId = (String) checkBox.getTag();
                        variationGroup.setChecked(variationId);
                        notifyDataSetChanged();
                    }
                }
            });
        }
    }

    public PizzaAdapter(VariantGroup group) {
        this.variationGroup = group;
        mDataset = group.getVariations();
    }

    @Override
    public PizzaAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_pizza_listing, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.checkBox.setTag(mDataset.get(position).getId());
        holder.textView.setText(mDataset.get(position).getName());
        holder.checkBox.setChecked(mDataset.get(position).isChecked());
    }

    @Override
    public int getItemCount() {
        return mDataset == null ? 0 : mDataset.size();
    }
}