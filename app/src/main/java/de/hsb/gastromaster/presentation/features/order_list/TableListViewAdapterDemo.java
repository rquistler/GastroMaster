package de.hsb.gastromaster.presentation.features.order_list;

import android.support.annotation.StringDef;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hsb.gastromaster.R;
import de.hsb.gastromaster.data.table.Table;

/**
 * Created by roman on 13/06/17.
 */

public class TableListViewAdapterDemo extends RecyclerView
        .Adapter<TableListViewAdapterDemo.TableListViewViewHolder> {

    private IOnItemClick listener;
    private List<Table> tableList = Collections.emptyList();

    public TableListViewAdapterDemo(List<Table> tableList,
                                    IOnItemClick listener) {

        this.tableList = tableList;
        this.listener = listener;
    }

    @Override
    public TableListViewViewHolder onCreateViewHolder(ViewGroup viewGroup,
                                                      int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fragment_table_list_item, viewGroup, false);

        return new TableListViewViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(TableListViewViewHolder tableListViewViewHolder,
                                 int i) {

        tableListViewViewHolder.bindTable(tableList.get(i));

    }

    public void setOnClickListener(IOnItemClick listener){
        this.listener = listener;
    }

    public void addTables(@ListPosition String position,
                           ArrayList<Table> items){

        for (Table item : items) {
            addTable(position, item);
        }
    }

    public void addTable(@ListPosition String position, Table item) {

        if(tableList.contains(item)) {
            return;
        }

        switch (position) {
            case TOP:
                tableList.add(0, item);
                notifyItemInserted(0);
                break;
            case BOTTOM:
                tableList.add(item);
                notifyItemInserted(tableList.size() - 1);
                break;
        }
        //notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return tableList.size();
    }

    public Table getTableListItem(int position){

        return ((tableList != null
                && position < tableList.size())
                ? tableList.get(position) : null);
    }

    // ------------------------------------------
    // ViewHolder
    // ------------------------------------------
    static class TableListViewViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private IOnItemClick listener;

        @BindView(R.id.txtTableNumber)
        TextView txtTableNumber;
        @BindView(R.id.txtNumberOrders)
        TextView txtNumberOrders;

        public TableListViewViewHolder(View view,
                                       IOnItemClick listener) {
            super(view);

            ButterKnife.bind(this, view);

            this.listener = listener;

            view.setOnClickListener(this);
        }

        public void bindTable(Table table){
            txtTableNumber.setText(table.getName());
            txtNumberOrders.setText(String.valueOf(table.getTotalOrders()));
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }

    }

    public interface IOnItemClick {
        void onClick(View view, int position);
    }



    @StringDef({TOP, BOTTOM})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ListPosition {}

    public static final String TOP = "TOP";
    public static final String BOTTOM = "Bottom";
}
