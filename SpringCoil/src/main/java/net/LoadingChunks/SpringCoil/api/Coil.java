package net.LoadingChunks.SpringCoil.api;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public interface Coil {
	public void askPlayerList(String server);

	public void askPlayerCount(String server);
	
	public void askServerList();

	public void sendToServer(String server, String channel, String command);

	public void sendToAllServers(String channel, String command);

	public void connectPlayerToServer(Player player, String server);
	
	public void sendRawData(String channel, String data);
	
	public void sendRawData(Player player, String channel, String data);
}
