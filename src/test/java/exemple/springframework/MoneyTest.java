package exemple.springframework;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class MoneyTest {

    @Test
    void testMultiplicationEuro(){
        Euro five = new Euro(5);
        Euro product = five.times(2);
        assertEquals(new Euro(10), product);
        product = five.times(3);
        assertEquals(new Euro (15), product);
    }
    @Test
    void testEqualityEuro(){
        assertEquals(new Euro(5), new Euro(5));
        assertNotEquals(new Euro(5), new Euro(8));
        assertNotEquals(new Euro(5), new Franc(5));
    }
    @Test
    void testMultiplicationFranc(){
        Franc five = new Franc(5);
        Franc product = five.times(2);
        assertEquals(new Franc(10), product);
        product = five.times(3);
        assertEquals(new Franc (15), product);
    }
    @Test
    void testEqualityFranc(){
        assertEquals(new Franc(5), new Franc(5));
        assertNotEquals(new Franc(5), new Franc(8));
    }
}
