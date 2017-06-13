package de.hsb.gastromaster.domain.feature.get_table;

import java.util.List;

import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.data.table.ITableDataRepository;
import de.hsb.gastromaster.data.table.Table;
import de.hsb.gastromaster.domain.feature.BaseUseCase;
import io.reactivex.Single;

/**
 * Created by roman on 13/06/17.
 */

public class GetTableUseUseCase extends BaseUseCase<Void, List<Table>> {

    private ITableDataRepository tableDataRepository;

    @Override
    public Single<Response<List<Table>>> execute(Request<Void> request) {
        return tableDataRepository.getAllTables();
    }


}
