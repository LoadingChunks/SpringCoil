package net.LoadingChunks.SpringCoil.api;

import net.LoadingChunks.SpringCoil.SpringCoil;

import org.bukkit.entity.Player;

public class SpringCoilAPI implements Coil {
	
	SpringCoil plugin;
	
	public SpringCoilAPI(SpringCoil plugin)
	{
		this.plugin = plugin;
	}

	@Override
	public void askPlayerList(String server) {
		this.plugin.getMessenger().sendPluginMessage("PlayerList");
	}

	@Override
	public void askPlayerCount(String server) {
		this.plugin.getMessenger().sendPluginMessage("PlayerCount");
	}

	@Override
	public void askServerList() {
		this.plugin.getMessenger().sendPluginMessage("GetServers");
	}

	@Override
	public void sendToServer(String server, String channel, String command) {
		this.plugin.getMessenger().sendPluginMessage("Forward", new String[]{channel,server,command});
	}

	@Override
	public void sendToAllServers(String channel, String command) {
		this.plugin.getMessenger().sendPluginMessage("Forward", new String[]{channel,"ALL",command});
	}

	@Override
	public void connectPlayerToServer(Player player, String server) {
		this.plugin.getMessenger().sendPluginMessage(player, "Connect", server);
	}

	@Override
	public void sendRawData(String channel, String data) {
		this.plugin.getMessenger().sendPluginMessage(channel, data);
	}

	@Override
	public void sendRawData(Player player, String channel, String data) {
		this.plugin.getMessenger().sendPluginMessage(player, channel, data);
	}
	
	@Override
	public void registerListener(CoilListener listener) {
		this.plugin.addListener(listener);
	}
}
