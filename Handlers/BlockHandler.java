import java.util.Map;
import java.util.Random;

import net.morematerials.MoreMaterials;
import net.morematerials.handlers.GenericHandler;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockPlaceEvent;

/* ConsumeFoodHandler
 * Author: Dockter, AlmuraDev ? 2013
 * Version: 1.4
 * Updated: 4/17/2013
 */

public class BlockHandler extends GenericHandler {

	private MoreMaterials plugin;

	@Override
	public void init(MoreMaterials plugin) {
		this.plugin = plugin;
	}

	@Override
	public void onActivation(Event event, Map<String, Object> config) {
		plugin.getLogger().info("Salta el handler");
		if (!(event instanceof BlockPlaceEvent)) { // Always do this.
			return;
		}

		// Setup Player Environment
		BlockPlaceEvent blockEvent = (BlockPlaceEvent) event;
		final Location location = blockEvent.getBlockPlaced().getLocation();
		Player player = blockEvent.getPlayer();

		player.sendMessage("Bien hecho " + player.getName() + " " + event.getEventName() + " en  " + location.toString());

		this.plugin.getServer().getScheduler().scheduleSyncRepeatingTask(this.plugin, new Runnable() {
			public void run() {
				
				Random r = new Random();
				int tipe = r.nextInt(10) + 12;
				plugin.getServer().getWorld("world").getBlockAt(location).setTypeId(tipe);

			}
		}, 200, 200);

	}

	@Override
	public void shutdown() {
		// Nothing to do here but required by handler.
	}
}