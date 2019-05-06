package exemple.springframework;

public class Money implements Expression{
    protected int amount;
    protected String currency;

    public Money (int amount, String currency) {
        this.amount=amount;
        this.currency = currency;
    }

    static Money franc (int amount) {
        return new Money(amount, "CHF");
    }
    static Money euro (int amount) {
        return new Money(amount ,"EURO");
    }

    Money times (int multiplier) {
        return new Money( amount * multiplier, this.currency) ;
    }

    public boolean equals(Object object){
        Money money = (Money) object;
        return amount == money.amount
                && this.currency == money.currency;
    }

    protected String currency ( ) {
        return currency;
    }

    @Override
    public String toString ( ) {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    public Expression plus (Money addend) {

        return new Money(this.amount + addend.amount, this.currency);
    }
}
