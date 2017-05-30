package de.hsb.gastromaster;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    AddDishActivity addDishActivity = new AddDishActivity();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView mListView = (ListView) findViewById(R.id.listView);

        List<Table> tables = generateTable();

        TableAdapter adapter = new TableAdapter(MainActivity.this, tables);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(view.getContext(), AddDishActivity.class);
                startActivityForResult(myIntent, 0);

            }
        });
    }

    public void addDish(View view){
        Intent startAddDishActivity = new Intent(this, AddDishActivity.class);
        startActivity(startAddDishActivity);
    }

    private List<Table> generateTable() {
        List<Table> tables = new ArrayList<Table>();
        tables.add(new Table("Table Number: ", 1, "Number of Dishes: ", addDishActivity.itemCount));
        tables.add(new Table("Table Number: ", 2, "Number of Dishes: ", 3));
        tables.add(new Table("Table Number: ", 3, "Number of Dishes: ", 3));
        tables.add(new Table("Table Number: ", 4, "Number of Dishes: ", 3));
        tables.add(new Table("Table Number: ", 5, "Number of Dishes: ", 3));


        return tables;

    }




}
