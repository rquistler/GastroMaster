package de.hsb.gastromaster.presentation.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import de.hsb.gastromaster.R;
import de.hsb.gastromaster.data.table.Table;
import de.hsb.gastromaster.presentation.features.table_list.TableListFragment;


public class MainActivity extends AppCompatActivity {
    protected Fragment tableList;
    protected Fragment orderDetail;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String tableListClassName = TableListFragment.class.getSimpleName();

        tableList = TableListFragment.newInstance();


        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, tableList, tableListClassName)
                .addToBackStack(tableListClassName).commit();
    }

    @Override
    public void onBackPressed(){}

    public void goToOrderListView(Table item) {
        // FragmantManager wechseln zu OrderListView
        String orderDetailClassName = "";//XXX.class.getSimpleName();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, orderDetail, orderDetailClassName)
                .addToBackStack(orderDetailClassName).commit();
    }
}

