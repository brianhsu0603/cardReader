package app;
import app.*;

public class MasterCard implements CreditCard
{
    public String classify(String num) {

        if ((num.charAt(1) == '1' || num.charAt(1) == '2' || num.charAt(1) == '3' || num.charAt(1) == '4' || num.charAt(1) == '5') && num.length() == 16){
            
            return "MasterCard";
            }
            
        else{
                return "Invalid";
            }
        }


    }

