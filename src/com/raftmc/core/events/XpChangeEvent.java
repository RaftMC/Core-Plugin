package com.raftmc.core.events;

import com.raftmc.core.RaftPlayer;

public class XpChangeEvent extends Event{

	private RaftPlayer raftPlayer;
	private long oldXp;
	private long newXp;
	private boolean autoLevel;
	
	public XpChangeEvent(RaftPlayer raftPlayer, long oldXp, long newXp, boolean autoLevel) {
		
		this.raftPlayer = raftPlayer;
		this.oldXp = oldXp;
		this.newXp = newXp;
		this.autoLevel = autoLevel;
		
	}
	
	public RaftPlayer getRaftPlayer() {
		
		return raftPlayer;
		
	}

	public long getOldXp() {
		
		return oldXp;
		
	}
	
	public long getNewXp() {
		
		return newXp;
		
	}
	
	public boolean isAutoLeveling() {
		
		return autoLevel;
		
	}
	
	public void setNewXp(long value) {
		
		newXp = value;
		
	}
	
	public void setAutoLevel(boolean value) {
		
		autoLevel = value;
		
	}
	
}
