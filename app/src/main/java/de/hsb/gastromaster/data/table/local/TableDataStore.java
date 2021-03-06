/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.data.table.local;

import java.util.ArrayList;
import java.util.List;

import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.local.IOrderDataStore;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.data.table.Table;
import io.reactivex.Single;


/**
 * The type Table data store.
 */
public class TableDataStore implements ITableDataStore {
    private IOrderDataStore orderDataStore;
    private List<Table> tableList = new ArrayList<>();

    private List<Order> orderList;


    /**
     * Instantiates a new Table data store.
     *
     * @param orderDataStore the order data store
     */
    public TableDataStore(IOrderDataStore orderDataStore) {
        this.orderDataStore = orderDataStore;
    }

    /**
     * Init.
     */
    public void init() {
        tableList.add(Table.builder().setId(1).setName("1A").setOrderList(new ArrayList<Order>()).build());
        tableList.add(Table.builder().setId(2).setName("2A").setOrderList(new ArrayList<Order>()).build());
        tableList.add(Table.builder().setId(3).setName("3A").setOrderList(new ArrayList<Order>()).build());
        tableList.add(Table.builder().setId(4).setName("4A").setOrderList(new ArrayList<Order>()).build());

        orderDataStore.getAllOrder()
                .subscribe((listResponse, throwable) -> {
                    orderList = listResponse.getEntity();

                });
    }

    /**
     * Match orders with tables.
     */
    public void matchOrdersWithTables() {
        for (Table table : tableList) {
            for (Order order : orderList) {
                if (table.getName().equals(order.getTableNumber())) {
                    table.getOrderList().add(order);
                }
            }
        }
    }

    private void updateOrders() {
        orderDataStore.getAllOrder()
                .subscribe((listResponse, throwable) -> {
                    orderList = listResponse.getEntity();

                });

        for (Table table : tableList) {
            table.getOrderList().clear();
        }
        matchOrdersWithTables();
    }

    @Override
    public Single<Response<List<Table>>> getAllTables() {
        updateOrders();
        return Single.create(singleEmitter -> {

            singleEmitter.onSuccess(
                    Response.<List<Table>>builder()
                            .setEntity(new ArrayList<>(tableList))
                            .setIsSuccessful(true)
                            .build());


        });
    }
}
