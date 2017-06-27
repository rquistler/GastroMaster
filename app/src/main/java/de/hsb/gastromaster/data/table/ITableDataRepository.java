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
import io.reactivex.Single;

/**
 * The interface Table data repository.
 */
public interface ITableDataRepository {
    /**
     * Gets all tables.
     *
     * @return the all tables
     */
    Single<Response<List<Table>>> getAllTables();
}
