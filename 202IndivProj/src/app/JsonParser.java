package app;
import app.*;

import java.io.*;
import java.util.*;

public class JsonParser implements Parser{

    private String output;

    public ArrayList<String> parse(String fileName) throws FileNotFoundException,IOException{
        
        Scanner s1 = new Scanner(new File(fileName));

        Scanner s2 = new Scanner(new File(fileName));      
        
        int num = 0;
   
        int i = 0;
   
        while(s1.hasNextLine()){
   
           String data = s1.nextLine();
   
           if (data.equals("  {")){
               num = num + 1;
           }
        }

        ArrayList<String> cardNumber = new ArrayList<String>();
   
       
   
        while(s2.hasNextLine()){
   
           String data = s2.nextLine();
   
           if (data.equals("[") || data.equals("  {") || data.equals("  },") || data.equals("]")){
               
               continue;
           }

            String[] cn = data.split(":");
   
           if (cn[0].equals("    \"CardNumber\"")){
             
               String cnum = (cn[1].split(" "))[1];
   
               cnum = cnum.substring(0,cnum.length()-1);
   
               cardNumber.add(cnum) ;

               i += 1;
   
           }
   
         }
        cardNumber.add("null");
       return cardNumber;
    }


    public void get_outputName(String arg){

        output = arg;

      }



    public void write(ArrayList<String> data) throws FileNotFoundException,IOException{

        ReadCardNum r = new ReadCardNum();

        ArrayList<String> dataType = r.read(data);

    
        FileWriter jsonWriter = new FileWriter(output);
    
        jsonWriter.write("[");
        jsonWriter.write("\n");

        for(int i = 0; i < dataType.size(); i++){
            jsonWriter.write("  {");
            jsonWriter.write("\n");
            jsonWriter.write("    \"CardNumber\":");
            jsonWriter.write(" ");
            if(data.get(i).equals("null")){
                jsonWriter.write("0");
            }
            else{
            jsonWriter.write(data.get(i));
            }
            jsonWriter.write(",");
            jsonWriter.write("\n");
            jsonWriter.write("    \"CardType\":");
            jsonWriter.write(" ");
            jsonWriter.write("\"");
            jsonWriter.write(dataType.get(i));
            jsonWriter.write("\"");
            jsonWriter.write(",");
            jsonWriter.write("\n");
            jsonWriter.write("    \"Error\":");
            jsonWriter.write(" ");
            jsonWriter.write("\"");
            if (dataType.get(i).equals("Invalid")){
        
                jsonWriter.write("InvalidCardNumber");
    
            }
    
            else{
    
                jsonWriter.write("None");
            }
            jsonWriter.write("\"");
            jsonWriter.write("\n");
            if(i == data.size()-1){
                jsonWriter.write("  }");
        }
            else{
                jsonWriter.write("  },");
                jsonWriter.write("\n");

            }
        }
          
        jsonWriter.write("\n");
        jsonWriter.write("]");

        jsonWriter.flush();

        jsonWriter.close();

    }
}



        
        
            
        
               


            


      
