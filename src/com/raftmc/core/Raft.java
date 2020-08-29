package com.raftmc.core;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import com.raftmc.core.utils.Area;

public class Raft implements ConfigurationSerializable{

	private Area area;
	private Location spawn;
	
	public Raft(Area area, Location spawn) {
		
		this.area = area;
		this.spawn = spawn;
		
	}
	
	public Area getArea() {
		
		return area;
		
	}
	
	public Location getSpawn() {
		
		return spawn;
		
	}
	
	public void setSpawn(Location location) {
		
		spawn = location;
		
	}
	
	@Override
	public Map<String, Object> serialize() {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("area", area);
		map.put("spawn", spawn);
		
		return map;
		
	}
	
	public static Raft deserialize(Map<String, Object> map) {
		
		return new Raft((Area) map.get("area"), (Location) map.get("spawn"));
		
	}

}
