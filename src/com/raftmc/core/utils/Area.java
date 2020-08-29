package com.raftmc.core.utils;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

public class Area implements ConfigurationSerializable{

	private Point minCoord;
	private Point maxCoord;
	
	public Area(Point coord1, Point coord2){
		
		double minX = Math.min(coord1.getX(), coord2.getX());
		double minZ = Math.min(coord1.getZ(), coord2.getZ());
		
		double maxX = Math.max(coord1.getX(), coord2.getX());
		double maxZ = Math.max(coord1.getZ(), coord2.getZ());
		
		minCoord = new Point(minX, minZ);
		maxCoord = new Point(maxX, maxZ);
		
	}
	
	public Area(Point center, int apothem){
		
		minCoord = new Point(center.getX() - apothem, center.getZ() - apothem);
		maxCoord = new Point(center.getX() + apothem, center.getZ() + apothem);
		
	}
	
	public boolean containsPoint(Point point) {
		
		if((point.getX() > minCoord.getX() && point.getX() < maxCoord.getX()) && (point.getZ() > minCoord.getZ() && point.getZ() < maxCoord.getZ())) {
			return true;
		}else {
			return false;
		}
	
	}
	
	public Point getCenter() {
		
		return maxCoord.midpoint(minCoord);
	
	}

	@Override
	public HashMap<String, Object> serialize() {
		
		HashMap<String, Object> serializeMap = new HashMap<String, Object>();
		serializeMap.put("minCoord", minCoord);
		serializeMap.put("maxCoord", maxCoord);
		return serializeMap;
		
	}
	
	public static Area deserialize(Map<String, Object> map){
		
		return new Area((Point) map.get("minCoord"), (Point) map.get("maxCoord"));
		
	}
	
}
