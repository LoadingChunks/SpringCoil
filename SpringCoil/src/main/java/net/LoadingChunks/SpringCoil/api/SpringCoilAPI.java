package net.LoadingChunks.SpringCoil.api;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class SpringCoilAPI implements CoilInterface {

	@Override
	public ArrayList<String> getPlayerList(String server) {
		return null;
	}

	@Override
	public int getPlayerCount(String server) {
		return 0;
	}

	@Override
	public ArrayList<String> getServerList() {
		return null;
	}

	@Override
	public void sendToServer(String server, String command) {

	}

	@Override
	public void sendToAllServers(String command) {

	}

	@Override
	public void connectPlayerToServer(Player player, String server) {

	}

}
