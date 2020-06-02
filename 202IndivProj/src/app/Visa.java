package app;

public class Visa implements CreditCard
{
    public String classify(String num) {

        if(num.length() == 13 || num.length() == 16 ){

            return "Visa";
        }

        else {
            
            return "Invalid";
            
        }
}
}