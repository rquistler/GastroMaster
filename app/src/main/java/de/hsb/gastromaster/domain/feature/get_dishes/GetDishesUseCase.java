package de.hsb.gastromaster.domain.feature.get_dishes;

import java.util.List;

import de.hsb.gastromaster.data.order.IOrderDataRepository;
import de.hsb.gastromaster.data.order.dish.Dish;
import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import de.hsb.gastromaster.domain.feature.BaseUseCase;
import io.reactivex.Single;


public class GetDishesUseCase extends BaseUseCase<Void, List<Dish>> {
    private IOrderDataRepository orderDataRepository;

    public GetDishesUseCase(IOrderDataRepository orderDataRepository) {
        this.orderDataRepository = orderDataRepository;
    }

    @Override
    public Single<Response<List<Dish>>> execute(Request<Void> request) {
        return orderDataRepository.getAllDishes(request);
    }
}
