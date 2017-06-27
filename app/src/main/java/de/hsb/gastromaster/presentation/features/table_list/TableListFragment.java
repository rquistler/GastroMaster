package de.hsb.gastromaster.presentation.features.table_list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import de.hsb.gastromaster.GastroMasterApp;
import de.hsb.gastromaster.R;
import de.hsb.gastromaster.data.table.Table;
import de.hsb.gastromaster.data.table.TableDataRepository;
import de.hsb.gastromaster.data.table.local.TableDataStore;
import de.hsb.gastromaster.domain.feature.get_table.GetTableUseCase;
import de.hsb.gastromaster.presentation.features.BaseRecyclerViewAdapter;
import de.hsb.gastromaster.presentation.ui.MainActivity;

/**
 * The type Table list fragment.
 */
public class TableListFragment extends Fragment implements
        TableListContract.View<Table>, BaseRecyclerViewAdapter.IOnItemClick {

    private RecyclerView tableList;
    private TableListContract.Presenter<Table> tableListPresenter;
    private TableListViewAdapter tableListAdapter;
    private RecyclerView.LayoutManager tableListLayoutManager;

    /**
     * New instance table list fragment.
     *
     * @return the table list fragment
     */
    public static TableListFragment newInstance() {

        Bundle args = new Bundle();
        TableListFragment fragment = new TableListFragment();

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_table_list, container, false);

        MainActivity mainActivity = (MainActivity) getActivity();

        tableList = (RecyclerView) rootView.findViewById(R.id.table_list);
        tableListLayoutManager = new LinearLayoutManager(getContext());

        ArrayList<Table> items = new ArrayList<>();

        tableListAdapter = new TableListViewAdapter(items,this);
        tableListPresenter = new TableListPresenter(this,
                new GetTableUseCase(mainActivity.getGastroMasterApp().getTableDataRepository()));

        tableList.setLayoutManager(tableListLayoutManager);
        tableList.setAdapter(tableListAdapter);

        return rootView;
    }

    @Override
    public void onResume() {
        tableListPresenter.init();
        super.onResume();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tableListPresenter.init();
    }

    @Override
    public void onClick(View view, int position) {
        tableListPresenter.onItemClick(tableListAdapter.getItemListItem(position));
    }

    @Override
    public void onLongClick(View view, int position) {

    }

    @Override
    public void goToOrderList(Table item) {
        ((MainActivity) getActivity()).goToOrderListView(item);
    }

    @Override
    public void setTableList(List<Table> tables) {
        tableListAdapter.setList(tables);
    }
}
