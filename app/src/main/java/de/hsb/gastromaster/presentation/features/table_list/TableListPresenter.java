package de.hsb.gastromaster.presentation.features.table_list;

import java.util.List;

import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.data.table.Table;
import de.hsb.gastromaster.domain.feature.get_table.GetTableUseCase;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class TableListPresenter implements TableListContract.Presenter<Table> {

    private TableListContract.View<Table> fragment;
    private GetTableUseCase useCase;

    public TableListPresenter(TableListContract.View<Table> fragment,
                              GetTableUseCase useCase){
        this.useCase = useCase;
        this.fragment = fragment;
    }

    @Override
    public void onItemClick(Table item) {
        fragment.goToOrderList(item);
    }

    @Override
    public void init(){

        loadTableList();

    }

    public void loadTableList() {

        SingleObserver<Response<List<Table>>> tables = useCase
                .execute(Request.<Void>builder()
                        .setEntity(null)
                        .build())
                .subscribeWith(new SingleObserver<Response<List<Table>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Response<List<Table>> listResponse) {
                            fragment.setTableList(listResponse.getEntity());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
