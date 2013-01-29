package net.LoadingChunks.SpringCoil.api;

import org.bukkit.entity.Player;

public interface Coil {
	public void askPlayerList(String server);

	public void askPlayerCount(String server);
	
	public void askServerList();

	public void sendToServer(String server, String channel, String command);
	public void sendToAllServers(String channel, String command);
	
	public void sendToServerAsPlayer(Player p, String server, String channel, String command);
	public void sendToAllServersAsPlayer(Player p, String server, String channel, String command);

	public void connectPlayerToServer(Player player, String server);
	
	public void sendRawData(String channel, String data);
	
	public void sendRawData(Player player, String channel, String data);
	
	public void registerListener(CoilListener listener);
}
