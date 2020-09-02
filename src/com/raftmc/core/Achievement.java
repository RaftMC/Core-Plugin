package com.raftmc.core;

public enum Achievement {

	//TODO Add Real Achievements
	TEST(1);
	
	private int maxLevel;
	
	private Achievement(int maxLevel) {
		
		this.maxLevel = maxLevel;
		
	}
	
	public int getMaxLevel() {
		
		return maxLevel;
		
	}
	
}
