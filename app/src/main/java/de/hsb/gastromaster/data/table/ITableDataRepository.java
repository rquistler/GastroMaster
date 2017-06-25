package de.hsb.gastromaster.data.table;

import java.util.List;

import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.response.Response;
import io.reactivex.Single;

public interface ITableDataRepository {
    Single<Response<List<Table>>> getAllTables();
}
