package mobs;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Mobs  extends JavaPlugin{

	public SpawnListener listener;
	
	@Override
	public void onEnable(){
		Logger log = this.getLogger();
		PluginManager pm = this.getServer().getPluginManager();
		SpawnListener listener = new SpawnListener(this);
		pm.registerEvents(listener,this);
		log.info("Sistema de mobs activado");
	}

	@Override
	public void onDisable(){
		Logger log = this.getLogger();
		log.info("Sistema de mobs desactivado");
	}




}
