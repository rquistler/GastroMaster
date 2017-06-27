package de.hsb.gastromaster.presentation.ui;

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
    public static final String TABLE_LIST_CLASS_NAME = TableListFragment.class.getSimpleName();
    public static final String ORDER_LIST_CLASS_NAME = OrderListFragment.class.getSimpleName();
    public static final String ORDER_DETAIL_CLASS_NAME = OrderDetailFragment.class.getSimpleName();
    public static final String DISH_LIST_CLASS_NAME = DishListFragment.class.getSimpleName();

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
        getSupportFragmentManager().popBackStackImmediate(ORDER_LIST_CLASS_NAME, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, tableListFragment, TABLE_LIST_CLASS_NAME)
                    .addToBackStack(TABLE_LIST_CLASS_NAME).commit();
    }

    public void goToOrderDetailView(Order order) {
        FragmentManager fm = getSupportFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putInt("OrderId", order.getId());
        orderDetailFragment.setArguments(bundle);
        fm.popBackStackImmediate(DISH_LIST_CLASS_NAME, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        fm.popBackStackImmediate(ORDER_DETAIL_CLASS_NAME, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        fm.beginTransaction()
                .replace(R.id.fragment_container, orderDetailFragment, ORDER_DETAIL_CLASS_NAME)
                .addToBackStack(ORDER_DETAIL_CLASS_NAME).commit();
    }

    public void goToOrderListView(Table table) {
        FragmentManager fm = getSupportFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putString("Table", table.getName());
        orderListFragment.setArguments(bundle);
        fm.popBackStackImmediate(ORDER_DETAIL_CLASS_NAME, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        fm.beginTransaction()
                .replace(R.id.fragment_container, orderListFragment, ORDER_LIST_CLASS_NAME)
                .addToBackStack(ORDER_LIST_CLASS_NAME).commit();
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
        fm.popBackStackImmediate(ORDER_DETAIL_CLASS_NAME, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        fm.beginTransaction()
                .replace(R.id.fragment_container, dishListFragment, DISH_LIST_CLASS_NAME)
                .addToBackStack(DISH_LIST_CLASS_NAME)
                .commit();
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

