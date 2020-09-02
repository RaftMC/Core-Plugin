package com.raftmc.core.events;

import com.raftmc.core.RaftPlayer;

public class SkillPointsChangeEvent extends Event{

	private RaftPlayer raftPlayer;
	private int oldSkillPoints;
	private int newSkillPoints;
	
	public SkillPointsChangeEvent(RaftPlayer raftPlayer, int oldSkillPoints, int newSkillPoints) {
		
		this.raftPlayer = raftPlayer;
		this.oldSkillPoints = oldSkillPoints;
		this.newSkillPoints = newSkillPoints;
		
	}
	
	public RaftPlayer getRaftPlayer() {
		
		return raftPlayer;
		
	}

	public int getOldSkillPoints() {
		
		return oldSkillPoints;
		
	}
	
	public int getNewSkillPoints() {
		
		return newSkillPoints;
		
	}
	
	public void setNewSkillPoints(int value) {
		
		newSkillPoints = value;
		
	}
	
}
