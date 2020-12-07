package ftp.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler extends Thread {
	private Socket client;
	private Scanner input;
	private PrintWriter output;
	
	public ClientHandler(Socket client) throws IOException {
		this.client = client;
		input = new Scanner(client.getInputStream());
		output = new PrintWriter(client.getOutputStream(), true);
	}
	
	public void run() {
	
	}
}
