package de.hsb.gastromaster.data.table;

import java.util.List;

import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.data.table.local.ITableDataStore;
import io.reactivex.Single;

/**
 * Created by roman on 13/06/17.
 */

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
