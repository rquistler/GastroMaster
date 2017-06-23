package de.hsb.gastromaster.presentation.features.order_list;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import de.hsb.gastromaster.R;
import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.OrderDataRepository;
import de.hsb.gastromaster.data.order.local.OrderDataStore;
import de.hsb.gastromaster.domain.feature.get_orders.GetOrdersUseCase;
import de.hsb.gastromaster.presentation.features.BaseRecyclerViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderListFragment extends Fragment implements OrderListContract.View<Order>, BaseRecyclerViewAdapter.IOnItemClick {

    private RecyclerView orderList;
    private OrderListContract.Presenter<Order> orderListPresenter;
    private OrderListViewAdapter orderListAdapter;
    private RecyclerView.LayoutManager orderListLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_table_list, container, false);

        orderList = (RecyclerView) rootView.findViewById(R.id.table_list);
        orderListLayoutManager = new LinearLayoutManager(getContext());

        ArrayList<Order> items = new ArrayList<>();

        orderListAdapter = new OrderListViewAdapter(items,this);
        orderListPresenter = new OrderListPresenter(this,
                new GetOrdersUseCase(
                        new OrderDataRepository(
                                new OrderDataStore())));

        orderList.setLayoutManager(orderListLayoutManager);
        orderList.setAdapter(orderListAdapter);

        return rootView;
    }

    @Override
    public void setOrderList(List<Order> list) {

    }

    @Override
    public void onClick(View view, int position) {

    }

    @Override
    public void goToOrderDetail(Order item) {

    }

    public static OrderListFragment newInstance() {
        Bundle args = new Bundle();
        OrderListFragment fragment = new OrderListFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
