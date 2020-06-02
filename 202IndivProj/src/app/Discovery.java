package app;
import app.*;

public class Discovery implements CreditCard
{
    public String classify(String num) {

      if (num.charAt(1) =='6' && num.charAt(2) == '0' && num.charAt(2) == '1' && num.charAt(3) == '1' && num.length() == 16 ){

        return "Discovery";
      }

      else{

        return "Invalid";
        
      }
}
}