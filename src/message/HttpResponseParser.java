package message;

import org.apache.http.HttpResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class HttpResponseParser 
{
	private HttpResponse mResponse;
	private String mReturnedContent;
	private int mErrorStatusCode;
	
	public HttpResponseParser(HttpResponse response)
	{
		if(response != null)
		{
			mResponse = response;
			mReturnedContent = mResponse.toString();
			mErrorStatusCode = mResponse.getStatusLine().getStatusCode();
		}
		
	}
	
	public String getContent()
	{
		return mReturnedContent;
	}
	
	public int getErrorStatusCode()
	{
		return mErrorStatusCode;
	}
	
	public JsonObject getContentAsJsonObject()
	{
		return new JsonParser().parse(mReturnedContent).getAsJsonObject();
	}

}
