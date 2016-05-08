package main.java;

import java.util.ArrayList;
import processing.core.PApplet;

/**
* This class is used to store states of the characters in the program.
* You will need to declare other variables depending on your implementation.
*/
public class Character {
	
	private MainApplet parent;
	public float x, y, radius;
	public int value;
	
	private String name;
	private ArrayList<Character> targets;

	public Character(MainApplet parent){
		this.parent = parent;
		this.name = "";
		this.targets =  new ArrayList<Character>();
		
	}
	
	public Character(MainApplet parent, String name, float x, float y){
		this.parent = parent;
		this.name = name;
		this.x = x;
		this.y = y;
		this.radius = 50;
		this.targets =  new ArrayList<Character>();
	}

	public void display(){
		this.parent.rect(this.x, this.y, 50, 30);
		this.parent.text(this.name, x, y);
		this.parent.fill(0,102,153);
	}
	
	public void addTarget(Character t){
		this.targets.add(t);
	}
	
	public ArrayList<Character> getTargets(){
		return this.targets;
	}
	
}
