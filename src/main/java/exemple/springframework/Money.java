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
    public Money reduce (Bank bank, String to){
       // return this;
        // int rate = (currency.equals("CHF") && to.equals("EURO")) ? 2 : 1 ;

        return new Money(amount / bank.rate(this.currency, to) , to);
    }
    @Override
    public String toString ( ) {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    public Expression plus (Money addend) {

        return new Sum(this, addend);
    }
}
