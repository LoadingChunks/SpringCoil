package net.LoadingChunks.SpringCoil.api;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public interface CoilInterface {
	public ArrayList<String> getPlayerList(String server);

	public int getPlayerCount(String server);
	
	public ArrayList<String> getServerList();

	public void sendToServer(String server, String command);

	public void sendToAllServers(String command);

	public void connectPlayerToServer(Player player, String server);
}
