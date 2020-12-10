
package ftp.server;

import ftp.server.objects.ClientInteractions;
import ftp.server.threads.ClientHandler;
import ftp.server.threads.StatusUpdateThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 */
public class ServerRunner {

  private static final int PORT = 1234;
  
  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = null;
    Socket client;

    try {
      serverSocket = new ServerSocket(PORT);
    } catch (IOException ioEx) {
      System.out.println("\nunable to setup port");
      System.exit(1);
    }
    
    System.out.println("\nserver is running");
  
    StatusUpdateThread updateThread = new StatusUpdateThread();
    updateThread.start();
    
    do {
      client = serverSocket.accept();
      System.out.println("new client connected");
      ClientInteractions.incrementNumberOfClientsConnected();
      ClientHandler clientHandler = new ClientHandler(client);
      clientHandler.start();
    } while(true);
  }
}
