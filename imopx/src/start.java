

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.*;

import backup.CSV_Extractor;


public class start {
	
	public static void main(String[] args) throws JSONException{
	/*	
		SQLConnection con = new SQLConnection();
		con.connectToMysql("192.168.182.129","test","remote","admin");
		Connection connection = con.connection;
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String selectSQL = "SELECT * from bla ? ?";
		
		try {
			ps = connection.prepareStatement(selectSQL);
			//ps.setString(1,"hallo");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("blu"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		*/
		
		//Dimension pat = new Dimension(EnumDim.Patient);
		//System.out.println(pat.longs.length);
		
		
	/*JSONArray a =  CSV_Extractor.getJSON("C:\\Users\\Markus\\Desktop\\Config.csv",',');

	System.out.println(a.toString(2));
	JSONObject o = a.getJSONObject(0);
	System.out.println(o);
	
	String url ="C:/Users/Markus/Desktop/Config.csv";
	String fileName = url.substring( url.lastIndexOf('/')+1, url.length() );

	String fileNameWithoutExtn = fileName.substring(0, fileName.lastIndexOf('.'));
	
	System.out.println(fileNameWithoutExtn);
	*/
		
		
	}
}
		


