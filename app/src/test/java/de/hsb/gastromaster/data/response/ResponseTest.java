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

public class ResponseTest {

    Response<Dish> actual;

    @Before
    public void setup() {

        actual = ResponseFactory.responseDishError(DishFactory.dish(), "Error");
    }

    @Test
    public void givenVoidResponseReturnResponeWhereEntityIsNull() {

        Response<Void> actualVoid = ResponseFactory.responseVoid();

        assertNull(actualVoid.getEntity());
    }

    @Test
    public void givenIDishResponseReturnsResponseWhereEntityIsDish() {
        assertThat(actual.getEntity(), instanceOf(Dish.class));
    }

//    @Test
//    public void testResponseHasNewEntityNullAfterSetEntity() {
//        actual.setEntity(null);
//        assertThat(actual.getEntity(), is(CoreMatchers.nullValue()));
//    }
//
//    @Test
//    public void givenIsSuccessfulFalseReturnsIsSuccessfullFalse() {
//        assertThat(actual.isSuccessful(), is(false));
//    }
//
//    @Test
//    public void testResponseIsSuccessfulIsTrueAfterSetIsSuccessfulTrue() {
//        actual.setSuccessful(true);
//        assertThat(actual.isSuccessful(), is(true));
//    }
//
//    @Test
//    public void givenErrorMessageErrorReturnsErrorMessageError() {
//        assertThat(actual.getErrorMessage(), is("Error"));
//    }
//
//    @Test
//    public void testResponseErrorMessageIsError2AfterSetErrorMessageToError2() {
//        actual.setErrorMessage("Error2");
//        assertThat(actual.getErrorMessage(), is("Error2"));
//    }


}
