package app;

import java.io.*;


public class Main {

   public static void main(String[] args) throws IOException{


      String input = args[0];
      String output = args[1];

      String[] arg = new String[2];

      arg[0] = input;
      arg[1] = output;

      ReadFile r = new ReadFile();
   
      r.read(arg);

   }
}