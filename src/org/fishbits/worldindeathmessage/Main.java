package org.fishbits.worldindeathmessage;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		
		getServer().getPluginManager().registerEvents(this, this);
		saveDefaultConfig();
		
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		
		String deathMessage = e.getDeathMessage();
		String configMessage = this.getConfig().getString("message");
		String finalMessage = configMessage.replaceAll("%deathmessage%", deathMessage).replaceAll("%world%", e.getEntity().getWorld().getName());
		
		e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', finalMessage));
		
	}
	
}
