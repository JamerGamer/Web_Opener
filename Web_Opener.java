
import java.io.IOException;
import java.util.*;
class Web_Opener{
  public static void main(String args [])
  {
    Runtime rt = Runtime.getRuntime();
    
    String url;
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print(" = ");
    url=sc.nextLine();
    
    try{
      rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
    }
    
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}
