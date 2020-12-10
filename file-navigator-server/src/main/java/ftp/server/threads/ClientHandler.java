
package ftp.server.threads;

import ftp.server.objects.ClientInteractions;
import ftp.server.operations.FileSystemOperations;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class ClientHandler extends Thread {

  private Socket client;
  private Scanner input;
  private PrintWriter output;

  public ClientHandler(Socket client) throws IOException {
    this.client = client;
    input = new Scanner(this.client.getInputStream());
    output = new PrintWriter(this.client.getOutputStream(), true);
  }

  public void run() {
    boolean isConnected = true;
    FileSystemOperations systemOperations = new FileSystemOperations();

    do {
      if (input.hasNextLine()) {
      	String textInput = input.nextLine();
      	System.out.println(textInput);
        String[] operation = textInput.split(" ");
        
        System.out.println(operation[0]);
        switch (operation[0]) {
          case "ls":
            try {
              List<String> contents = systemOperations.performLsOperation();
              StringBuilder tempOutput = new StringBuilder();
              for (String item : contents) {
              	tempOutput.append(item).append(", ");
              }
              output.println(tempOutput.toString());
              ClientInteractions.incrementNumberOfOperations();
            } catch (IOException e) {
              output.println("invalid operation");
            }
            break;
          case "cd":
            try {
            	System.out.println(operation[1]);
              String tempPath = systemOperations.performCdOperation(operation[1]);
              output.println(tempPath);
              ClientInteractions.incrementNumberOfOperations();
            } catch (IOException | ArrayIndexOutOfBoundsException e) {
              output.println("invalid operation");
            }
            break;
          case "quit":
            isConnected = false;
            break;
          default:
            output.println("invalid operation");
        }
      }
    } while (isConnected);

    try {
      System.out.println("Closing down connection");
      ClientInteractions.decrementNumberOfClientsConnected();
      client.close();
    } catch (IOException e) {
      System.out.println("* Disconnection problem! *");
      e.printStackTrace();
    }
  }
}
