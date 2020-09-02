package com.raftmc.core;

import org.bukkit.Bukkit;
import org.bukkit.World;

import com.raftmc.core.utils.Area;
import com.raftmc.core.utils.Point;

public class RaftManager {
	
	private final static World raftWorld = Bukkit.getWorld("raftWorld");
	
	public RaftManager() {
		
		
		
	}
	
	public Raft getRaftAt(Point point) {
		
		for(RaftPlayer raftPlayer : Main.getPlugin().getRaftPlayerManager().getRaftPlayers()) {
			
			if(raftPlayer.getRaft() != null) {
				
				if(raftPlayer.getRaft().getTotalArea().containsPoint(point)) {
					
					return raftPlayer.getRaft();
					
				}
				
			}
			
		}
		
		return null;
		
	}
	
	public Raft getHighestRaft() {
		
		Point highestCenterPoint = new Point(0, 0);
		
		for(RaftPlayer raftPlayer : Main.getPlugin().getRaftPlayerManager().getRaftPlayers()) {
			if(raftPlayer.getRaft() != null) {
				
				Raft raft = raftPlayer.getRaft();
				
				if(raft.getTotalArea().getCenter().getZ() > highestCenterPoint.getZ()) {
					
					highestCenterPoint = raft.getTotalArea().getCenter().clone();
					
				}else if(raft.getTotalArea().getCenter().getZ() == highestCenterPoint.getZ() && raft.getTotalArea().getCenter().getX() > highestCenterPoint.getX()) {
					
					highestCenterPoint = raft.getTotalArea().getCenter().clone();
					
				}
			}
		}
		
		return getRaftAt(highestCenterPoint);
		
	}
	
	public Point getNextRaftCenterPoint() {
		
		Point raftCenter = getHighestRaft().getTotalArea().getCenter();
		
		if(raftCenter == null) {
			return new Point(0, 0);
		}
		
		if(raftCenter.getX() == 1280) {
			
			raftCenter.setX(0);
			raftCenter.setZ(raftCenter.getZ() + 128);
			
		}else {
			
			raftCenter.setX(raftCenter.getX() + 128);
			
		}
		
		return raftCenter;
		
	}
	
	public Raft newRaft() {
		
		return new Raft(new Area(getNextRaftCenterPoint(), 64), new Area(getNextRaftCenterPoint(), 32), getNextRaftCenterPoint().toLocation(raftWorld, 64));
		
	}
	
	public void deleteRaft(Raft raft) {
		
		//TODO Reset Blocks in Raft
		
	}
	
}
