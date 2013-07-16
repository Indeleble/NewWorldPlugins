package armasfuego;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import armasfuego.cannon.CannonEventHandler;
import armasfuego.rifle.RifleEventHandler;

public class ArmasFuego extends JavaPlugin{
	
	public CannonEventHandler ejecutor;
	public RifleEventHandler listener;
	
	@Override
	public void onEnable(){
		Logger log = this.getLogger();
		PluginManager pm = this.getServer().getPluginManager();
		RifleEventHandler pl = new RifleEventHandler(this);
		pm.registerEvents(pl,this);
		ejecutor = new CannonEventHandler(this);
		log.info("Armas de fuego activado");
	}

	@Override
	public void onDisable(){
		Logger log = this.getLogger();
		log.info("Armas de fuego desactivado");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		return ejecutor.onCommand(sender, cmd, commandLabel, args);
	}
}
