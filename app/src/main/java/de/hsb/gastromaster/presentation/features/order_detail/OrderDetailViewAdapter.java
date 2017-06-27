/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.presentation.features.order_detail;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hsb.gastromaster.R;
import de.hsb.gastromaster.data.order.dish.Dish;
import de.hsb.gastromaster.presentation.features.BaseRecyclerViewAdapter;

/**
 * The type Order detail view adapter.
 */
public class OrderDetailViewAdapter extends BaseRecyclerViewAdapter<Dish> {

    /**
     * The Txt dish name.
     */
    @BindView(R.id.txtName)
    TextView txtDishName;

    /**
     * The Txt dish price.
     */
    @BindView(R.id.txtPrice)
    TextView txtDishPrice;

    /**
     * Instantiates a new Order detail view adapter.
     *
     * @param itemList the item list
     * @param listener the listener
     */
    public OrderDetailViewAdapter(List<Dish> itemList, IOnItemClick listener) {
        super(itemList, listener);
    }

    @Override
    protected View createView(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_dish_list_item, parent, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void bindItem(Dish item, RecyclerView.ViewHolder viewHolder) {
        txtDishName.setText(item.getName());
        txtDishPrice.setText(String.valueOf(item.getPrice()));
    }

}
