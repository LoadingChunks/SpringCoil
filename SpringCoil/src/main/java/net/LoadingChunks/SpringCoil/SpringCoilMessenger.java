package net.LoadingChunks.SpringCoil;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SpringCoilMessenger {
	private SpringCoil plugin;
	
	public SpringCoilMessenger(SpringCoil plugin)
	{
		this.plugin = plugin;
	}
	
	private ByteArrayOutputStream prepareMessage(String channel, String message) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		
		try {
			out.writeUTF(WordUtils.capitalize(channel));
			if(message != null)
				out.writeUTF(message);
		} catch (IOException ex) {
			Bukkit.getLogger().severe("SpringCoil: Error writing plugin message stream! THIS SHOULD NOT HAPPEN! - Please contact developer ben@loadingchunks.net.");
			ex.printStackTrace();
		}

		return b;
	}
	
	public void sendPluginMessage(String channel) {
		ByteArrayOutputStream b = prepareMessage(channel, null);
		Bukkit.getServer().sendPluginMessage(this.plugin, "BungeeCord", b.toByteArray());
	}

	public void sendPluginMessage(String channel, String message) {
		ByteArrayOutputStream b = prepareMessage(channel, message);
		Bukkit.getServer().sendPluginMessage(this.plugin, "BungeeCord", b.toByteArray());
	}
	
	public void sendPluginMessage(Player p, String channel, String message) {
		ByteArrayOutputStream b = prepareMessage(channel, message);
		p.sendPluginMessage(this.plugin, "BungeeCord", b.toByteArray());
	}
}
