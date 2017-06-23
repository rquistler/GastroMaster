package de.hsb.gastromaster.presentation.features.order_list;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import de.hsb.gastromaster.R;
import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.presentation.features.BaseRecyclerViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderListFragment extends Fragment implements OrderListContract.View<Order>, BaseRecyclerViewAdapter.IOnItemClick {

    private RecyclerView orderList;
    private OrderListContract.Presenter<Order> orderListPresenter;
    private OrderListViewAdapter orderListAdapter;
    private RecyclerView.LayoutManager orderListLayoutManager;
    public OrderListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_list, container, false);
    }

    @Override
    public void setOrderList(List list) {

    }

    @Override
    public void onClick(View view, int position) {

    }

    @Override
    public void goToOrderDetail(Order item) {

    }
}
