package de.hsb.gastromaster.presentation.features.table_list;


import java.util.List;

import de.hsb.gastromaster.data.table.Table;

public interface TableListContract{

    interface View<T> {
        void goToOrderList(T item);
        void setTableList(List<Table> tables);
    }

    interface Presenter<T> {
        void onItemClick(T item);
        void init();
    }
}
