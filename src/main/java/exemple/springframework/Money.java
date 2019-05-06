package exemple.springframework;

public class Money implements Expression{
    final int amount;
    private final String currency;

    Money (int amount, String currency) {
        this.amount=amount;
        this.currency = currency;
    }

    static Money franc (int amount) {
        return new Money(amount, "CHF");
    }
    static Money euro (int amount) {
        return new Money(amount ,"EURO");
    }


    @Override
    public Expression times (int multiplier) {
        return new Money( amount * multiplier, this.currency) ;
    }

    public boolean equals(Object object){
        Money money = (Money) object;
        return amount == money.amount
                && this.currency == money.currency;
    }

    String currency ( ) {
        return currency;
    }

    @Override
    public Money reduce (Bank bank, String to){
        return new Money(amount / bank.rate(this.currency, to) , to);
    }
    @Override
    public String toString ( ) {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    @Override
    public Expression plus (Expression addend) {

        return new Sum(this, addend);
    }
}
