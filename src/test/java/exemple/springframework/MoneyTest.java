package exemple.springframework;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class MoneyTest {

    @Test
    void testMultiplicationEuro(){
        Money five = Money.euro(5);
        assertEquals(Money.euro(10), five.times(2));
        assertEquals(Money.euro (15), five.times(3));
    }
    @Test
    void testEqualityEuro(){
        assertEquals(Money.euro(5), Money.euro(5));
        assertNotEquals(Money.euro(5), Money.euro(8));
        assertNotEquals(Money.euro(5), Money.franc(5));
    }
    @Test
    void testMultiplicationFranc(){
        Money five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }
    @Test
    void testEqualityFranc(){
        assertEquals(Money.franc(5), Money.franc(5));
        assertNotEquals(Money.franc(5), Money.franc(8));
    }
    @Test
    void testCurrency(){
        assertEquals("EURO", Money.euro(1).currency());
        assertEquals("CHF", Money.franc(1).currency());

    }

}
