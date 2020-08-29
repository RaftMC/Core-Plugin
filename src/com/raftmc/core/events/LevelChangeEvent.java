package com.raftmc.core.events;

import com.raftmc.core.RaftPlayer;

public class LevelChangeEvent extends Event{

	private RaftPlayer raftPlayer;
	private int oldLevel;
	private int newLevel;
	
	public LevelChangeEvent(RaftPlayer raftPlayer, int oldLevel, int newLevel) {
		
		this.raftPlayer = raftPlayer;
		this.oldLevel = oldLevel;
		this.newLevel = newLevel;
		
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
	
}
