package app;
import app.*;

import java.util.*;
import java.nio.file.Files;
import java.io.*;

public class ReadCardNum {

    private CreditCard card;



    private ArrayList<String> cardType = new ArrayList<String>();

    public ArrayList<String> read(ArrayList<String> data) {

        card = new MasterCard();



        for (int i = 0; i < data.size(); i++) {

            if ((data.get(i)).charAt(0) == '5') {

                String type = card.classify(data.get(i));

                cardType.add(type);
            }
            else if ((data.get(i)).charAt(0) == '4') {

                Visa c = new Visa();
                changeCreditCard(c);

                String type = card.classify(data.get(i));

                cardType.add(type);

            }
            else if ((data.get(i)).charAt(0) == '3') {

                AmericanExpress c = new AmericanExpress();
                changeCreditCard(c);

                String type = card.classify(data.get(i));

                cardType.add(type);

            }
            else if ((data.get(i)).charAt(0) == '6') {

                Discovery c = new Discovery();
                changeCreditCard(c);

                String type = card.classify(data.get(i));

                cardType.add(type);

            } else {
                cardType.add("Invalid");
            }


        }

        return cardType;

    }

    public void changeCreditCard(CreditCard c) {

        card = c;

    }
}