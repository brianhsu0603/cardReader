package app;

public class AmericanExpress implements CreditCard
{
    public String classify(String cardNum) {

        if ((cardNum.charAt(1) == '4' || cardNum.charAt(1) == '7') && cardNum.length() == 15){

            return "AmericanExpress";
        }

        else{
            
            return "Invalid";

        }
    }
}