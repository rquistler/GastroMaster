package de.hsb.gastromaster.presentation.features.table_list;


import java.util.List;

import de.hsb.gastromaster.data.table.Table;

/**
 * The interface Table list contract.
 */
public interface TableListContract{

    /**
     * The interface View.
     *
     * @param <T> the type parameter
     */
    interface View<T> {
        /**
         * Go to order list.
         *
         * @param item the item
         */
        void goToOrderList(T item);

        /**
         * Sets table list.
         *
         * @param tables the tables
         */
        void setTableList(List<Table> tables);
    }

    /**
     * The interface Presenter.
     *
     * @param <T> the type parameter
     */
    interface Presenter<T> {
        /**
         * On item click.
         *
         * @param item the item
         */
        void onItemClick(T item);

        /**
         * Init.
         */
        void init();
    }
}
