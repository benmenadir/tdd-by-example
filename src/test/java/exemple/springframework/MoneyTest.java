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

    @Test
    void testSimpleAddition(){
        Money five = Money.euro(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum,"EURO");
        assertEquals(Money.euro(10), reduced);
    }

    @Test
    void testPlusReturnSum(){
        Money five = Money.euro(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;

        assertEquals(five,sum.augmend);
        assertEquals(five,sum.addmend);
    }
    @Test
    void testReduceSum(){
    Expression sum = new Sum (Money.euro(3), Money.euro(4));
    Bank bank = new Bank();
    Money result = bank.reduce(sum,"EURO");
    assertEquals(Money.euro(7),result);
    }
    @Test
    void testReduceMoney(){
        Bank bank= new Bank();
        Money result = bank.reduce(Money.euro(1), "EURO");
        assertEquals(Money.euro(1), result);
    }

    @Test
    void testReduceMoneyDifferentCurrency(){
        Bank bank = new Bank();
        bank.addRate("CHF", "EURO", 2);
        Money result = bank.reduce(Money.franc(2), "EURO");
        assertEquals(Money.euro(1), result);
    }
    @Test
    void testIdentityRate(){
        assertEquals(1, new Bank().rate("EURO", "EURO"));
        assertEquals(1, new Bank().rate("CHF", "CHF"));
    }
    @Test
    void testMixedAddition(){
        Expression fiveBucks = Money.euro(5);
        Expression  tenFrancs = Money.franc(10);

        Bank bank = new Bank();
        bank.addRate("CHF", "EURO", 2);
        Money result = bank.reduce(fiveBucks.plus(tenFrancs),"EURO");
        assertEquals(Money.euro(10),result);
    }
}
