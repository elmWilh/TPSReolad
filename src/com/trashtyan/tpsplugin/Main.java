package com.trashtyan.tpsplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
private int tps = 0;
 
@Override
public void onDisable(){
	Bukkit.getLogger().info("["+ChatColor.DARK_PURPLE+"Trash"+ChatColor.DARK_GREEN+"Tyan"+ChatColor.DARK_AQUA+"TPS"+ChatColor.WHITE+" - on Disable");
	getServer().getScheduler().cancelTasks(this);
}
 
@Override
public void onEnable(){
	Bukkit.getLogger().info("["+ChatColor.DARK_PURPLE+"Trash"+ChatColor.DARK_GREEN+"Tyan"+ChatColor.DARK_AQUA+"TPS"+ChatColor.WHITE+" - on Enable");
	getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable()
	{
	long sec;
	long currentSec;
	int ticks;
	int delay;
 
public boolean checkSender (CommandSender sender){
	if (sender instanceof Player) {
		return false;
	}
	return true;
}

@SuppressWarnings("unused")
public boolean ocCommand(CommandSender sender, Command cmd, String label, String[] args) {
	if (cmd.getName().equalsIgnoreCase("testdev")) {
		if (checkSender(sender)) {
			sender.sendMessage(ChatColor.GREEN+"Only players can use this command");
		}
	
		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "/title @a times 40 100 40");
		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "/title @a subtitle {\"text\":\"\\u041f\\u0440\\u0438\\u0447\\u0438\\u043d\\u0430: \\u0441\\u0438\\u043b\\u044c\\u043d\\u0430\\u044f \\u043d\\u0430\\u0433\\u0440\\u0443\\u0437\\u043a\\u0430 \\u043d\\u0430 \\u0441\\u0435\\u0440\\u0432\\u0435\\u0440\",\"color\":\"gold\"}");
		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "/title @a title [\"\",{\"text\":\"Trash\",\"bold\":true,\"color\":\"dark_purple\"},{\"text\":\"Tyan -\",\"bold\":true},{\"text\":\" \\u041f\\u0435\\u0440\\u0435\\u0437\\u0430\\u0433\\u0440\\u0443\\u0437\\u043a\\u0430 \\u0441\\u0435\\u0440\\u0432\\u0435\\u0440\\u0430\",\"color\":\"gold\"}]");
	}
	return false;
}

@Override
public void run()
{
sec = (System.currentTimeMillis() / 1000);
 
if(currentSec == sec)
{

	
ticks++;
}
else {
	currentSec = sec;
	tps = (tps == 0 ? ticks : ((tps + ticks) / 2));
	ticks = 0;
	 
	if((++delay % 300) == 0) {
	
	 
	delay = 0;
	}
}
}
}, 0, 1); 
 
 
if (tps <= 15){
	Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "/title @a times 40 100 40");
	Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "/title @a subtitle {\"text\":\"\\u041f\\u0440\\u0438\\u0447\\u0438\\u043d\\u0430: \\u0441\\u0438\\u043b\\u044c\\u043d\\u0430\\u044f \\u043d\\u0430\\u0433\\u0440\\u0443\\u0437\\u043a\\u0430 \\u043d\\u0430 \\u0441\\u0435\\u0440\\u0432\\u0435\\u0440\",\"color\":\"gold\"}");
	Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "/title @a title [\"\",{\"text\":\"Trash\",\"bold\":true,\"color\":\"dark_purple\"},{\"text\":\"Tyan -\",\"bold\":true},{\"text\":\" \\u041f\\u0435\\u0440\\u0435\\u0437\\u0430\\u0433\\u0440\\u0443\\u0437\\u043a\\u0430 \\u0441\\u0435\\u0440\\u0432\\u0435\\u0440\\u0430\",\"color\":\"gold\"}]");
	Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "/restart");
}  
}
}
 
 