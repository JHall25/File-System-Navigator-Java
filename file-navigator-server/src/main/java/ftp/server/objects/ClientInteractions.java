package ftp.server.objects;

public class ClientInteractions {
	
	private static int numberOfOperations;
	private static int numberOfClientsConnected;
	
	public ClientInteractions() {
		numberOfOperations = 0;
		numberOfClientsConnected = 0;
	}
	
	public static int getNumberOfOperations() {
		return numberOfOperations;
	}
	
	public static int getNumberOfClientsConnected() {
		return numberOfClientsConnected;
	}
	
	public static void incrementNumberOfOperations() {
		numberOfOperations++;
	}
	
	public static void incrementNumberOfClientsConnected() {
		numberOfClientsConnected++;
	}
	
	public static void decrementNumberOfClientsConnected() {
		numberOfClientsConnected--;
	}
}
