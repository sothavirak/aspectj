package edu.sample.cxf;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HelloServiceTest extends CamelBlueprintTestSupport {
	WebClient client = null;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		client = WebClient.create("http://localhost:8386/");
		client.accept(MediaType.APPLICATION_JSON);
		client.type(MediaType.APPLICATION_JSON);
		client.header("content-type", MediaType.APPLICATION_JSON);
	}
	
	@Override
    protected String getBlueprintDescriptor() {
        return "/OSGI-INF/blueprint/blueprint.xml";
    }
	
	@After
    public void close() throws Exception {
    	if (client != null)
			client.close();
	}

	@Override
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	//@Test 
	public void testSaySomething() {
		try {
			Response response = client.path("/retail/hello/say").get();
			String responseStr = response.readEntity(String.class);
			assertEquals("Hello Service", responseStr);
    	} catch(Exception e) {
    		e.printStackTrace();
		}
	}
}
