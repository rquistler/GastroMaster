package de.hsb.gastromaster.data.table;

import java.util.List;

import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.local.IOrderDataStore;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.data.table.local.ITableDataStore;
import io.reactivex.Single;


public class TableDataRepository implements ITableDataRepository {

    private ITableDataStore tableDataStore;

    public TableDataRepository(ITableDataStore tableDataStore) {
        this.tableDataStore = tableDataStore;
    }

    @Override
    public Single<Response<List<Table>>> getAllTables(){
        return tableDataStore.getAllTables();
    }
}
