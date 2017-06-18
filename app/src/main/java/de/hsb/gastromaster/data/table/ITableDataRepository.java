package de.hsb.gastromaster.data.table;

import java.util.List;

import de.hsb.gastromaster.data.response.Response;
import io.reactivex.Single;

/**
 * Created by roman on 13/06/17.
 */

public interface ITableDataRepository {
    Single<Response<List<Table>>> getAllTables();
}
