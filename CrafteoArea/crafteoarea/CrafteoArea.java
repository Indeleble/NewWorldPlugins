package crafteoarea;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import crafteoarea.listeners.CrafteoListener;

public class CrafteoArea extends JavaPlugin{

	public CrafteoListener listener;
	
	@Override
	public void onEnable(){
		Logger log = this.getLogger();
		PluginManager pm = this.getServer().getPluginManager();
		CrafteoListener listener = new CrafteoListener(this);
		pm.registerEvents(listener,this);
		log.info("Crafteo en area activado");
	}

	@Override
	public void onDisable(){
		Logger log = this.getLogger();
		log.info("Crafteo en area desactivado");
	}





}