package de.hsb.gastromaster.data.response;


import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import de.hsb.gastromaster.data.order.dish.IDish;
import de.hsb.gastromaster.data.stubs.DishStub;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class ResponseTest {
    Response<IDish> actual;
    @Before
    public void setup(){
        actual = new Response<IDish>(new DishStub(), false, "Error");
    }

    @Test
    public void givenVoidResponseReturnResponeWhereEntityIsNull(){
        Response<Void> actualVoid = new Response<>(null,false,"Error");
        assertNull(actualVoid.getEntity());
    }

    @Test
    public void givenIDishResponseReturnsResponseWhereEntityIsDish(){
        assertThat(actual.getEntity(), instanceOf(IDish.class));
    }

    @Test
    public void testResponseHasNewEntityNullAfterSetEntity(){
        actual.setEntity(null);
        assertThat(actual.getEntity(), is(CoreMatchers.nullValue()));
    }

    @Test
    public void givenIsSuccessfulFalseReturnsIsSuccessfullFalse(){
        assertThat(actual.isSuccessful(), is(false));
    }

    @Test
    public void testResponseIsSuccessfulIsTrueAfterSetIsSuccessfulTrue(){
        actual.setSuccessful(true);
        assertThat(actual.isSuccessful(), is(true));
    }

    @Test
    public void givenErrorMessageErrorReturnsErrorMessageError(){
        assertThat(actual.getErrorMessage(), is("Error"));
    }

    @Test
    public void testResponseErrorMessageIsError2AfterSetErrorMessageToError2(){
        actual.setErrorMessage("Error2");
        assertThat(actual.getErrorMessage(), is("Error2"));
    }


}
