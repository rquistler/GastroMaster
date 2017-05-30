package de.hsb.gastromaster;

/**
 * Created by Gautama on 30/05/2017.
 */

import android.app.*;
import android.content.*;
import android.view.*;
import android.widget.*;

import java.util.ArrayList;


public class AddDishAdapter extends ArrayAdapter<Dish> {
    Context context;
    int layoutResourceId;
    ArrayList<Dish> dishList;

    // DishListAdapter CONSTRUCTOR
    public AddDishAdapter( Context context, int layoutResourceId, ArrayList<Dish> dishList ) {
        super( context, layoutResourceId, dishList );

        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.dishList = dishList;
    }

    @Override
    public View getView( int position, View convertView, ViewGroup parent ) {
        View row           = convertView;
        DishHolder holder = null;

        if( row == null ) {
            LayoutInflater inflater = ( ( Activity )context ).getLayoutInflater();
            row = inflater.inflate( layoutResourceId, parent, false );

            holder = new DishHolder();
            holder.dishName = ( TextView )row.findViewById( R.id.dishName );

            row.setTag( holder );
        } else {
            holder = ( DishHolder )row.getTag();
        }

        Dish dish = dishList.get( position );
        holder.dishName.setText( dish.dishName );

        return ( row );
    }

    static class DishHolder {
        TextView dishName;
    }
}