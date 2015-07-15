package lytmus;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonTesting {
	public static void main(String args[]){
		JSONObject obj= new JSONObject();
		JSONArray arr= new JSONArray();
		try {
			obj.put("Name" , "abhishek");
			obj.put("Age","24");
			arr.put(100);
			arr.put(200);
			obj.put("list", arr);
			
			FileWriter file = new FileWriter("test.json");
			file.write(obj.toString());
			file.flush();
			file.close();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
