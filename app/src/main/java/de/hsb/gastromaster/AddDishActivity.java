package de.hsb.gastromaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.R.id.list;


/**
 * Created by Gautama on 30/05/2017.
 */



public class AddDishActivity extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTV;
    private TextView dishName;
    final String[] dishAC = {"pizza ", "coca","carrot", "burger"};
    private ListView dishAddedList;
    private ArrayList<Dish> dishList;
    private AddDishAdapter addDishAdapter;
    private Button dishAddButton;
    int itemCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_dish_layout);


        dishAddedList = (ListView) findViewById(R.id.listDish);
        autoCompleteTV = (AutoCompleteTextView) findViewById(R.id.autoCompleteTVaddDish);
        dishName = (TextView) findViewById(R.id.dishName);
        dishAddButton = (Button) findViewById(R.id.buttonAddDish);

        //AutoCompletion part______________________________
        ArrayAdapter adapterACDish = new ArrayAdapter(this,android.R.layout.simple_list_item_1,dishAC);
        autoCompleteTV.setAdapter(adapterACDish);
        autoCompleteTV.setThreshold(1);
        //_________________________________________________

        dishList = new ArrayList<Dish>();
        addDishAdapter = new AddDishAdapter(this, R.layout.dish_layout, dishList);
        dishAddedList.setAdapter(addDishAdapter);

        itemCount = 0;
        dishAddButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                dishList.add( new Dish( autoCompleteTV.getText().toString()));
                autoCompleteTV.setText("");
                addDishAdapter.notifyDataSetChanged();
                itemCount++;
            }
        });


    }
}


