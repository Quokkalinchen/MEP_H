package backup;

import org.json.*;

public enum EnumDim {
	
	/*	Hier wird die Länge der Arrays beschrieben
	 * 	Die Länge bleibt immer gleich, da Sie das Sternschema beschreibt 
	 */
		Patient(5,5,"Patient"), 		
		Observation(3,3,"Observation"), 
		Visit(3,3,"Visit"), 
		Provider(3,3,"Provider"), 
		Concept(3,3,"Concept");
	
	
	public int longArray;
	public int stringArray;
	public String name;
	public JSONArray config;
	
	private EnumDim(int longArray, int stringArray,String name){
		this.longArray=longArray;
		this.stringArray=stringArray;
		this.name= name;
		
	}
	
public void getConfig(JSONArray jsonArray){
		
	JSONArray configtmp= new JSONArray();
		for(int i=0; i<jsonArray.length();i++){
			try {
				if(jsonArray.getJSONObject(i).get("Dimension").equals(name)){
				configtmp.put(jsonArray.getJSONObject(i));
				
				}
			} catch (JSONException e) {
				e.getMessage();
			}
		}
		config=configtmp;
	}

}
