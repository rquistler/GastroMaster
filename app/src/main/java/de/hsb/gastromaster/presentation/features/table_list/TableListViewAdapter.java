/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.presentation.features.table_list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hsb.gastromaster.R;
import de.hsb.gastromaster.data.table.Table;
import de.hsb.gastromaster.presentation.features.BaseRecyclerViewAdapter;

public class TableListViewAdapter extends BaseRecyclerViewAdapter<Table> {

    /**
     * The Txt table number.
     */
    @BindView(R.id.txtTableNumber)
    TextView txtTableNumber;

    /**
     * The Txt number orders.
     */
    @BindView(R.id.txtNumberOrders)
    TextView txtNumberOrders;

    /**
     * Instantiates a new Table list view adapter.
     *
     * @param itemList the item list
     * @param listener the listener
     */
    public TableListViewAdapter(List<Table> itemList,
                                IOnItemClick listener) {

        super(itemList, listener);
    }

    @Override
    protected View createView(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_table_list_item, parent, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void bindItem(Table item, RecyclerView.ViewHolder viewHolder) {
        txtTableNumber.setText(item.getName());
        txtNumberOrders.setText(String.valueOf(item.getTotalOrders()));
    }


}
