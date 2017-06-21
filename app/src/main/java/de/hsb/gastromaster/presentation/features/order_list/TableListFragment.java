package de.hsb.gastromaster.presentation.features.order_list;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import de.hsb.gastromaster.R;
import de.hsb.gastromaster.data.table.Table;

public class TableListFragment extends Fragment implements TableListContract.View {
    private RecyclerView tableList;
    private RecyclerView.Adapter tableListAdapter;
    private RecyclerView.LayoutManager tableListLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_table_list, container, false);

        tableList = (RecyclerView) rootView.findViewById(R.id.table_list);
        tableListLayoutManager = new LinearLayoutManager(getContext());
        ArrayList<Table> items = new ArrayList<>();
        items.add(Table.builder().setId(1).setName("1A").setOrderList(new ArrayList<>()).build());
        items.add(Table.builder().setId(1).setName("2A").setOrderList(new ArrayList<>()).build());
        items.add(Table.builder().setId(1).setName("3A").setOrderList(new ArrayList<>()).build());

/*        tableListAdapter = new TableListViewAdapter(items, new BaseRecyclerViewAdapter.IOnItemClick() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getActivity(),"Item Cllicked", Toast.LENGTH_LONG);
            }
        });*/
        tableListAdapter = new TableListViewAdapterDemo(items, new TableListViewAdapterDemo.IOnItemClick() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getActivity(), "Item clicked", Toast.LENGTH_LONG);
            }
        });


        tableList.setLayoutManager(tableListLayoutManager);
        tableList.setAdapter(tableListAdapter);

        return rootView;
    }
}
