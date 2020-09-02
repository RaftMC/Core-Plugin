package com.raftmc.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class RaftPlayerManager {

	private ArrayList<RaftPlayer> raftPlayers;
	private File raftPlayersFile;
	private FileConfiguration raftPlayersConfig;
	
	@SuppressWarnings("unchecked")
	public RaftPlayerManager() {
		
		raftPlayersFile = new File(Main.getPlugin().getDataFolder() + File.separator + "raftPlayers");
		
		try {
			raftPlayersFile.createNewFile();
		} catch (IOException e) {
			Main.getPlugin().getLogger().warning("Error while creating the players file.");
			e.printStackTrace();
		}
		
		raftPlayersConfig = YamlConfiguration.loadConfiguration(raftPlayersFile);
		
		if(raftPlayersConfig.isSet("raftPlayers")) {
			raftPlayers = (ArrayList<RaftPlayer>) raftPlayersConfig.getList("raftPlayers");
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
	
	public void deleteRaftPlayer(RaftPlayer raftPlayer) {
		
		raftPlayers.remove(raftPlayer);
		
	}
	
	public void saveFile() throws IOException {
		
		raftPlayersConfig.set("raftPlayers", raftPlayers);
		raftPlayersConfig.save(raftPlayersFile);
		
	}
	
}
