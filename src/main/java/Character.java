package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import processing.core.PApplet;

/**
* This class is used to store states of the characters in the program.
* You will need to declare other variables depending on your implementation.
*/
public class Character {
	
	private MainApplet parent;
	public int value;
	public long colour;
	private String name;
	private boolean activate;
	private Map<Character,Integer> targets;

	public Character(MainApplet parent){
		this.parent = parent;
		this.name = "";
		this.targets =  new HashMap<Character,Integer>();
		this.activate = false;
		
	}
	
	public Character(MainApplet parent, String name, long color){
		this.parent = parent;
		this.name = name;
		this.colour = color;
		this.targets =  new HashMap<Character,Integer>();
		this.activate = false;
	}

	public void display(int x, int y){
		this.parent.ellipse(x, y, 30, 30);
		//this.parent.text(this.name, x, y);
		this.parent.fill(this.colour);
	}
	
	public boolean isActivated(){
		return this.activate;
	}
	
	public void changeActivate(){
		if(this.activate==true) this.activate = false;
		else this.activate = true;
	}
	
	public void setActivate(boolean b){
		this.activate = b;
	}
	
	public void addTarget(Character t, int value){
		this.targets.put(t,value);
	}
	
	public Map<Character,Integer> getTargets(){
		return this.targets;
	}
	
}
