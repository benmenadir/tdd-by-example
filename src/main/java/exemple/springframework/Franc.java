package exemple.springframework;

public class Franc extends Money{

    private String currency;

    public Franc (int amount,String currency){
        super(amount, currency);

    }

    Money times(int multiplier){
        return new Franc( amount * multiplier, currency) ;
    }


}
