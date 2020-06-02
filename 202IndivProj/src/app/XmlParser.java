package app;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.*;
import java.util.ArrayList;


public class XmlParser implements Parser{
    
    private String output;
    private ArrayList<String> cardNumberList;
    public ArrayList<String> parse(String fileName) throws FileNotFoundException,IOException{
        
    try{
            File fXmlFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
        
           doc.getDocumentElement().normalize();
        
            
            NodeList nList = doc.getElementsByTagName("row");

        ArrayList<String> cardNumber = new ArrayList<String>();
        
            for (int temp = 0; temp < nList.getLength(); temp++) {
        
                Node nNode = nList.item(temp);
        
             
        
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
        
                    Element eElement = (Element) nNode;
        
                 String c = eElement.getElementsByTagName("CardNumber").item(0).getTextContent();
                
                 cardNumber.add(c);

                 cardNumberList = cardNumber;

                }
                
            }
          
            }
            catch (Exception e) {
                e.printStackTrace();
             }
             
        cardNumberList.add("null");
            return cardNumberList;
            }

            
            
            public void get_outputName(String arg){

              output = arg;

            }


    

    public void write(ArrayList<String> data) throws FileNotFoundException,IOException{

        ReadCardNum r = new ReadCardNum();

        ArrayList<String> dataType = r.read(data);

        FileWriter xmlWriter = new FileWriter(output);

        xmlWriter.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        xmlWriter.append("\n");
        xmlWriter.append("<root>");
        xmlWriter.append("\n");
        for (int i = 0; i < data.size(); i++){
            xmlWriter.append("  <row>");
            xmlWriter.append("\n");
            xmlWriter.append("    <CardNumber>");
            if (data.get(i).equals("null")){
                xmlWriter.append("0");

            }
            else{
                xmlWriter.append(data.get(i));

            }
            xmlWriter.append("</CardNumber>");

            xmlWriter.append("\n");
            xmlWriter.append("    <CardType>");
            xmlWriter.append(dataType.get(i));
            xmlWriter.append("</CardType>");
            xmlWriter.append("\n");
            xmlWriter.append("    <Error>");
            if(dataType.get(i).equals("Invalid")){
                xmlWriter.append("Invalid CardNumber");

            }
            else{xmlWriter.append("None");
            }
            xmlWriter.append("</Error>");
            xmlWriter.append("\n");

            xmlWriter.append("  </row>");
            xmlWriter.append("\n");
        }
            xmlWriter.append("</root>");

            xmlWriter.flush();

            xmlWriter.close();

    }
}










        

    

        
            
        
        
          
           
        
    
