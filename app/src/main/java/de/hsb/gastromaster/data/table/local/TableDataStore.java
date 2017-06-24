package de.hsb.gastromaster.data.table.local;

import android.support.design.widget.TabLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.dish.Dish;
import de.hsb.gastromaster.data.order.local.IOrderDataStore;
import de.hsb.gastromaster.data.order.local.OrderDataStore;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.data.table.Table;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;


public class TableDataStore implements ITableDataStore {
    private IOrderDataStore orderDataStore;
    private List<Table> tableList = new ArrayList<>();

    private List<Order> orderList;


    public TableDataStore(IOrderDataStore orderDataStore) {
        this.orderDataStore = orderDataStore;
    }

    public void init(){
        tableList.add(Table.builder().setId(1).setName("1A").setOrderList(new ArrayList<Order>()).build());
        tableList.add(Table.builder().setId(2).setName("2A").setOrderList(new ArrayList<Order>()).build());
        tableList.add(Table.builder().setId(3).setName("3A").setOrderList(new ArrayList<Order>()).build());
        tableList.add(Table.builder().setId(4).setName("4A").setOrderList(new ArrayList<Order>()).build());

        orderDataStore.getAllOrder()
                .subscribe((listResponse, throwable) -> {
                    orderList = listResponse.getEntity();

                });
        matchOrdersWithTables();
    }

    public void matchOrdersWithTables(){
        for (Table table : tableList) {
            for (Order order : orderList) {
               if (table.getName().equals(order.getTableNumber())){
                   table.getOrderList().add(order);
               }
            }
        }
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
