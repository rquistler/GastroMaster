package de.hsb.gastromaster.data.table.local;

import android.support.design.widget.TabLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.hsb.gastromaster.data.order.dish.Dish;
import de.hsb.gastromaster.data.order.local.IOrderDataStore;
import de.hsb.gastromaster.data.order.local.OrderDataStore;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.data.table.Table;
import io.reactivex.Single;

/**
 * Created by roman on 13/06/17.
 */

public class TableDataStore implements ITableDataStore {

    private List<Table> tableList = new ArrayList<>();

    public TableDataStore() {

    }

    @Override
    public Single<Response<List<Table>>> getAllTables() {

        return Single.create(singleEmitter -> {

            singleEmitter.onSuccess(
                    Response.<List<Table>>builder()
                            .setEntity(new ArrayList<>(tableList))
                            .setIsSuccessful(true)
                            .build());


        });
    }
}
