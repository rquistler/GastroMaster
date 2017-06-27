package de.hsb.gastromaster.data.table.local;

import java.util.List;

import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.data.table.Table;
import io.reactivex.Single;

/**
 * Created by roman on 13/06/17.
 */
public interface ITableDataStore {

    /**
     * Gets all tables.
     *
     * @return the all tables
     */
    Single<Response<List<Table>>> getAllTables();
}
