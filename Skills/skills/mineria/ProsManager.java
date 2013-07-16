package skills.mineria;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.protection.flags.Flag;
import com.sk89q.worldguard.protection.managers.RegionManager;

import core.skills.SkillPlayer;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ProsManager implements Listener {

	ArrayList<String>	Prospectors;

	public ProsManager() {

		this.Prospectors = new ArrayList<String>();
		
	}

	@EventHandler
	public void PlayerInteractEvent(PlayerInteractEvent event) {

		Player player;
		Action action;
		String name;
		int inHand;
		PermissionUser user = PermissionsEx.getUser(event.getPlayer());

		if (user.inGroup("mineria")) {

			action = event.getAction();

			if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {

				player = event.getPlayer();
				inHand = player.getItemInHand().getTypeId();
				name = player.getName();

				if ((inHand == 257) || (inHand == 274) || (inHand == 278) || (inHand == 285)) {

					if (isProspecting(name)) {
						removeProspecter(name);
						player.sendMessage("Dejas de prospectar");
					} else {
						addProspecter(name);
						player.sendMessage("Decides prospectar");

					}
				}
			}
		}
	}

	public boolean isProspecting(String name) {

		for (String n : Prospectors) {

			if (n.equalsIgnoreCase(name))
				return true;
		}

		return false;

	}

	public void removeProspecter(String name) {

		for (int i = 0; i < Prospectors.size(); i++) {

			if (Prospectors.get(i).equalsIgnoreCase(name)) {
				Prospectors.remove(i);
				break;
			}
		}
	}

	public void addProspecter(String name) {

		if (!isProspecting(name)) {

			Prospectors.add(name);
		}
	}

	/*
	 * @Override public boolean onCommand(CommandSender sender, Command cmd,
	 * String label, String[] args) {
	 * 
	 * if (cmd.getName().equalsIgnoreCase("prospectar")) {
	 * 
	 * String name = sender.getName(); PermissionUser user =
	 * PermissionsEx.getUser(name); if (user.inGroup("mineria")) { if
	 * (isProspecting(name)) { removeProspecter(name);
	 * sender.sendMessage("Dejas de prospectar"); } else{ addProspecter(name);
	 * sender.sendMessage("Decides prospectar");
	 * 
	 * }return true;
	 * 
	 * } else { sender.sendMessage("No eres minero");
	 * 
	 * } } return false; }
	 */
}
