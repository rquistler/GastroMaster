package de.hsb.gastromaster.presentation.features.order_list;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hsb.gastromaster.GastroMasterApp;
import de.hsb.gastromaster.R;
import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.table.Table;
import de.hsb.gastromaster.domain.feature.create_order.CreateOrderUseCase;
import de.hsb.gastromaster.domain.feature.get_orders.GetOrdersUseCase;
import de.hsb.gastromaster.presentation.features.BaseRecyclerViewAdapter;
import de.hsb.gastromaster.presentation.ui.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderListFragment extends Fragment implements OrderListContract.View<Order>, BaseRecyclerViewAdapter.IOnItemClick {

    private RecyclerView orderList;
    private OrderListContract.Presenter<Order> orderListPresenter;
    private OrderListViewAdapter orderListAdapter;
    private RecyclerView.LayoutManager orderListLayoutManager;
    private String tableNumber;

    @BindView(R.id.btnAddOrder)
    FloatingActionButton btnAddOrder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_order_list, container, false);

        orderList = (RecyclerView) rootView.findViewById(R.id.order_list);
        orderListLayoutManager = new LinearLayoutManager(getContext());

        ArrayList<Order> items = new ArrayList<>();

        orderListAdapter = new OrderListViewAdapter(items,this);
        orderListPresenter = new OrderListPresenter(this,
                new GetOrdersUseCase(((GastroMasterApp) getActivity().getApplication()).getOrderDataRepository()),
                new CreateOrderUseCase(((GastroMasterApp) getActivity().getApplication()).getOrderDataRepository()));

        orderList.setLayoutManager(orderListLayoutManager);
        orderList.setAdapter(orderListAdapter);

        ButterKnife.bind(this, rootView);

        btnAddOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderListPresenter.onAddOrderClick(tableNumber, null);
            }
        });
        return rootView;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tableNumber = getArguments().getString("Table");
        orderListPresenter.init(tableNumber);
    }


    @Override
    public void setOrderList(List<Order> list) {
        orderListAdapter.setList(list);
    }

    @Override
    public void goToDishList(String tableNumber, Order order) {
        ((MainActivity)getActivity()).goToDishListView(tableNumber, order);
    }

    @Override
    public void onClick(View view, int position) {
        orderListPresenter.onItemClick(orderListAdapter.getItemListItem(position));
    }

    @Override
    public void goToOrderDetail(Order item) {
        ((MainActivity)getActivity()).goToOrderDetailView(item);
    }

    public static OrderListFragment newInstance() {
        Bundle args = new Bundle();
        OrderListFragment fragment = new OrderListFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
