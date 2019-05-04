package exemple.springframework;

public abstract class Money {
    protected int amount;
    protected String currency;

    public Money (int amount, String currency) {
        this.amount=amount;
        this.currency = currency;
    }

    static Money franc (int amount) {
        return new Franc(amount, "CHF");
    }
    static Money euro (int amount) {
        return new Euro(amount ,"EURO");
    }
    abstract Money times(int multiplier);

    public boolean equals(Object object){
        Money money = (Money) object;
        return amount == money.amount
                && this.getClass().equals(object.getClass());
    }

    protected String currency ( ) {
        return currency;
    }
}
