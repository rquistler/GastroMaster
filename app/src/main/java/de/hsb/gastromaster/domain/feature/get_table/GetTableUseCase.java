/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.domain.feature.get_table;

import java.util.List;

import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.data.table.ITableDataRepository;
import de.hsb.gastromaster.data.table.Table;
import de.hsb.gastromaster.domain.feature.BaseUseCase;
import io.reactivex.Single;


/**
 * The type Get table use case.
 */
public class GetTableUseCase extends BaseUseCase<Void, List<Table>> {

    private ITableDataRepository tableDataRepository;

    /**
     * Instantiates a new Get table use case.
     *
     * @param dataRepository the data repository
     */
    public GetTableUseCase(ITableDataRepository dataRepository) {
        tableDataRepository = dataRepository;
    }

    @Override
    public Single<Response<List<Table>>> execute(Request<Void> request) {
        return tableDataRepository.getAllTables();
    }


}
