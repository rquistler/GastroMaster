package de.hsb.gastromaster.domain.feature;


import de.hsb.gastromaster.data.request.Request;
import de.hsb.gastromaster.data.response.Response;
import io.reactivex.Single;

/**
 * The type Base use case.
 *
 * @param <T> the type parameter
 * @param <R> the type parameter
 */
public abstract class BaseUseCase<T, R> {

    /**
     * Execute single.
     *
     * @param request the request
     * @return the single
     */
    public abstract Single<Response<R>> execute(Request<T> request);

}
