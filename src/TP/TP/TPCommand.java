package TP.TP;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class TPCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cs instanceof Player)
		{
			Player p = (Player)cs;
			if(cmd.getLabel().equalsIgnoreCase("fly"))
			{
				if(args.length == 0 || args.length == 1)
				{
					if(args.length == 0)
					{
						if(p.getGameMode() == GameMode.ADVENTURE)
						{
							if(p.getAllowFlight()){
								p.setFlying(false);
								p.setAllowFlight(false);
								return true;
							}
							else
							{
								p.setAllowFlight(true);
								p.setFlying(true);
								return true;
							}
						}
						else
						{
							p.setGameMode(GameMode.ADVENTURE);
							if(p.getAllowFlight()){
								p.setFlying(false);
								p.setAllowFlight(false);
								return true;
							}
							else
							{
								p.setAllowFlight(true);
								p.setFlying(true);
								return true;
							}
						}
					}
					else
					{
						try
						{
							Player sel = Bukkit.getPlayer(args[0]);
							if(sel.getGameMode() == GameMode.ADVENTURE)
							{
								if(sel.getAllowFlight()){
									sel.setFlying(false);
									sel.setAllowFlight(false);
									return true;
								}
								else
								{
									sel.setAllowFlight(true);
									sel.setFlying(true);
									return true;
								}
							}
							else
							{
								sel.setGameMode(GameMode.ADVENTURE);
								if(sel.getAllowFlight()){
									sel.setFlying(false);
									sel.setAllowFlight(false);
									return true;
								}
								else
								{
									sel.setAllowFlight(true);
									sel.setFlying(true);
									return true;
								}
							}
							
							}catch(Exception ex)
						{
							p.sendMessage(ChatColor.RED + "Der Spieler " + ChatColor.GRAY + args[0] + ChatColor.RED + " konnte nicht gefunden werden.");
							return true;
						}
					}
				}
				else
				{
					p.sendMessage(ChatColor.RED + "/fly <Player>");
				}
			}
		}
		return true;
	}

}
