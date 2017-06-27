package hu.barbar.kraken.api;

import org.json.simple.JSONObject;

import hu.barbar.kraken.api.KrakenApi.Method;

public class ResponseParser {

	Method method = null;
	
	private String response = null;
	
	public ResponseParser(Method method) {
		this.method = method;
	}
	
	public JSONObject getParsed(String response){
		this.response = response;
		
		JSONObject json = new JSONObject();
		
		if(this.method == Method.BALANCE){
			String[] a = response.split("result");
			String line = a[1];
			System.out.println("\n|" + a + "|\n");
		}
		
		return json;
	}
}
