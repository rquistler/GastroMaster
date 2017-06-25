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
import de.hsb.gastromaster.data.order.dish.Dish;
import de.hsb.gastromaster.domain.feature.get_dishes.GetDishesUseCase;
import de.hsb.gastromaster.presentation.features.BaseRecyclerViewAdapter;

public class DishListFragment extends Fragment implements DishListContract.View<Dish>, BaseRecyclerViewAdapter.IOnItemClick {

    private RecyclerView dishList;
    private DishListPresenter dishListPresenter;
    private DishListViewAdapter dishListViewAdapter;
    private RecyclerView.LayoutManager dishListLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dish_list, container, false);

        dishList = (RecyclerView) rootView.findViewById(R.id.dish_list);
        dishListLayoutManager = new LinearLayoutManager(getContext());

        ArrayList<Dish> items = new ArrayList<>();

        dishListViewAdapter = new DishListViewAdapter(items, this);

        dishListPresenter = new DishListPresenter(this,
                new GetDishesUseCase(((GastroMasterApp) getActivity().getApplication()).getOrderDataRepository()));

        dishList.setLayoutManager(dishListLayoutManager);
        dishList.setAdapter(dishListViewAdapter);

        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        int orderId = getArguments().getInt("OrderId");
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
    public void addOrderWithDish(Dish dish) {
//        erstelle neue Order und gehe zu OrderDetail
//        hier im Fragment erzeuge ich die Order mittels usecase und für ihr die tableNumber und den
//        Dish hinzu. Dann wir die OrderDetail mit der neuen Order geladen.
    }

    public static DishListFragment newInstance() {
        
        Bundle args = new Bundle();
        
        DishListFragment fragment = new DishListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onClick(View view, int position) {
        dishListPresenter.onDishClick(dishListViewAdapter.getItemListItem(position), getArguments().getInt("OrderId"));
    }
}
