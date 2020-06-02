package app;

import java.util.*;
import java.io.*;

public class CsvParser implements Parser{

    private String outputName;

    public ArrayList<String> parse(String fileName) throws FileNotFoundException,IOException{

            Scanner s1 = new Scanner(new File(fileName));

            int numberofLines = 0;

            while (s1.hasNext()) {
                s1.nextLine();
                numberofLines++;
            }

            ArrayList<String> cardNumberList = new ArrayList<String>();
            Scanner s2 = new Scanner(new File(fileName));

            s2.nextLine();

            for(int i = 0;i < numberofLines-1;i++){

                String line = s2.nextLine();
                String[] values = line.split(",");
                String tempValues = values[0].trim();
                cardNumberList.add(tempValues);

            }
            cardNumberList.add("null");

            return cardNumberList;
        
            }            
            

        public void get_outputName(String arg){

        outputName = arg;

        }



        public void write(ArrayList<String> cardNumberList) throws FileNotFoundException,IOException{

            ReadCardNum r = new ReadCardNum();

            ArrayList<String> dataType = r.read(cardNumberList);

            FileWriter csvWriter = new FileWriter(outputName);
        
            csvWriter.append("CardNumber");

            csvWriter.append(",");
        
            csvWriter.append("CardType");
        
            csvWriter.append(",");
        
            csvWriter.append("Error");
        
            csvWriter.append("\n");

        
            for(int i = 0; i < dataType.size(); i++){

                if(cardNumberList.get(i).equals("null")){

                    csvWriter.append("0");
                }
                else{

                    csvWriter.append(cardNumberList.get(i));
                }

            csvWriter.append(",");
            csvWriter.append(dataType.get(i));
            csvWriter.append(",");
        
            if (dataType.get(i).equals("Invalid")){
        
                    csvWriter.append("InvalidCardNumber");
            }
            else{

                csvWriter.append("None");
                }
        
                csvWriter.append("\n");
            }
        
            csvWriter.flush();
       
            csvWriter.close();
    }
}
