package de.hsb.gastromaster.presentation.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import de.hsb.gastromaster.R;
import de.hsb.gastromaster.presentation.features.order_list.TableListFragment;


public class MainActivity extends AppCompatActivity {
    protected Fragment tableList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableList = new TableListFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, tableList, tableList.getClass().getSimpleName())
                .addToBackStack(null).commit();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}

