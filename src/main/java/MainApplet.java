package main.java;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PFont;
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
	
	private final static int width = 1200, height = 650;
	
	public void setup() {
		characters = new ArrayList<Character>();
		size(width, height);
		smooth();
		loadData();
	}

	public void draw() {
		
		background(230);
		
		int i=0;
		int x = 60, y = 35;
		for(Character ch : characters){
			if(ch.isActivated()==false){
				ch.display(35+x*i, y);
			}
			i++;
			if(i>3){
				i=0;
				y += 60;
			}
		}
		/*Graphics g = null;
		g.setColor(Color.red);	*/
		noFill();
		stroke(150, 200, 200);
		strokeWeight(10);
		ellipse (700,350, 500,500);
		
		fill(150, 200, 200);
		noStroke();
		rect(1000, 40, 100, 50);
		rect(1000, 150, 100, 50);
		fill(255);
		textSize(23);
		this.text("Add All", 1005, 75);
		this.text("Clear All", 1005, 185);
	}
	
	
	
	

	private void loadData(){
		 
		int source;
		int target;
		int value;
		int colour;
		
		 data=loadJSONObject(path+file);
		 nodes=data.getJSONArray("nodes");
		 links=data.getJSONArray("links");
		 for(int i=0;i<nodes.size();i++){
			  JSONObject a=nodes.getJSONObject(i);
			  String str=a.getString("colour");
			  str = str.substring(1);
			  Character ch = new Character(this, a.getString("name"), str);
			  characters.add(ch);	
				
		 }
		 for(int i=0;i<links.size();i++){
			 JSONObject a=links.getJSONObject(i);
			 source = a.getInt("source");
			 target = a.getInt("target");
			 value =a.getInt("value");
			 characters.get(source).addTarget(characters.get(target),value);
		 }
	}

}
