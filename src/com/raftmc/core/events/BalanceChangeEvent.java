package com.raftmc.core.events;

import com.raftmc.core.RaftPlayer;

public class BalanceChangeEvent extends Event{

	private RaftPlayer raftPlayer;
	private double oldBalance;
	private double newBalance;
	
	public BalanceChangeEvent(RaftPlayer raftPlayer, double oldBalance, double newBalance) {
		
		this.raftPlayer = raftPlayer;
		this.oldBalance = oldBalance;
		this.newBalance = newBalance;
		
	}
	
	public RaftPlayer getRaftPlayer() {
		
		return raftPlayer;
		
	}

	public double getOldBalance() {
		
		return oldBalance;
		
	}
	
	public double getNewBalance() {
		
		return newBalance;
		
	}
	
	public void setNewBalance(double value) {
		
		newBalance = value;
		
	}
	
}
