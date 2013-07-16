package agui;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class AGUI extends JavaPlugin implements CommandExecutor {

	Logger	log;

	@Override
	public void onEnable() {

		log = this.getLogger();

		this.getServer().getPluginManager().registerEvents(new GuiHandler(this), this);

	}

	@Override
	public void onDisable() {
		// TODO Insert logic to be performed when the plugin is disabled
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("walk")) {

			if (!(sender instanceof Player)) {
				sender.sendMessage("This command can only be run by a player.");
				return true;
			} else {
				Player player = (Player) sender;
				player.setWalkSpeed(0.1f);

				return true;
			}
		}

		if (cmd.getName().equalsIgnoreCase("run")) {

			if (!(sender instanceof Player)) {
				sender.sendMessage("This command can only be run by a player.");
				return true;
			} else {
				Player player = (Player) sender;
				player.setWalkSpeed(0.2f);
				return true;
			}

		}
		return false;
	}
}
