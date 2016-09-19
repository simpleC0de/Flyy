package TP.TP;

import org.bukkit.plugin.java.JavaPlugin;

public class TP extends JavaPlugin{

	public void onEnable()
	{
		getCommand("fly").setExecutor(new TPCommand());
	}
}
