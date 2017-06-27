/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.data.table;

import java.util.List;

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
    public Single<Response<List<Table>>> getAllTables() {
        return tableDataStore.getAllTables();
    }
}
