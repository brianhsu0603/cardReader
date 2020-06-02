package app;
import app.*;

import java.util.*;
import java.nio.file.Files;
import java.io.*;

public class ReadFile {

    private Parser parser;

    private ArrayList<String> data = new ArrayList<String>();




    public void read(String[] arg) throws FileNotFoundException,IOException
{
   parser = new CsvParser();

   final File file = new File(arg[0]);
   
   try
   {
      String fileType = Files.probeContentType(file.toPath());

       if (fileType.equals("text/csv")){

           data = parser.parse(arg[0]);

           parser.get_outputName(arg[1]);

           parser.write(data);


       }



       else if (fileType.equals("application/json")){


           JsonParser p = new JsonParser();

           changeParser(p);

           data = parser.parse(arg[0]);

           parser.get_outputName(arg[1]);

           parser.write(data);

       }



       else if (fileType.equals("application/xml")){

           XmlParser p = new XmlParser();

           changeParser(p);

           data = parser.parse(arg[0]);

           parser.get_outputName(arg[1]);

           parser.write(data);




       }

       else{
           System.out.print("File Type not accepted");
       }

   }
   catch (IOException ioException)
   {
      System.out.println(
           "ERROR: Unable to determine file type for " + arg[0]
              + " due to exception " + ioException);
   }


   
}



public void changeParser(Parser p){
    parser = p;

}

}
   
   

