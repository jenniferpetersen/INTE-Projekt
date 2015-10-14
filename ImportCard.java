package saker;
import com.google.gson.Gson;
import java.net.*;
import java.io.*;
import java.util.Arrays;

public class ImportCard {
	
	public static void main (String[] args) throws Exception{
	
		String json = readUrl("http://netrunnerdb.com/api/card/01001");
		
		Gson gson = new Gson();
		Card[] card = gson.fromJson(json, Card[].class);
	}
	
	public static String readUrl(String urlString) throws Exception{
		URL url = new URL(urlString);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        
        String inputLine;
        String input = "";
        while ((inputLine = reader.readLine()) != null){
        	input += inputLine;
        }
        reader.close();
        return input;
	}
}

