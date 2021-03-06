package main.java;

import java.util.ArrayList;
import java.util.Map;

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
	private String file;
	JSONObject data;
	JSONArray nodes, links;
	private ArrayList<Character> characters;
	private ControlP5 cp5;
	Character chs;
	private String title;
	private int episode;
	private final static int width = 1200, height = 650;
	
	private int count;
	
	
	public void setup() {
		characters = new ArrayList<Character>();
		size(width, height);
		smooth();
		
		cp5=new ControlP5(this);
		cp5.addButton("Clear")
			.setLabel("C l e a r")
			.setPosition(width-250, height-500)
			.setSize(200,50);
		cp5.addButton("Add")
			.setLabel("A d d    A l l")
			.setPosition(width-250, height-600)
			.setSize(200,50);
		
		cp5.getController("Clear")
	       .getCaptionLabel()
	       .setSize(22);
		cp5.getController("Add")
	       .getCaptionLabel()
	       .setSize(24);
	     
		chs=new Character(this);
		count = 0;
		episode = 1;
		
		file = "starwars-episode-"+episode+"-interactions.json";
		title = "Star Wars "+episode;
		loadData();
	}

	public void draw() {
		
		background(230);
		textSize(32);
		text(title, width/2, 30);
		noFill();
		stroke(150, 200, 200);
		strokeWeight(10);
		ellipse (700,350, 500, 500);
		
		fill(150, 200, 200);
		noStroke();
		
		count=0;
		for(Character ch : characters) if(ch.isActivated()) count++;
		

		int i=0;
		double rate = 0; 
		if(count>0) rate = 360/count; 
		for(Character ch : characters){
			if(ch.isActivated()==false){
				ch.display();
			}else if(ch.isActivated()==true){
				ch.display((int)(700+250*Math.sin(  Math.toRadians(rate*i)   )), (int)(350+250*Math.cos(Math.toRadians(rate*i) )) );
				i++;
			}
		}
		
		for(Character ch : characters){
			if(  Math.abs(this.mouseX - ch.x)<25 && Math.abs(this.mouseY - ch.y)<25 ){
				fill(ch.colour);
				rect(ch.x, ch.y-25, 75, 30);
				fill(255);
				textSize(14);
				text(ch.name, ch.x, ch.y-10);
			}
		}
		
		for(Character ch : characters){
			if(ch.isActivated()==true){
				Map<Character,Integer> m = ch.getTargets();
				for(Character c : characters){	
					if(c.isActivated() && m.containsKey(c)){
						stroke(0);
						strokeWeight(m.get(c)/2 + 1);
						line(ch.x, ch.y, c.x, c.y);
					}
				}
			}
		}
	
	}
	
	public void mouseClicked(){
		for(Character ch : characters){
			if(  Math.abs(this.mouseX - ch.x)<25 && Math.abs(this.mouseY - ch.y)<25 ){
				ch.changeActivate();
			}
		}
	}
	
	public void keyPressed(){
		if(key=='1'){
			episode = 1;
		}else if(key=='2'){
			episode = 2;
		}else if(key=='3'){
			episode = 3;
		}else if(key=='4'){
			episode = 4;
		}else if(key=='5'){
			episode = 5;
		}else if(key=='6'){
			episode = 6;
		}else if(key=='7'){
			episode = 7;
		}
		file = "starwars-episode-"+episode+"-interactions.json";
		title = "Star Wars "+episode;
		characters.clear();
		loadData();
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
		 
		 
		 int i=0;
		 int x=60,y=35;
		 for(Character ch : characters){
			 ch.inix = ch.x = 35+x*i;
			 ch.iniy = ch.y = y;
			 i++;
			 if(i>3){
				 i=0;
				 y +=60;
			 }
		 }
		 
	}

}
