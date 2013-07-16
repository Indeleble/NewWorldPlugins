package mulas;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.Plugin;

public class MulasListener implements Listener {

	Plugin pl;

	public MulasListener(Plugin pl) {

		this.pl = pl;
	}

	@EventHandler
	public void PlayerInteractEventa(PlayerInteractEntityEvent ev) {

		Entity e = ev.getRightClicked();

		if (e.getType() == EntityType.COW) {
			// MulaAdmin ma = new MulaAdmin();
			// ma.newMula("Vaca de prueba");
			ev.getPlayer().sendMessage("Mula creada" + e.getEntityId());
		}

		// Inventory inv = Bukkit.getServer().createInventory(ev.getPlayer(),
		// InventoryType.CHEST);

		// ev.getPlayer().openInventory(inv);

	}

	@EventHandler
	public void inv(InventoryClickEvent ev) {
		Player p = (Player) ev.getWhoClicked();
		p.sendMessage(String.valueOf(ev.getRawSlot()));
	}
}