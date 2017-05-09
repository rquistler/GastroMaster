package de.hsb.gastromaster.data.stubs;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import de.hsb.gastromaster.data.order.IOrder;
import de.hsb.gastromaster.data.order.Order;
import de.hsb.gastromaster.data.order.dish.IDish;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class OrderStubTest {
    private static final double DELTA = 1e-15;
    private static final String DEFAULT_DATE = "31-1-1990:19.00.32";
    private IOrder order;

    @Before
    public void setup() {
        order = new OrderStub();
    }

    @Test
    public void testHasId() {
        assertEquals(order.getId(), 1);
    }

    @Test
    public void testIfIdGotNewValue() {
        order.setId(2);
        assertEquals(order.getId(), 1);
    }

    @Test
    public void testHasTableNumber() {
        assertEquals(order.getTableNumber(), "1A");
    }

    @Test
    public void testIfTableNumberGotNewValue() {
        order.setTableNumber("2A");
        assertEquals(order.getTableNumber(), "1A");
    }

    @Test
    public void testHasTotalPrice() {
        assertEquals(order.getTotalPrice(), 0, DELTA);
    }

    @Test
    public void testIfTotalPriceGotNewValue() {
        order.setTotalPrice(1.0);
        assertEquals(order.getTotalPrice(), 0.0, DELTA);
    }

    @Test
    public void testHasWaitressId() {
        assertEquals(order.getWaitressId(), 1);
    }

    @Test
    public void testIfWaitressIdGotNewValue() {
        order.setWaitressId(2);
        assertEquals(order.getWaitressId(), 1);
    }

    @Test
    public void testHasDate() {
        assertEquals(order.getDate(), "31-1-1990:19.00.32");
    }


    @Test
    public void testIfDateGotNewValue() {
        order.setDate("31-1-1990:19.00.33");
        assertEquals(order.getDate(), DEFAULT_DATE);
    }

    @Test
    public void testHasDishList(){
        assertNotNull(order.getDishList());
    }

    @Test
    public void testIsDishList1ObjectAfterInit() {
        assertEquals(1, order.getDishList().size());
    }

}
