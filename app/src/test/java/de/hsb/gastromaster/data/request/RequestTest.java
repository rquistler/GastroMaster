package de.hsb.gastromaster.data.request;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.mockito.internal.matchers.InstanceOf;

import de.hsb.gastromaster.data.order.dish.IDish;
import de.hsb.gastromaster.data.stubs.DishStub;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;


public class RequestTest {
    @Test
    public void givenVoidRequestReturnRequestWhereEntityIsNull(){
        Request<Void> req = new Request<Void>(null);
        assertNull(req.getEntity());
    }

    @Test
    public void givenIDishRequestReturnsRequestWhereEntityIsDish(){
        Request<IDish> actual = new Request<IDish>(new DishStub());
        assertThat(actual.getEntity(), instanceOf(IDish.class));
    }

    @Test
    public void testRequestHasNewEntityNullAfterSetEntity(){
        Request<IDish> actual = new Request<IDish>(new DishStub());
        actual.setEntity(null);
        assertThat(actual.getEntity(), is(CoreMatchers.nullValue()));
    }
}
