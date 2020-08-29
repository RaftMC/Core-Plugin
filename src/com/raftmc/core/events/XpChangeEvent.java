package com.raftmc.core.events;

import com.raftmc.core.RaftPlayer;

public class XpChangeEvent extends Event{

	private RaftPlayer raftPlayer;
	private int oldXp;
	private int newXp;
	
	public XpChangeEvent(RaftPlayer raftPlayer, int oldXp, int newXp) {
		
		this.raftPlayer = raftPlayer;
		this.oldXp = oldXp;
		this.newXp = newXp;
		
	}
	
	public RaftPlayer getRaftPlayer() {
		
		return raftPlayer;
		
	}

	public int getOldXp() {
		
		return oldXp;
		
	}
	
	public int getNewXp() {
		
		return newXp;
		
	}
	
}
