
package ftp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 */
public class ServerRunner {

  private static final int PORT = 1234;
  
  public static void main(String[] args) {
    ServerSocket serverSocket;
    Socket client;

    try {
      serverSocket = new ServerSocket(PORT);
    } catch (IOException ioEx) {
      System.out.println("\nunable to setup port");
      System.exit(1);
    }
    
    

    // System.out.println("Hello World!");
  }
}
