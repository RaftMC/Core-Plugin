package com.raftmc.core;

import java.io.IOException;

import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

import com.raftmc.core.events.ListenerManager;
import com.raftmc.core.utils.Area;
import com.raftmc.core.utils.Point;

public class Main extends JavaPlugin{

	private static Main main;
	private RaftPlayerManager raftPlayerManager;
	private ListenerManager listenerManager;
	private RaftManager raftManager;
	
	@Override
	public void onEnable() {
		
		main = this;
		
		ConfigurationSerialization.registerClass(RaftPlayer.class);
		ConfigurationSerialization.registerClass(Raft.class);
		ConfigurationSerialization.registerClass(SkillTree.class);
		ConfigurationSerialization.registerClass(Area.class);
		ConfigurationSerialization.registerClass(Point.class);
		
		raftPlayerManager = new RaftPlayerManager();
		
		listenerManager = new ListenerManager();
		
		raftManager = new RaftManager();
		
	}
	
	public RaftPlayerManager getRaftPlayerManager() {
		
		return raftPlayerManager;
		
	}
	
	public ListenerManager getListenerManger() {
		
		return listenerManager;
		
	}
	
	public RaftManager getRaftManager() {
		
		return raftManager;
		
	}
	
	@Override
	public void onDisable() {
		
		try {
			raftPlayerManager.saveFile();
		} catch (IOException e) {
			getLogger().warning("Error while trying to save raft player file. (onDisable)");
			e.printStackTrace();
		}

	}
	
	public static Main getPlugin() {
		
		return main;
		
	}
	
}
