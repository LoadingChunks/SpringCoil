package net.LoadingChunks.SpringCoil;

import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class SpringCoilMessageListener implements PluginMessageListener {

	private SpringCoil plugin;

	public SpringCoilMessageListener(SpringCoil plugin)
	{
		this.plugin = plugin;
	}

	@Override
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
		
	}
}
