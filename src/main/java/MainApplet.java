package main.java;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;
import controlP5.*;    // import controlP5 library

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
	private ControlP5 cp5;
	Character chs;
	private final static int width = 1200, height = 650;
	
	private int count;
	
	
	public void setup() {
		characters = new ArrayList<Character>();
		size(width, height);
		smooth();
		loadData();
		cp5=new ControlP5(this);
		cp5.addButton("Clear")
			.setLabel("Clear")
			.setPosition(width-200, height-500)
			.setSize(100,50);
		cp5.addButton("Add")
		.setLabel("Add")
		.setPosition(width-200, height-600)
		.setSize(100,50);
		chs=new Character(this);
		count = 0;
	}

	public void draw() {
		
		background(230);
		noFill();
		stroke(150, 200, 200);
		strokeWeight(10);
		ellipse (700,350, 500, 500);
		
		fill(150, 200, 200);
		noStroke();
		
		int i=0;
		int x = 60, y = 35;
		for(Character ch : characters){
			if(ch.isActivated()==false){
				ch.display(35+x*i, y);
			}//else if(ch.isActivated()==true)ch.display(0,0);
			i++;
			if(i>3){
				i=0;
				y += 60;
			}
		}
		
		i=0;
		double rate = 0;
		if(count>0) rate = 360/count;
		for(Character ch : characters){
			if(ch.isActivated()==true){
				ch.display((int)(700+250*Math.sin(rate*i)), (int)(350-250*Math.cos(rate*i)) );
			}
			i++;
		}
		
		for(Character ch : characters){
			if(  Math.abs(this.mouseX - ch.x)<25 && Math.abs(this.mouseY - ch.y)<25 && ch.isActivated()==false){
				fill(ch.colour);
				rect(ch.x, ch.y-25, 75, 30);
				fill(255);
				textSize(14);
				text(ch.name, ch.x, ch.y-10);
			}
		}
	
	}
	
	public void Clear(){
		count = 0;
		for(Character ch : characters)
			ch.setActivate(false);
		
	}
	public void Add(){
		count = characters.size();
		for(Character ch : characters)
			ch.setActivate(true);
	}
	
	

	private void loadData(){
		 
		int source;
		int target;
		int value;
		
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
