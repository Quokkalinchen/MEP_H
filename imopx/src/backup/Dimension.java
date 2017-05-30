package backup;
import org.json.*;

public class Dimension {

	EnumDim dim;
	public String[] strings;
	public long[] longs;
	
	public Dimension(EnumDim dim){
		this.dim=dim;
		strings = new String[dim.stringArray];
		longs = new long[dim.longArray];
	}
	
	public void fill(JSONObject o) throws JSONException{
		JSONObject configo;
		for(int i=0; i<dim.config.length();i++){
			configo=dim.config.getJSONObject(i);
			if(configo.get("Array").equals("String")){
				/*Es wird etwas in die Stelle in Strings geschrieben
				 * Die Stelle wird durch die config Datei gegeben ->configo.get("Stelle")
				 * In diese Stelle wird ein Wert geschrieben den wir aus dem Objekt o entnehmen
				 * Welcher Wert wird durch die config Datei beschrieben -> configo.get("CSV-Name")
				*/
				strings[Integer.parseInt(configo.get("Stelle").toString())]=o.get(configo.get("CSV-Name").toString()).toString();
			}
		}
		
		
	}
	
}
