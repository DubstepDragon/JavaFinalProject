

package finalproject;

import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;

public class MakeRequest
{

  private BufferedReader in;
  private PrintWriter out;
  private String inputLine;
  private Socket socket;

  public MakeRequest()
  {
    super();
  }
     
  public String requestHTML(String webpageURL)
  {
    //This StringBuffer will hold the html response received from a web server.
    StringBuffer htmlCode = new StringBuffer();

    try
    {
      InetAddress iAddress = InetAddress.getByName(webpageURL);

      socket = new Socket(iAddress, 80);

      out = new PrintWriter(socket.getOutputStream());

      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      out.print("GET / HTTP/1.0\r\n\n");
      out.flush();

      while((inputLine = in.readLine()) != null)
      {
        System.out.println(inputLine);

        htmlCode.append(inputLine);
        htmlCode.append("\n");
      }

      socket.close();
      
      return htmlCode.toString();
    }//end try
    catch (UnknownHostException uhe)
    {
      uhe.printStackTrace();
    }
    catch (IOException ioe)
    {
      ioe.printStackTrace();
    }//end catch
    

    return "";
  }//end method


}//end class
