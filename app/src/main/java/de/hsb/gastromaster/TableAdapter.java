package de.hsb.gastromaster;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Gautama on 05/05/2017.
 */

public class TableAdapter extends ArrayAdapter<Table> {

    public TableAdapter(Context context, List<Table> tables){
        super(context, 0, tables);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_table, parent, false);
        }

        TableViewHolder viewHolder = (TableViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new TableViewHolder();
            viewHolder.tableNText = (TextView) convertView.findViewById(R.id.tvTableNText);
            viewHolder.tableN = (TextView) convertView.findViewById(R.id.tvTableN);
            viewHolder.numberOfDishText = (TextView) convertView.findViewById(R.id.tvNumberofDishText);
            viewHolder.numberOfDish = (TextView) convertView.findViewById(R.id.tvNumberofDish);
            convertView.setTag(viewHolder);
        }

        Table table = getItem(position);

        viewHolder.tableNText.setText(table.getTableNumberText());
        viewHolder.tableN.setText(String.valueOf(table.getTableNumber()));
        viewHolder.numberOfDishText.setText(table.getNumberOfDishText());
        viewHolder.numberOfDish.setText(String.valueOf(table.getNumberOfDish()));



        return convertView;
    }

    private class TableViewHolder{
        public TextView tableNText;
        public TextView tableN;
        public TextView numberOfDishText;
        public TextView numberOfDish;


    }

}
