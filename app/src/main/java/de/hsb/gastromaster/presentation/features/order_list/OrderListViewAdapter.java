package de.hsb.gastromaster.presentation.features.order_list;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.presentation.features.BaseRecyclerViewAdapter;

public class OrderListViewAdapter extends BaseRecyclerViewAdapter<Order> {
    public OrderListViewAdapter(List<Order> itemList, IOnItemClick listener) {
        super(itemList, listener);
    }

    @Override
    protected View createView(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    protected void bindItem(Order item, RecyclerView.ViewHolder viewHolder) {

    }
}
