package app;
import app.*;
import java.util.*;
import java.io.*;


public interface Parser {
    
     ArrayList<String> parse(String fileName) throws FileNotFoundException,IOException;

     void write(ArrayList<String> data) throws FileNotFoundException,IOException;

     void get_outputName(String arg);
}






