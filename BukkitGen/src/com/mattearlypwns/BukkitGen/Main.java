package com.mattearlypwns.BukkitGen;

import java.util.logging.Logger;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	private Logger log = Logger.getLogger("Minecraft");
	private PluginDescriptionFile desc;

	@Override
	public void onEnable() {
		desc = getDescription();
		log("Enabled!");

	}

	@Override
	public void onDisable() {
		log("Diabled!");
	}

	public void log(String message) {
		log.info("[" + desc.getName() + " " + desc.getVersion() + "] "
				+ message);
	}

	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {

		if (id.equalsIgnoreCase("flatlands")) {
			return new FlatLandsGenerator();

		} else if (id.equalsIgnoreCase("rollinghills")) {
			return null;
		} else
			return null;

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (cmd.getName().equalsIgnoreCase("gm")) {

			if (sender instanceof Player) {
				Player player = (Player) sender;
				player.setGameMode(GameMode.CREATIVE);
				return true;

			}

		}
		return false;

	}

}
