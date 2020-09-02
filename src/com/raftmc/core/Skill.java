package com.raftmc.core;

public enum Skill {

	//TODO Add Real Skills
	TEST(1);
	
	private int maxLevel;
	
	private Skill(int maxLevel) {
		
		this.maxLevel = maxLevel;
		
	}
	
	public int getMaxLevel() {
		
		return maxLevel;
		
	}
	
}
