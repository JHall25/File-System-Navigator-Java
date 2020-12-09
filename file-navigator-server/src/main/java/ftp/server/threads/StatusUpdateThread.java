package ftp.server.threads;

import ftp.server.objects.ClientInteractions;

public class StatusUpdateThread extends Thread {
	
	@Override
	public void run() {
		
		while (true) {
			System.out.println("Operations: " + ClientInteractions.getNumberOfOperations() + " Clients: "
							+ ClientInteractions.getNumberOfClientsConnected());
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
