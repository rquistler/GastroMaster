/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.data.response;


import org.junit.Before;
import org.junit.Test;

import de.hsb.gastromaster.data.factories.DishFactory;
import de.hsb.gastromaster.data.factories.ResponseFactory;
import de.hsb.gastromaster.data.order.dish.Dish;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * The type Response test.
 */
public class ResponseTest {

    /**
     * The Actual.
     */
    Response<Dish> actual;

    /**
     * Sets .
     */
    @Before
    public void setup() {

        actual = ResponseFactory.responseDishError(DishFactory.dish(), "Error");
    }

    /**
     * Given void response return respone where entity is null.
     */
    @Test
    public void givenVoidResponseReturnResponeWhereEntityIsNull() {

        Response<Void> actualVoid = ResponseFactory.responseVoid();

        assertNull(actualVoid.getEntity());
    }

    /**
     * Given i dish response returns response where entity is dish.
     */
    @Test
    public void givenIDishResponseReturnsResponseWhereEntityIsDish() {
        assertThat(actual.getEntity(), instanceOf(Dish.class));
    }
}
