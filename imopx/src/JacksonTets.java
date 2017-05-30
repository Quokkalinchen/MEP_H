import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.*;


public class JacksonTets {

	public static void main(String[] args) throws JSONException {
		 
		BufferedReader reader = null;
		String csv = "";
		

		try {
		    File file = new File("C:\\Users\\Markus\\Desktop\\MEP\\BSPDaten §21\\FALL.csv");
		    reader = new BufferedReader(new FileReader(file));

		    String line;
		    while ((line = reader.readLine()) != null) {
		    	csv+=(line+"\n");
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
		
		csv=csv.replace(';', ',');
		
	    JSONArray array = CDL.toJSONArray(csv);
	    System.out.println(array.toString(2)); //pretty print with indent
	    JSONObject o = new JSONObject();
	    o=array.getJSONObject(0);
	    //System.out.println(o.get("IK"));
	    
	    
	  }
   
 
}