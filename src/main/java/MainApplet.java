package main.java;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;

/**
* This class is for sketching outcome using Processing
* You can do major UI control and some visualization in this class.  
*/
@SuppressWarnings("serial")
public class MainApplet extends PApplet{
	private String path = "main/resources/";
	private String file = "starwars-episode-1-interactions.json";
	JSONObject data;
	JSONArray nodes, links;
	private ArrayList<Character> characters;
	int source;
	int target;
	int value;
	int colour;
	private final static int width = 1200, height = 650;
	
	public void setup() {

		size(width, height);
		smooth();
		loadData();
		
	}

	public void draw() {

	}

	private void loadData(){
		 data=loadJSONObject(path+file);
		 nodes=data.getJSONArray("nodes");
		 links=data.getJSONArray("links");
		 for(int i=0;i<nodes.size();i++){
			  JSONObject a=nodes.getJSONObject(i);
			  String str=a.getString("colour");
			  str = str.substring(1);
			  long c = Long.parseLong(str,16);
			  System.out.println(c);
			 // Character ch = new Character(this, a.getString("name"),(int)(Math.random()*750),(int)(Math.random()*750) );
			//characters.add(ch);	
				
		 }
		 for(int i=0;i<links.size();i++){
			 JSONObject a=links.getJSONObject(i);
			 source = a.getInt("source");
			 target = a.getInt("target");
			 value =a.getInt("value");
			 // characters.get(source).addTarget(characters.get(target));
		 }
	}

}
