/*
 * @author Christian Schaf
 * @author Roman Quistler
 * @author Nassim Bendida
 *
 * Date: 27.6.2017
 * Copyright (c) by Hochschule Bremen
 */

package de.hsb.gastromaster.data.order;


import org.junit.Before;
import org.junit.Test;

import de.hsb.gastromaster.data.factories.DishFactory;
import de.hsb.gastromaster.data.factories.OrderFactory;
import de.hsb.gastromaster.data.order.dish.Dish;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class OrderTest {

    private static final double DELTA = 1e-15;
    private Order order;

    @Before
    public void setup() {

        order = OrderFactory.order(DishFactory.dishList());
    }

    @Test
    public void testHasId() {
        assertEquals(order.getId(), 1);
    }

    @Test
    public void testIfIdGotNewValue() {

        assertThat(order.withId(2).getId())
                .isEqualTo(2);
    }

    @Test
    public void testHasTableNumber() {
        assertEquals(order.getTableNumber(), "1A");
    }

    @Test
    public void testIfTableNumberGotNewValue() {

        assertThat(order.withTableNumber("2A").getTableNumber())
                .isEqualTo("2A");

    }

    @Test
    public void testHasTotalPrice() {
        assertThat(order.getTotalPrice()).isNonZero();
    }

    @Test
    public void testIfTotalPriceGotNewValue() {

        assertThat(order.withDishList(DishFactory.dishListRandom(10))
                .getTotalPrice()).isNotEqualTo(order.getTotalPrice());

    }

    @Test
    public void testHasWaitressId() {
        assertEquals(order.getWaitressId(), 1);
    }

    @Test
    public void testIfWaitressIdGotNewValue() {

        assertThat(order.withWaitressId(2).getWaitressId())
                .isEqualTo(2);
    }

    @Test
    public void testHasDate() {
        assertEquals(order.getDate(), OrderFactory.DEFAULT_DATE);
    }


    @Test
    public void testIfDateGotNewValue() {

        assertThat(order.withDate(OrderFactory.DIFFERENT_DATE).getDate())
                .isEqualTo(OrderFactory.DIFFERENT_DATE);
    }

    @Test
    public void testHasDishList() {
        assertNotNull(order.getDishList());
    }

    @Test
    public void testIfDishListGotNewDish() {

        Dish dish = DishFactory.dish();

        order.getDishList().add(dish);

        assertEquals(order.getDishList()
                .get(order.getDishList().size() - 1), dish);
    }
}
