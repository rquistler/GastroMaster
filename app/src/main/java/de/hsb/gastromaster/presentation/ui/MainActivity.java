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
import de.hsb.gastromaster.presentation.features.order_list.OrderListFragment;
import de.hsb.gastromaster.presentation.features.table_list.TableListFragment;


public class MainActivity extends AppCompatActivity {
    protected final String tableListClassName = TableListFragment.class.getSimpleName();
    protected final String orderListClassName = OrderListFragment.class.getSimpleName();

    protected Fragment tableList;
    protected Fragment orderList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableList = TableListFragment.newInstance();
        orderList = OrderListFragment.newInstance();

        goToTableListView();
    }

    private void goToTableListView() {
        getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, tableList, tableListClassName)
                    .addToBackStack(tableListClassName).commit();
    }

    @Override
    public void onBackPressed(){
        if (getSupportFragmentManager().getBackStackEntryCount() == 1){
            finish();
        }
        getSupportFragmentManager().popBackStack();
    }

    public void goToOrderListView(Table table) {
        FragmentManager fm = getSupportFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putString("Table", table.getName());
        orderList.setArguments(bundle);

        fm.beginTransaction()
                .hide(tableList)
                .replace(R.id.fragment_container, orderList, orderListClassName)
                .addToBackStack(orderListClassName).commit();
    }

    public GastroMasterApp getGastroMasterApp(){
        return (((GastroMasterApp) getApplication()));
    }
}

