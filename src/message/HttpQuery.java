package message;

import java.io.IOException;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;


public class HttpQuery
{
	private String mUrl;
	private int mErrorCode;
	private HttpResponse mResponse;
	
	public HttpQuery(String url)
	{
		mUrl = url;
	}
	
	public String getMethod()
	{
		String returnedContent = null;
		
		try 
		{
			if(mUrl != null)
			{
				mResponse = Request.Get(mUrl).execute().returnResponse();
				mErrorCode =  mResponse.getStatusLine().getStatusCode();
				
				if(mErrorCode == 200)
				{
					returnedContent = mResponse.toString();
				}
			}
		}
		catch (ClientProtocolException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return returnedContent;
	}
	
	
	public String postMethod()
	{
		String returnedContent = null;
		
		try 
		{
			if(mUrl != null)
			{
//				.addHeader("app-header", "example").bodyString("", ContentType.APPLICATION_JSON)
				mResponse = Request.Post(mUrl).addHeader("app-header", "example").bodyString("", ContentType.APPLICATION_JSON).bodyForm(Form.form().add("a", "abc123").build(), Consts.UTF_8).execute().returnResponse();
				mErrorCode =  mResponse.getStatusLine().getStatusCode();
				
				if(mErrorCode == 200)
				{
					returnedContent = mResponse.toString();
				}
			}
		}
		catch (ClientProtocolException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return returnedContent;
	}
	
	
	public int getErrorCode()
	{
		return mErrorCode;
	}
	
	public HttpResponse getResponse()
	{
		return mResponse;
	}
}
