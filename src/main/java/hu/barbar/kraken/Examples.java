package hu.barbar.kraken;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import hu.barbar.kraken.api.KrakenApi;
import hu.barbar.kraken.api.KrakenApi.Method;
import hu.barbar.kraken.api.ResponseParser;
import hu.barbar.util.FileHandler;

public class Examples {

    public static void main(String[] args) throws IOException, InvalidKeyException, NoSuchAlgorithmException {

    	JSONObject myApiKey = FileHandler.readJSON("api_key.json");
    	
        KrakenApi api = new KrakenApi();
        api.setKey((String) myApiKey.get("api key")); // FIXME
        api.setSecret((String) myApiKey.get("api secret")); // FIXME

        String response;
        Map<String, String> input = new HashMap<>();

        input.put("pair", "XBTUSD");
        response = api.queryPublic(Method.TICKER, input);
        System.out.println("1:\n" + response + "\n");

        /*
        input.clear();
        input.put("pair", "XBTEUR,XBTLTC");
        response = api.queryPublic(Method.ASSET_PAIRS, input);
        System.out.println("2:\n" + response + "\n");
        /**/

        input.clear();
        input.put("asset", "ZEUR");
        response = api.queryPrivate(Method.BALANCE, input);
        System.out.println("3:\n" + response + "\n");
        
        JSONObject json = new JSONObject();
        json.escape(response);
        System.out.println(json);
       
        
        ResponseParser rp = new ResponseParser(Method.BALANCE);
        rp.getParsed(response);
    }
}
