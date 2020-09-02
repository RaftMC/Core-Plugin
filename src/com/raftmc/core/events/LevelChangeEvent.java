package com.raftmc.core.events;

import com.raftmc.core.RaftPlayer;

public class LevelChangeEvent extends Event{

	private RaftPlayer raftPlayer;
	private int oldLevel;
	private int newLevel;
	private boolean addXp;
	
	public LevelChangeEvent(RaftPlayer raftPlayer, int oldLevel, int newLevel, boolean addXp) {
		
		this.raftPlayer = raftPlayer;
		this.oldLevel = oldLevel;
		this.newLevel = newLevel;
		this.addXp = addXp;
		
	}
	
	public RaftPlayer getRaftPlayer() {
		
		return raftPlayer;
		
	}

	public int getOldLevel() {
		
		return oldLevel;
		
	}
	
	public int getNewLevel() {
		
		return newLevel;
		
	}
	
	public boolean isAddingXp() {
		
		return addXp;
		
	}
	
	public void setAddXp(boolean value) {
		
		addXp = value;
		
	}
	
	public void setNewLevel(int value) {
		
		newLevel = value;
		
	}
	
}
