package de.hsb.gastromaster.presentation.features.create_order;


import de.hsb.gastromaster.data.order.IOrder;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.domain.feature.BaseUseCase;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;

public class CreateOrderPresenter
        implements CreateOrderContract.Presenter {

    private CreateOrderContract.View view;
    private BaseUseCase<IOrder, Void> createOrderUseCase;
    private CompositeDisposable disposeBag = new CompositeDisposable();

    public CreateOrderPresenter(CreateOrderContract.View view,
                                BaseUseCase<IOrder, Void> createOrderUseCase) {
        this.view = view;
        this.createOrderUseCase = createOrderUseCase;
    }

    @Override
    public void init() {
    }

    @Override
    public void createOrder(IOrder order) {

        DisposableSingleObserver<Response<Void>> disposable = createOrderUseCase
                .execute(new Request<>(order))
                .subscribeWith(new DisposableSingleObserver<Response<Void>>() {
                    @Override
                    public void onSuccess(Response<Void> voidResponse) {
                            view.showMessage("Successful: " + String.valueOf(voidResponse.isSuccessful()));
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }
                });

        disposeBag.add(disposable);

    }
}
