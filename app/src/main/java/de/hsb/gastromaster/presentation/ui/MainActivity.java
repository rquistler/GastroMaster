package de.hsb.gastromaster.presentation.ui;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import de.hsb.gastromaster.GastroMasterApp;
import de.hsb.gastromaster.R;
import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.table.Table;
import de.hsb.gastromaster.presentation.features.dish_list.DishListFragment;
import de.hsb.gastromaster.presentation.features.order_detail.OrderDetailFragment;
import de.hsb.gastromaster.presentation.features.order_list.OrderListFragment;
import de.hsb.gastromaster.presentation.features.table_list.TableListFragment;


public class MainActivity extends AppCompatActivity {
    protected final String tableListClassName = TableListFragment.class.getSimpleName();
    protected final String orderListClassName = OrderListFragment.class.getSimpleName();
    protected final String orderDetailClassName = OrderDetailFragment.class.getSimpleName();
    protected final String dishListClassName = DishListFragment.class.getSimpleName();

    protected Fragment tableListFragment;
    protected Fragment orderListFragment;
    protected Fragment orderDetailFragment;
    protected Fragment dishListFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableListFragment = TableListFragment.newInstance();
        orderListFragment = OrderListFragment.newInstance();
        orderDetailFragment = OrderDetailFragment.newInstance();
        dishListFragment = DishListFragment.newInstance();
        goToTableListView();
    }
    public void goToTableListView() {
        getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, tableListFragment, tableListClassName)
                    .addToBackStack(tableListClassName).commit();
    }

    public void goToOrderDetailView(Order order) {
        FragmentManager fm = getSupportFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putInt("OrderId", order.getId());
        orderDetailFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, orderDetailFragment, orderDetailClassName)
                .addToBackStack(orderDetailClassName).commit();
    }

    public void goToOrderListView(Table table) {
        FragmentManager fm = getSupportFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putString("Table", table.getName());
        orderListFragment.setArguments(bundle);

        fm.beginTransaction()
                .replace(R.id.fragment_container, orderListFragment, orderListClassName)
                .addToBackStack(orderListClassName).commit();
    }

    public void goToDishListView(String tableNumber, Order order) {
        FragmentManager fm = getSupportFragmentManager();
        Bundle bundle = new Bundle();
        if (order != null) {
            bundle.putInt("OrderId", order.getId());
            bundle.putString("Table", order.getTableNumber());
        }
        else{
            bundle.putInt("OrderId", -1);
            bundle.putString("Table", tableNumber);
        }
        dishListFragment.setArguments(bundle);

        fm.beginTransaction()
                .replace(R.id.fragment_container, dishListFragment, dishListClassName)
                .addToBackStack(dishListClassName).commit();
    }

    @Override
    public void onBackPressed(){
        if (getSupportFragmentManager().getBackStackEntryCount() == 1){
            finish();
        }
        getSupportFragmentManager().popBackStack();
    }



    public GastroMasterApp getGastroMasterApp(){
        return (((GastroMasterApp) getApplication()));
    }
}

