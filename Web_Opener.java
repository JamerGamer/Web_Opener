import java.io.IOException;
import java.util.*;
import java.io.FileInputStream;



class nameNum{
  String propertyName;
  int urlNumber;
}

  class Web_Opener{

    public static void main(String args []){
      Runtime run = Runtime.getRuntime();

      Properties prop = new Properties();
      
      String fileName = "url.config";
      String configPropertyName = "url";

      int urlNumber = 1;

      openFile(fileName);
      openURL(configPropertyName, urlNumber);
    }

    public nameNum openURL(String configPropertyName, int urlNumber){

      while (prop.getProperty(configPropertyName + urlNumber) != null){

        try{
          run.exec("rundll32 url.dll,FileProtocolHandler " + prop.getProperty(configPropertyName + urlNumber));
        }

        catch (IOException ex){
          System.out.println("error");
        }

        System.out.println(prop.getProperty(configPropertyName + urlNumber));
        urlNumber++;

    }


    public void openFile(String fileName){

    try (FileInputStream fis = new FileInputStream(fileName)) {
      prop.load(fis);
    }

    catch (IOException ex){
      System.out.println("error");
    } 

  }
 
  }
  }