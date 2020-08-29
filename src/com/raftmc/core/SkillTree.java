package com.raftmc.core;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

public class SkillTree implements ConfigurationSerializable{
	
	public SkillTree() {
		
	}
	
	@Override
	public Map<String, Object> serialize() {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		return map;
		
	}
	
	public static SkillTree deserialize(Map<String, Object> map) {
		
		return new SkillTree();
		
	}
	
}
