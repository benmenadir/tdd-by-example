package exemple.springframework;

public class Euro extends Money{

    private String currency;

    public Euro (int amount, String currency){
        super(amount, currency);

    }

    Money times(int multiplier){
       return new Euro( amount * multiplier, currency) ;
    }

}
