package exemple.springframework;

public interface Expression {
    Money reduce (Bank bank, String to);

    Expression plus (Expression addend);
}
