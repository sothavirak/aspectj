package edu.sample;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.sample.service.EchoService;

public class EchoServiceTest {
	
	private EchoService echoService = new EchoService();

	@Test
    public void testLogService() {
		String echoMessage = "swordfish";
		assertEquals(echoMessage, echoService.echoMessage(echoMessage));
    }
}
