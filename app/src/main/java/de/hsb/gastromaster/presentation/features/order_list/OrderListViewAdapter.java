package de.hsb.gastromaster.presentation.features.order_list;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hsb.gastromaster.R;
import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.presentation.features.BaseRecyclerViewAdapter;

public class OrderListViewAdapter extends BaseRecyclerViewAdapter<Order> {

//    @BindView(R.id.txtTableNumber)
//    TextView txtTableNumber;
//
//    @BindView(R.id.txtNumberOrders)
//    TextView txtNumberOrders;


    public OrderListViewAdapter(List<Order> itemList, IOnItemClick listener) {
        super(itemList, listener);
    }

    @Override
    protected View createView(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_order_list_item, parent, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void bindItem(Order item, RecyclerView.ViewHolder viewHolder) {
//        txtTableNumber.setText(item.getName());
//        txtNumberOrders.setText(String.valueOf(item.getTotalOrders()));
    }
}
