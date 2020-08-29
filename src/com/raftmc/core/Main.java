package com.raftmc.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

import com.raftmc.core.events.ListenerManager;
import com.raftmc.core.utils.Area;
import com.raftmc.core.utils.Point;

public class Main extends JavaPlugin{

	private ArrayList<RaftPlayer> raftPlayers;
	private File playersFile;
	private FileConfiguration playersConfig;
	private static Main main;
	private ListenerManager listenerManager;
	private RaftManager raftManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public void onEnable() {
		
		main = this;
		
		ConfigurationSerialization.registerClass(RaftPlayer.class);
		ConfigurationSerialization.registerClass(Raft.class);
		ConfigurationSerialization.registerClass(SkillTree.class);
		ConfigurationSerialization.registerClass(Area.class);
		ConfigurationSerialization.registerClass(Point.class);
		
		listenerManager = new ListenerManager();
		
		raftManager = new RaftManager();
		
		playersFile = new File(getDataFolder() + File.separator + "players");
		
		try {
			playersFile.createNewFile();
		} catch (IOException e) {
			getLogger().warning("Error while creating the players file.");
			e.printStackTrace();
		}
		
		playersConfig = YamlConfiguration.loadConfiguration(playersFile);
		
		if(playersConfig.isSet("raftPlayers")) {
			raftPlayers = (ArrayList<RaftPlayer>) playersConfig.getList("raftPlayers");
		}else {
			raftPlayers = new ArrayList<RaftPlayer>();
		}
		
	}
	
	public ArrayList<RaftPlayer> getRaftPlayers() {
		
		return raftPlayers;
		
	}
	
	public RaftPlayer getRaftPlayer(UUID uuid) {

		for (RaftPlayer player : raftPlayers) {

			if (player.getPlayer().getUniqueId().equals(uuid)) {
				return player;
			}

		}

		return null;

	}
	
	public RaftPlayer getRaftPlayer(String name) {

		for (RaftPlayer player : raftPlayers) {

			if (player.getPlayer().getName().equals(name)) {
				return player;
			}

		}

		return null;

	}
	
	public ListenerManager getListenerManger() {
		
		return listenerManager;
		
	}
	
	public RaftManager getRaftManager() {
		
		return raftManager;
		
	}
	
	@Override
	public void onDisable() {

		playersConfig.set("raftPlayers", raftPlayers);
		
		try {
			playersConfig.save(playersFile);
		} catch (IOException e) {
			getLogger().warning("Error while trying to save config.");
			e.printStackTrace();
		}

	}
	
	public static Main getPlugin() {
		
		return main;
		
	}
	
}
