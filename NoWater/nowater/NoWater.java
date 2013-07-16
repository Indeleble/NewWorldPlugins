package nowater;

import java.util.logging.Logger;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class NoWater extends JavaPlugin implements Listener {

	Logger	log;

	@Override
	public void onEnable() {

		log = this.getLogger();
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new Hat(), this);

	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void WaterEvent(PlayerBucketEmptyEvent event) {

		Player player = event.getPlayer();
		final Block block = event.getBlockClicked().getRelative(event.getBlockFace());

		if (player.getGameMode() == GameMode.SURVIVAL) {

			getServer().getScheduler().runTaskLater(this, new Runnable() {
				public void run() {

					if (block.getType() == Material.STATIONARY_WATER || block.getType() == Material.WATER) {
						
						block.setType(Material.AIR);
					}
				}
			}, 15);
		}
	}
}
