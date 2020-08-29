package com.raftmc.core;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.Player;

import com.raftmc.core.events.BalanceChangeEvent;
import com.raftmc.core.events.LevelChangeEvent;
import com.raftmc.core.events.SkillPointsChangeEvent;
import com.raftmc.core.events.XpChangeEvent;

public class RaftPlayer implements ConfigurationSerializable {
	
	private Player player;
	private int level;
	private double balance;
	private int xp;
	private int skillPoints;
	private SkillTree skillTree;
	
	public RaftPlayer(Player player, int level, int xp, double balance, int skillPoints, SkillTree skillTree) {
		
		this.player = player;
		this.level = level;
		this.xp = xp;
		this.balance = balance;
		this.skillPoints = skillPoints;
		this.skillTree = skillTree;
		
	}
	
	public RaftPlayer(Player player) {

		this(player, 1, 0, 0, 0, new SkillTree());
		
	}
	
	public int getMaxXp() {
		
		return level * 200;
		
	}
	
	public Player getPlayer() {
		
		return player;
		
	}
	
	public int getXp() {
		
		return xp;
		
	}
	
	public int getLevel() {
		
		return level;
		
	}
	
	public double getBalance() {
		
		return balance;
		
	}
	
	public int getSkillPoints() {
		
		return skillPoints;
		
	}
	
	public void setXp(int value) {
		
		XpChangeEvent event = new XpChangeEvent(this, xp, value);
		Main.getPlugin().getListenerManger().fireEvent(event);
		
		if(!event.isCancelled()) {
			xp = value;
		}
		
	}
	
	public void setLevel(int value) {
		
		LevelChangeEvent event = new LevelChangeEvent(this, level, value);
		Main.getPlugin().getListenerManger().fireEvent(event);
		
		if(!event.isCancelled()) {
			level = value;
		}
		
	}
	
	public void setBalance(double value) {
		
		BalanceChangeEvent event = new BalanceChangeEvent(this, balance, value);
		Main.getPlugin().getListenerManger().fireEvent(event);
		
		if(!event.isCancelled()) {
			balance = value;
		}
		
	}
	
	public void setSkillPoints(int value) {
		
		SkillPointsChangeEvent event = new SkillPointsChangeEvent(this, skillPoints, value);
		Main.getPlugin().getListenerManger().fireEvent(event);
		
		if(!event.isCancelled()) {
			skillPoints = value;
		}
		
	}
	
	@Override
	public Map<String, Object> serialize() {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("playerUUID", player.getUniqueId());
		map.put("level", level);
		map.put("xp", xp);
		map.put("skillPoints", skillPoints);
		map.put("skillTree", skillTree);
		
		return map;
		
	}
	
	public static RaftPlayer deserialize(Map<String, Object> map) {
		
		return new RaftPlayer(Bukkit.getPlayer((UUID) map.get("playerUUID")), (int) map.get("level"), (int) map.get("xp"), (double) map.get("balance"), (int) map.get("skillPoints"), (SkillTree) map.get("skillTree"));
		
	}
	
}
