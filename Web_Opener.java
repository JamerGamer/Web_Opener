import java.io.IOException;
import java.util.*;
import java.io.FileInputStream;

class Web_Opener{

  static Properties prop = new Properties();
  static Runtime run = Runtime.getRuntime();

  public static void openFile(String fileName){

    try (FileInputStream fis = new FileInputStream(fileName)) {
      prop.load(fis);
    }
  
    catch (IOException ex){
      System.out.println("error");

    }
  }


  public static void openUrl(String configPropertyName, int urlNumber){

    while (prop.getProperty(configPropertyName + urlNumber) != null){

      try{
        run.exec("rundll32 url.dll,FileProtocolHandler " + prop.getProperty(configPropertyName + urlNumber));
      }

      catch (IOException ex){
        System.out.println("error");
      }

      System.out.println(prop.getProperty(configPropertyName + urlNumber));
      urlNumber++;
      try{
        Thread.sleep(50);
      }

      catch (InterruptedException e){
        e.printStackTrace();

      }
    }
  }

  public static void runLocalFile(String exePath){

    try{
        run.exec(exePath);
    }

    catch (IOException e){
      e.printStackTrace();
    }
  }

  public static void main(String[] args){

    openFile("url.config");
    openUrl("url", 1);
    runLocalFile("Desktop/Discord");

  }




}