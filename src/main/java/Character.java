package main.java;

import java.util.HashMap;
import java.util.Map;

/**
* This class is used to store states of the characters in the program.
* You will need to declare other variables depending on your implementation.
*/
public class Character {
	
	private MainApplet parent;
	public int value;
	int x,y;
	int inix,iniy;
	public int colour;
	public String name;
	private boolean activate;
	private Map<Character,Integer> targets;
	boolean C_rectOver,A_rectOver;
	
	public Character(MainApplet parent){
		this.parent = parent;
		this.name = "";
		this.targets =  new HashMap<Character,Integer>();
		this.activate = false;
	}
	
	@SuppressWarnings("static-access")
	public Character(MainApplet parent, String name, String color){
		this.parent = parent;
		this.name = name;
		this.colour = this.parent.unhex(color);
		this.targets =  new HashMap<Character,Integer>();
		this.activate = false;
	}

	public void display(){
		this.parent.fill(this.colour);
		this.parent.ellipse(x, y, 50, 50);	
	}
	
	
	public void display(int x, int y){
		this.x=x; this.y=y;
		this.parent.fill(this.colour);
		this.parent.ellipse(x, y, 50, 50);	
	}
	

	public boolean isActivated(){
		return this.activate;
	}
	
	public void changeActivate(){
		if(this.activate==true) this.activate = false;
		else this.activate = true;
		
		if(this.activate==false){
			this.x = this.inix;
			this.y = this.iniy;
		}
	}
	
	public void setActivate(boolean b){
		this.activate = b;
		if(b==false){
			this.x = this.inix;
			this.y = this.iniy;
		}
	}
	
	public void addTarget(Character t, int value){
		this.targets.put(t,value);
	}
	
	public Map<Character,Integer> getTargets(){
		return this.targets;
	}
	
}
