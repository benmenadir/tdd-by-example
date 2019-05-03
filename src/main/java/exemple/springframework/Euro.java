package exemple.springframework;

public class Euro extends Money{


    public Euro (int amount){
        super(amount);
    }

    Money times(int multiplier){
       return new Euro( amount * multiplier ) ;
    }


}
