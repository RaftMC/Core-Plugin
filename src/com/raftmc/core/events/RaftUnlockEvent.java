package com.raftmc.core.events;

import com.raftmc.core.Raft;
import com.raftmc.core.utils.Area;

public class RaftUnlockEvent extends Event{

	private Raft raft;
	private Area oldArea;
	private Area newArea;
	
	public RaftUnlockEvent(Raft raft, Area oldArea, Area newArea) {
		
		this.raft = raft;
		this.oldArea = oldArea;
		this.newArea = newArea;
		
	}
	
	public Raft getRaft() {
		
		return raft;
		
	}

	public Area getOldArea() {
		
		return oldArea;
		
	}
	
	public Area getNewArea() {
		
		return newArea;
		
	}
	
	public void setNewArea(Area value) {
		
		newArea = value;
		
	}
	
}
