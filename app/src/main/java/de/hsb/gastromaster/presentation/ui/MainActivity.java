package de.hsb.gastromaster.presentation.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import de.hsb.gastromaster.R;
import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.table.Table;
import de.hsb.gastromaster.presentation.features.order_list.OrderListFragment;
import de.hsb.gastromaster.presentation.features.table_list.TableListFragment;


public class MainActivity extends AppCompatActivity {
    protected final String tableListClassName = TableListFragment.class.getSimpleName();
    protected final String orderListClassName = OrderListFragment.class.getSimpleName();
    private String currentShownFragment = null;

    protected Fragment tableList;
    protected Fragment orderDetail;
    protected Fragment orderList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableList = TableListFragment.newInstance();
        orderList = OrderListFragment.newInstance();
        //orderDetail = OrderDetailFragment.newInstance();

        goToTableListView();
    }

    private void goToTableListView() {
        FragmentManager fm = getSupportFragmentManager();
        hideAllFragmentsFromBackStack();
        if(isFragmentPresent(tableListClassName)){
            fm.beginTransaction()
                    .show(tableList).commit();
        }
        else{
            getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, tableList, tableListClassName)
                .addToBackStack(tableListClassName).commit();
        }
        currentShownFragment = tableListClassName;
    }

    @Override
    public void onBackPressed(){
        if (currentShownFragment.equals(orderListClassName)){
            goToTableListView();
        }
    }

    public boolean isFragmentPresent(String tag) {
        Fragment frag = getSupportFragmentManager().findFragmentByTag(tag);
        if (frag == null) {
            return false;
        } else
            return true;
    }

    public void goToOrderListView(Table table) {
        FragmentManager fm = getSupportFragmentManager();
        hideAllFragmentsFromBackStack();

        if(isFragmentPresent(orderListClassName)){
            fm.beginTransaction()
                    .show(orderList).commit();
        }
        else{
            fm.beginTransaction()
                    .hide(tableList)
                    .add(R.id.fragment_container, orderList, orderListClassName)
                    .addToBackStack(orderListClassName).commit();
        }
        currentShownFragment = orderListClassName;
    }

    public void hideAllFragmentsFromBackStack(){
        FragmentManager fm = getSupportFragmentManager();
        for (Fragment fragment : fm.getFragments()) {
            fm.beginTransaction().hide(fragment).commit();
        }
    }
}

