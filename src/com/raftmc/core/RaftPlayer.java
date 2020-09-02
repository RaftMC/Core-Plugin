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
	private long xp;
	private int skillPoints;
	private SkillTree skillTree;
	private Raft raft;
	
	public RaftPlayer(Player player, int level, long xp, double balance, int skillPoints, SkillTree skillTree, Raft raft) {
		
		this.player = player;
		this.level = level;
		this.xp = xp;
		this.balance = balance;
		this.skillPoints = skillPoints;
		this.skillTree = skillTree;
		this.raft = raft;
		
	}
	
	//For new players
	public RaftPlayer(Player player) {

		this(player, 1, 0, 0, 0, new SkillTree(), null);
		
	}
	
	public long getMaxXp() {
		
		return (long) (Math.pow(level, 2) * 2);
		
	}
	
	public Player getPlayer() {
		
		return player;
		
	}
	
	public long getXp() {
		
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
	
	public Raft getRaft() {
		
		return raft;
		
	}
	
	protected void setXp(long value) {
		
		xp = value;
		
	}
	
	protected void setLevel(int value) {
		
		level = value;
		
	}
	
	protected void setBalance(double value) {
		
		balance = value;
		
	}
	
	protected void setSkillPoints(int value) {
		
		skillPoints = value;
		
	}
	
	protected void setRaft(Raft raft) {
		
		this.raft = raft;
		
	}
	
	public void addXp(long amount, boolean autoLevel) {
		
		XpChangeEvent event = new XpChangeEvent(this, xp, xp + amount, autoLevel);
		
		if(Main.getPlugin().getListenerManger().fireEvent(event)) {
			setXp(event.getNewXp());
			
			if(xp >= getMaxXp() && event.isAutoLeveling()) {
				levelUp(false);
			}
		}
		
	}
	
	public void levelUp(boolean addXp) {
		
		LevelChangeEvent event = new LevelChangeEvent(this, level, level + 1, addXp);
		
		if(Main.getPlugin().getListenerManger().fireEvent(event)) {
			if(event.isAddingXp()) {
				addXp(getMaxXp() - xp, false);
			}
			
			setLevel(event.getNewLevel());
		}
		
	}
	
	public void addSkillPoints(int amount) {
		
		SkillPointsChangeEvent event = new SkillPointsChangeEvent(this, skillPoints, skillPoints + amount);
		
		if(Main.getPlugin().getListenerManger().fireEvent(event)) {
			
			setSkillPoints(event.getNewSkillPoints());
			
		}
		
	}
	
	public void removeSkillPoints(int amount) {
		
		SkillPointsChangeEvent event = new SkillPointsChangeEvent(this, skillPoints, skillPoints - amount);
		
		if(Main.getPlugin().getListenerManger().fireEvent(event)) {
			
			setSkillPoints(event.getNewSkillPoints());
			
		}
		
	}
	
	public void addBalance(double amount) {
		
		BalanceChangeEvent event = new BalanceChangeEvent(this, balance, balance + amount);
		
		if(Main.getPlugin().getListenerManger().fireEvent(event)) {
			
			setBalance(event.getNewBalance());
			
		}
		
	}
	
	public void removeBalance(double amount) {
		
		BalanceChangeEvent event = new BalanceChangeEvent(this, balance, balance - amount);
		
		if(Main.getPlugin().getListenerManger().fireEvent(event)) {
			
			setBalance(event.getNewBalance());
			
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
		
		return new RaftPlayer(Bukkit.getPlayer((UUID) map.get("playerUUID")), (int) map.get("level"), (long) map.get("xp"), (double) map.get("balance"), (int) map.get("skillPoints"), (SkillTree) map.get("skillTree"), (Raft) map.get("raft"));
		
	}
	
}
