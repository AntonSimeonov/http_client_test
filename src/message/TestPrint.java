package message;

import java.io.IOException;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

@Path("/test")
public class TestPrint
{
	
	@GET
	@Path("/show")
	public void testGet()
	{
		
		HttpQuery query = new HttpQuery("http://127.0.0.1:8080/TestWildFly/v1/test/test_post");
		String content = query.postMethod();
		
		System.out.println("query content: " + content);
	}
	
	@POST
	@Path("/test_post")
	public void testPost(@FormParam("a") String a)
	{
		
//		HttpQuery query = new HttpQuery("http://google.com");
//		String content = query.postMethod();
		
		System.out.println("query content: " + a);
	}
	

}
