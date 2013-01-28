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
	
	private ByteArrayOutputStream prepareMessage(String channel, String[] messages) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		
		try {
			out.writeUTF(WordUtils.capitalize(channel));
			if(channel.equalsIgnoreCase("Forward"))
			{
				out.writeUTF(messages[1]);
				out.writeUTF(messages[2]);
				out.writeShort(messages[2].getBytes().length);
				out.write(messages[2].getBytes());
			} else {
				out.writeUTF(messages[0]);
			}
		} catch (IOException ex) {
			Bukkit.getLogger().severe("SpringCoil: Error writing plugin message stream! THIS SHOULD NOT HAPPEN! - Please contact developer ben@loadingchunks.net.");
			ex.printStackTrace();
		}

		return b;
	}
	
	private ByteArrayOutputStream prepareMessage(String channel, String message) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		
		try {
			out.writeUTF(WordUtils.capitalize(channel));
			if(channel.equalsIgnoreCase("Forward"))
				out.writeShort(message.getBytes().length);
			if(message.length() > 0)
				out.write(message.getBytes());
		} catch (IOException ex) {
			Bukkit.getLogger().severe("SpringCoil: Error writing plugin message stream! THIS SHOULD NOT HAPPEN! - Please contact developer ben@loadingchunks.net.");
			ex.printStackTrace();
		}

		return b;
	}
	
	public void sendPluginMessage(String channel) {
		ByteArrayOutputStream b = prepareMessage(channel, "");
		this.plugin.getLogger().info("Preparing to send BungeeCord message with subchannel " + channel + " and no message.");
		this.plugin.getLogger().info("Byte Array is: " + b.toString());
		Bukkit.getServer().sendPluginMessage(this.plugin, "BungeeCord", b.toByteArray());
	}

	public void sendPluginMessage(String channel, String message) {
		ByteArrayOutputStream b = prepareMessage(channel, message);
		this.plugin.getLogger().info("Preparing to send BungeeCord message with subchannel " + channel + " and message \"" + message + "\"");
		this.plugin.getLogger().info("Byte Array is: " + b.toString());
		Bukkit.getServer().sendPluginMessage(this.plugin, "BungeeCord", b.toByteArray());
	}
	
	public void sendPluginMessage(String channel, String[] messages) {
		ByteArrayOutputStream b = prepareMessage(channel, messages);
		this.plugin.getLogger().info("Preparing to send BungeeCord message with subchannel " + channel + " and message \"" + messages[2] + "\"");
		this.plugin.getLogger().info("Byte Array is: " + b.toString());
		Bukkit.getServer().sendPluginMessage(this.plugin, "BungeeCord", b.toByteArray());
	}
	
	public void sendPluginMessage(Player p, String channel, String message) {
		ByteArrayOutputStream b = prepareMessage(channel, message);
		this.plugin.getLogger().info("Preparing to send BungeeCord message with subchannel " + channel + " from " + p.getName() + " with and message \"" + message + "\"");
		this.plugin.getLogger().info("Byte Array is: " + b.toString());
		p.sendPluginMessage(this.plugin, "BungeeCord", b.toByteArray());
	}
}
