package ftp.server.objects;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClientInteractionsTest {
	
	@Before
	public void setup() {
		new ClientInteractions();
	}
	
	@Test
	public void shouldIncrementNumberOfOperations() {
		ClientInteractions.incrementNumberOfOperations();
		assertEquals(1, ClientInteractions.getNumberOfOperations());
	}
	
	@Test
	public void shouldIncrementNumberOfClientsConnected() {
		ClientInteractions.incrementNumberOfClientsConnected();
		assertEquals(1, ClientInteractions.getNumberOfClientsConnected());
	}
	
	@Test
	public void shouldDecrementNumberOfClientsConnected() {
		ClientInteractions.incrementNumberOfClientsConnected();
		ClientInteractions.incrementNumberOfClientsConnected();
		ClientInteractions.decrementNumberOfClientsConnected();
		assertEquals(1, ClientInteractions.getNumberOfClientsConnected());
	}
	
}
