package keys;


import java.util.logging.Logger;

import keys.listeners.KeysListener;


import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import soil.listeners.SoilListener;

public class Keys extends JavaPlugin{
	
	@Override
	public void onEnable() {
		Logger log = this.getLogger();
		PluginManager pm = this.getServer().getPluginManager();
		KeysListener listener = new KeysListener(this);
		pm.registerEvents(listener,this);
		log.info("Miscelaneo activado");
	}

	@Override
	public void onDisable() {
		// TODO Insert logic to be performed when the plugin is disabled
	}
	
}
