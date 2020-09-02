package com.raftmc.core;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import com.raftmc.core.events.RaftUnlockEvent;
import com.raftmc.core.utils.Area;

public class Raft implements ConfigurationSerializable{

	private Area totalArea;
	private Area unlockedArea;
	private Location spawn;
	
	public Raft(Area totalArea, Area unlockedArea, Location spawn) {
		
		this.totalArea = totalArea;
		this.unlockedArea = unlockedArea;
		this.spawn = spawn;
		
	}
	
	public Area getTotalArea() {
		
		return totalArea;
		
	}
	
	public Area getUnlockedArea() {
		
		return unlockedArea;
		
	}
	
	public Location getSpawn() {
		
		return spawn;
		
	}
	
	public void setSpawn(Location location) {
		
		spawn = location;
		
	}
	
	protected void setUnlockedArea(Area value) {
		
		unlockedArea = value;
		
	}
	
	public void changeUnlockedArea(Area value) {
		
		RaftUnlockEvent event = new RaftUnlockEvent(this, unlockedArea, value);
		
		if(Main.getPlugin().getListenerManger().fireEvent(event)) {
			setUnlockedArea(event.getNewArea());
		}
		
	}
	
	@Override
	public Map<String, Object> serialize() {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("totalArea", totalArea);
		map.put("unlockedArea", unlockedArea);
		map.put("spawn", spawn);
		
		return map;
		
	}
	
	public static Raft deserialize(Map<String, Object> map) {
		
		return new Raft((Area) map.get("totalArea"), (Area) map.get("unlockedArea"), (Location) map.get("spawn"));
		
	}

}
