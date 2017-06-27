/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.data.request;

import org.junit.Test;

import de.hsb.gastromaster.data.factories.DishFactory;
import de.hsb.gastromaster.data.factories.RequestFactory;
import de.hsb.gastromaster.data.order.dish.Dish;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertNull;


public class RequestTest {
    @Test
    public void givenVoidRequestReturnRequestWhereEntityIsNull() {

        Request<Void> request = RequestFactory.requestVoid();

        assertNull(request.getEntity());
    }

    @Test
    public void givenIDishRequestReturnsRequestWhereEntityIsDish() {

        Request<Dish> request = RequestFactory
                .requestDish(DishFactory.dish());

        assertThat(request.getEntity()).isInstanceOf(Dish.class);

    }
}
