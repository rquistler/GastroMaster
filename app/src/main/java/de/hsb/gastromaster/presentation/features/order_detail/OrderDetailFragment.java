package de.hsb.gastromaster.presentation.features.order_detail;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hsb.gastromaster.R;
import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.dish.Dish;
import de.hsb.gastromaster.domain.feature.get_order.GetOrderUseCase;
import de.hsb.gastromaster.domain.feature.update_order.UpdateOrderUseCase;
import de.hsb.gastromaster.presentation.features.BaseRecyclerViewAdapter;
import de.hsb.gastromaster.presentation.ui.MainActivity;


public class OrderDetailFragment extends Fragment implements OrderDetailContract.View<Dish>, BaseRecyclerViewAdapter.IOnItemClick {

    private RecyclerView dishList;
    private OrderDetailPresenter orderDetailPresenter;
    private OrderDetailViewAdapter dishListViewAdapter;
    private RecyclerView.LayoutManager dishListLayoutManager;

    @BindView(R.id.btnAddDish)
    FloatingActionButton btnAddDish;

    @BindView(R.id.txtOrderId)
    TextView txtOrderId;

    @BindView(R.id.txtOrderDate)
    TextView txtOrderDate;

    @BindView(R.id.txtFinalPrice)
    TextView txtOrderTotalPrice;

    @BindView(R.id.txtWaitressId)
    TextView txtWaitressId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_order_detail, container, false);

        MainActivity mainActivity = (MainActivity) getActivity();

        dishList = (RecyclerView) rootView.findViewById(R.id.order_detail_dish_list);
        dishListLayoutManager = new LinearLayoutManager(getContext());

        ArrayList<Dish> items = new ArrayList<>();

        dishListViewAdapter = new OrderDetailViewAdapter(items,this);
        orderDetailPresenter = new OrderDetailPresenter(this,
                new GetOrderUseCase(mainActivity.getGastroMasterApp().getOrderDataRepository()),
                new UpdateOrderUseCase(mainActivity.getGastroMasterApp().getOrderDataRepository()));

        dishList.setLayoutManager(dishListLayoutManager);
        dishList.setAdapter(dishListViewAdapter);

        ButterKnife.bind(this, rootView);

        btnAddDish.setOnClickListener(
                v -> orderDetailPresenter.onAddDishClick()
        );

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        int orderId = getArguments().getInt("OrderId");
        orderDetailPresenter.init(orderId);
    }

    @Override
    public void goToAddDish(Order order) {
        ((MainActivity)getActivity()).goToDishListView(order.getTableNumber(), order);
    }

    @Override
    public void loadOrder(Order order) {
        txtOrderId.setText(String.valueOf(order.getId()));
        txtOrderDate.setText(order.getDate());
        txtOrderTotalPrice.setText(String.valueOf(order.getTotalPrice()));
        txtWaitressId.setText(String.valueOf(order.getWaitressId()));
        dishListViewAdapter.setList(order.getDishList());
    }

    @Override
    public void onOrderUpdated(int orderId) {
        orderDetailPresenter.init(orderId);
    }

    @Override
    public void onClick(View view, int position) {}

    @Override
    public void onLongClick(View view, int position) {
        orderDetailPresenter.onItemLongClick(dishListViewAdapter.getItemListItem(position));
    }


    public static OrderDetailFragment newInstance() {

        Bundle args = new Bundle();
        OrderDetailFragment fragment = new OrderDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
