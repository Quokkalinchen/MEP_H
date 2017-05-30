package backup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;

public class CSV_Extractor {

	public static JSONArray getJSON(String url, char Trennzeichen){
		long counter=0;
		BufferedReader reader = null;
		String csv = "";
		try {
		    File file = new File(url);
		    reader = new BufferedReader(new FileReader(file));
		    String line;
		    while ((line = reader.readLine()) != null) {
		    	csv+=(line+"\n");
		    	System.out.println(counter);
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        reader.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		if(Trennzeichen!=','){
			csv=csv.replace(',', '.');
			csv=csv.replace(Trennzeichen, ',');
		}
		
	    JSONArray array;
		try {
			array = CDL.toJSONArray(csv);
			return array;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			return null;
		}
	    
	    
	    
	  }
	}


