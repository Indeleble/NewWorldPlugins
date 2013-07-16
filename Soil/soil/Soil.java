package soil;


import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import soil.listeners.SoilListener;

public class Soil extends JavaPlugin{
	
	@Override
	public void onEnable() {
		Logger log = this.getLogger();
		PluginManager pm = this.getServer().getPluginManager();
		SoilListener listener = new SoilListener(this);
		pm.registerEvents(listener,this);
		log.info("Soil working. No soil to dirt will happens!");
	}

	@Override
	public void onDisable() {
		// TODO Insert logic to be performed when the plugin is disabled
	}
	
}
