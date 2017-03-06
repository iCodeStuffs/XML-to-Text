package getxml;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.Scanner;
import java.net.URL;
import java.net.URLConnection;


public class GetXML {
    public static void main(String[] args) {
        String numericID;
        System.out.print("Enter a numerical ID: ");
        Scanner kb = new Scanner(System.in);
        numericID = kb.nextLine();
        
        try{
            URL url = new URL("http://129.32.92.49/xml/grade.php?id=" + numericID);
            URLConnection inputStream = url.openConnection();
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputStream.getInputStream());
            
            NodeList nName = doc.getElementsByTagName("name");
            NodeList nGrade = doc.getElementsByTagName("grade"); 
            
            
            for(int temp = 0; temp < nName.getLength(); temp++){ //go through each element
                   System.out.println("Name : " + nName.item(temp).getTextContent()); //print the student(s) name(s)
            }
            for(int temp = 0; temp < nGrade.getLength(); temp++){
                   System.out.println("Student grade: " + nGrade.item(temp).getTextContent()); //print the student's grade
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
