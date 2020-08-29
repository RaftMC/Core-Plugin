package com.raftmc.core.utils;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

public class Point implements ConfigurationSerializable, Cloneable{

	private double x;
	private double z;

	public Point(double x, double z) {

		this.x = x;
		this.z = z;

	}
	
	public Point(Location location) {
		
		this.x = location.getX();
		this.z = location.getZ();
		
	}

	public double getX() {

		return x;

	}

	public double getZ() {

		return z;

	}

	public void setX(double value) {

		x = value;

	}

	public void setZ(double value) {

		z = value;

	}
	
	public Point midpoint(Point point) {
		
		return new Point((x + point.getX())/2, (z + point.getZ())/2);
		
	}
	
	public Location toLocation(World world, double y) {
		
		return new Location(world, x, y, z);
		
	}

	@Override
	public Point clone() {
		
		return new Point(x, z);
		
	}
	
	@Override
	public Map<String, Object> serialize() {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("x", x);
		map.put("z", z);
		
		return map;
		
	}
	
	public static Point deserialize(Map<String, Object> map) {
		
		return new Point((double) map.get("x"), (double) map.get("z"));
		
	}

}
