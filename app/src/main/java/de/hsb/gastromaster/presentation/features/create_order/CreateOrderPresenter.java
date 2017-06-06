package de.hsb.gastromaster.presentation.features.create_order;


import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.domain.feature.BaseUseCase;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;

public class CreateOrderPresenter
        implements CreateOrderContract.Presenter {

    private CreateOrderContract.View view;
    private BaseUseCase<Order, Void> createOrderUseCase;
    private CompositeDisposable disposeBag = new CompositeDisposable();

    public CreateOrderPresenter(CreateOrderContract.View view,
                                BaseUseCase<Order, Void> createOrderUseCase) {
        this.view = view;
        this.createOrderUseCase = createOrderUseCase;
    }

    @Override
    public void init() {
    }

    @Override
    public void createOrder(Order order) {

        DisposableSingleObserver<Response<Void>> disposable = createOrderExecute(order)
                .subscribeWith(new DisposableSingleObserver<Response<Void>>() {
                    @Override
                    public void onSuccess(Response<Void> voidResponse) {
                        view.showMessage("Successful: " + String.valueOf(voidResponse.getIsSuccessful()));
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }
                });

        disposeBag.add(disposable);

    }

    public Single<Response<Void>> createOrderExecute(Order order){
        return createOrderUseCase.execute(Request.<Order>builder().setEntity(order).build());
    }
}
