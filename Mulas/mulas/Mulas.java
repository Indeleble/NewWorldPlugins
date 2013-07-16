package mulas;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Mulas extends JavaPlugin implements CommandExecutor {

	@Override
	public void onEnable() {
		
		PluginManager pm = this.getServer().getPluginManager();
        //pm.registerEvents(new MulasListener(), this);

	}

	@Override
	public void onDisable() {
		// TODO Insert logic to be performed when the plugin is disabled
		//Prueba de cambios
	}

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("basic")){ // If the player typed /basic then do the following...
			Inventory inv = Bukkit.getServer().createInventory(null, InventoryType.PLAYER);
			Player p = (Player) sender;
		    p.openInventory(inv);
			return true;
		} 
		return false; 
	}
}
