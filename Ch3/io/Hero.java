package io;

import java.io.Serializable;

public class Hero implements Serializable{
	public String name;
	public int hp;
	
	public Hero(String name,int hp) {
		this.name=name;
		this.hp=hp;
	}
	
	public Hero(String name) {
		this.name=name;
	}
}
