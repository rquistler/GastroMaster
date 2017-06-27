package de.hsb.gastromaster.data.table;

import java.util.List;

import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.local.IOrderDataStore;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.data.table.local.ITableDataStore;
import io.reactivex.Single;


/**
 * The type Table data repository.
 */
public class TableDataRepository implements ITableDataRepository {

    private ITableDataStore tableDataStore;

    /**
     * Instantiates a new Table data repository.
     *
     * @param tableDataStore the table data store
     */
    public TableDataRepository(ITableDataStore tableDataStore) {
        this.tableDataStore = tableDataStore;
    }

    @Override
    public Single<Response<List<Table>>> getAllTables(){
        return tableDataStore.getAllTables();
    }
}
