
package ftp.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Hello world!
 */
public class ClientRunner {

  private static final int PORT = 1234;

  public static void main(String[] args) throws IOException {
  
    Scanner networkInput = null;
    Scanner userInput = null;
    PrintWriter output = null;
    
    try {
      //InetAddress host = InetAddress.getLocalHost();
      Socket socket = new Socket("servercontainer", PORT);
      networkInput = new Scanner(socket.getInputStream());
      userInput = new Scanner(System.in);
      output = new PrintWriter(socket.getOutputStream(), true);
    } catch (UnknownHostException uhEx) {
      System.out.println("\nHost not found!\n");
      System.exit(1);
    }
    
    boolean isConnected = true;
    
    String temp = null;
    
    do {
      System.out.print(">");
      temp = userInput.nextLine();
      output.println(temp);
      System.out.println(networkInput.nextLine());
    } while (isConnected);
  }
}
