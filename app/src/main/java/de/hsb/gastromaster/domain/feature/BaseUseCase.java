package de.hsb.gastromaster.domain.feature;


import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import io.reactivex.Single;

public abstract class BaseUseCase<T, R> {

    public abstract Single<Response<R>> execute(Request<T> request);

}
