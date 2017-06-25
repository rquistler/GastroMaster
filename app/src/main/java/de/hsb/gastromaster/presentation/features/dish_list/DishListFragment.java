package de.hsb.gastromaster.presentation.features.dish_list;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import de.hsb.gastromaster.GastroMasterApp;
import de.hsb.gastromaster.R;
import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.dish.Dish;
import de.hsb.gastromaster.domain.feature.create_order.CreateOrderUseCase;
import de.hsb.gastromaster.domain.feature.get_dishes.GetDishesUseCase;
import de.hsb.gastromaster.presentation.features.BaseRecyclerViewAdapter;
import de.hsb.gastromaster.presentation.ui.MainActivity;

public class DishListFragment extends Fragment implements DishListContract.View<Dish>, BaseRecyclerViewAdapter.IOnItemClick {

    private RecyclerView dishList;
    private DishListPresenter dishListPresenter;
    private DishListViewAdapter dishListViewAdapter;
    private RecyclerView.LayoutManager dishListLayoutManager;

    private int orderId;
    private String tableNumber;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dish_list, container, false);

        dishList = (RecyclerView) rootView.findViewById(R.id.dish_list);
        dishListLayoutManager = new LinearLayoutManager(getContext());

        ArrayList<Dish> items = new ArrayList<>();

        dishListViewAdapter = new DishListViewAdapter(items, this);

        dishListPresenter = new DishListPresenter(this,
                new GetDishesUseCase(((GastroMasterApp) getActivity().getApplication()).getOrderDataRepository()),
                new CreateOrderUseCase(((GastroMasterApp) getActivity().getApplication()).getOrderDataRepository()));

        dishList.setLayoutManager(dishListLayoutManager);
        dishList.setAdapter(dishListViewAdapter);

        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        orderId = getArguments().getInt("OrderId");
        tableNumber = getArguments().getString("Table");
        dishListPresenter.init(orderId);
    }


    @Override
    public void onAddDishClick(Dish dish) {

    }

    @Override
    public void setDishList(List<Dish> dishes) {
        dishListViewAdapter.setList(dishes);
    }

    @Override
    public void newOrderAdded(Order newOrder) {
        ((MainActivity)getActivity()).goToOrderDetailView(newOrder);
    }


    public static DishListFragment newInstance() {
        
        Bundle args = new Bundle();
        
        DishListFragment fragment = new DishListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onClick(View view, int position) {
        dishListPresenter.onDishClick(tableNumber, dishListViewAdapter.getItemListItem(position), getArguments().getInt("OrderId"));
    }
}
