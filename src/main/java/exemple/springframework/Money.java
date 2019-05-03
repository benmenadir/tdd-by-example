package exemple.springframework;

public abstract class Money {
    protected int amount;

    public Money (int amount) {
        this.amount=amount;
    }

    static Money franc (int amount) {
        return new Franc(amount);
    }
    static Money euro (int amount) {
        return new Euro(amount);
    }
    abstract Money times(int multiplier);

    public boolean equals(Object object){
        Money money = (Money) object;
        return amount == money.amount
                && this.getClass().equals(object.getClass());
    }

}
