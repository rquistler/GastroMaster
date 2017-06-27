package de.hsb.gastromaster.presentation.features.order_list;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hsb.gastromaster.R;
import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.presentation.features.BaseRecyclerViewAdapter;

/**
 * The type Order list view adapter.
 */
public class OrderListViewAdapter extends BaseRecyclerViewAdapter<Order> {

    /**
     * The Order id.
     */
    @BindView(R.id.lblValueForId)
    TextView orderId;

    /**
     * The Order date.
     */
    @BindView(R.id.lblValueForDate)
    TextView orderDate;

    /**
     * The Order complete.
     */
    @BindView(R.id.cbxOrderComplete)
    CheckBox orderComplete;


    /**
     * Instantiates a new Order list view adapter.
     *
     * @param itemList the item list
     * @param listener the listener
     */
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
        orderId.setText(String.valueOf(item.getId()));
        orderDate.setText(item.getDate());
        orderComplete.setChecked(item.getIsCompleted());
    }
}
