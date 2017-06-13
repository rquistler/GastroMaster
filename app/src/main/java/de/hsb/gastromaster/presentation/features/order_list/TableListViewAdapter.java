package de.hsb.gastromaster.presentation.features.order_list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import de.hsb.gastromaster.R;
import de.hsb.gastromaster.data.table.Table;
import de.hsb.gastromaster.presentation.features.BaseRecyclerViewAdapter;

/**
 * Created by roman on 14/06/17.
 */

public class TableListViewAdapter extends BaseRecyclerViewAdapter<Table> {

    @BindView(R.id.txtTableNumber)
    TextView txtTableNumber;

    @BindView(R.id.txtNumberOrders)
    TextView txtNumberOrders;

    public TableListViewAdapter(List<Table> itemList,
                                IOnItemClick listener) {

        super(itemList, listener);
    }

    @Override
    protected View createView(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_table_list_item, parent);

        return view;
    }

    @Override
    protected void bindItem(Table item, RecyclerView.ViewHolder viewHolder) {

        txtTableNumber.setText(item.getName());
        txtNumberOrders.setText(String.valueOf(item.getTotalOrders()));
    }
}
