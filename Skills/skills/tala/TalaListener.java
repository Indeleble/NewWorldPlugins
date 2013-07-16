package skills.tala;

import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import skills.drops.CustomDrop;
import skills.drops.ItemPurityBuilder;
import core.skills.SkillPlayer;
import core.skills.SkillPlayerManager;
import core.skills.SkillType;

public class TalaListener implements Listener {

	SkillPlayerManager	spm;
	Logger				log;
	Plugin				pl;

	public TalaListener(SkillPlayerManager spm, Logger log, Plugin pl) {

		this.spm = spm;
		this.log = log;
		this.pl = pl;

	}

	@EventHandler(priority = EventPriority.HIGH)
	public void TalaDamageEvent(BlockBreakEvent event) {
		
		Player player = event.getPlayer();
		Location blockLocation = event.getBlock().getLocation();
		int itemId = player.getItemInHand().getTypeId();
		SkillPlayer sp;
		PermissionUser user = PermissionsEx.getUser(player);
		ItemPurityBuilder ipb;

		//log.info("Entra en el evento");
		
		if (event.getBlock().getTypeId() == 17 || event.getBlock().getTypeId() == 18) {

			if (user.inGroup("tala")) {

				if (itemId == 275 || itemId == 258 || itemId == 279) {

					sp = spm.getSkillPlayer(player.getName());
					ipb = new ItemPurityBuilder();

					if (event.getBlock().getTypeId() == 17) {

						ItemStack stick = new ItemStack(280);
						
						if (itemId == 275) {
							ipb.addDrop(new CustomDrop(event.getBlock().getState().getData().toItemStack(1), sp.getLevel(SkillType.Tala), 1, 40));
							ipb.addDrop(new CustomDrop(stick, sp.getLevel(SkillType.Tala), 2, 50));
						}
						if (itemId == 258) {
							ipb.addDrop(new CustomDrop(event.getBlock().getState().getData().toItemStack(1), sp.getLevel(SkillType.Tala), 1, 50));
							ipb.addDrop(new CustomDrop(stick, sp.getLevel(SkillType.Tala), 3, 50));
						}
						if (itemId == 279) {
							ipb.addDrop(new CustomDrop(event.getBlock().getState().getData().toItemStack(1), sp.getLevel(SkillType.Tala), 1, 60));
							ipb.addDrop(new CustomDrop(stick, sp.getLevel(SkillType.Tala), 4, 50));
						}

						if (ipb.getDrops().size() > 0) {

							for (ItemStack is : ipb.getDrops()) {
								pl.getServer().getWorld("world").dropItem(blockLocation, is);
							}
						}

						sp.addExperience(SkillType.Tala, 500);
						player.sendMessage("Exp. tala subio 500 puntos. Total: "+ sp.getExperience(SkillType.Tala) + "Level: " + sp.getLevel(SkillType.Tala));

						event.setCancelled(true);
						event.getBlock().setTypeId(0);

					} else if (event.getBlock().getTypeId() == 18) {

						ItemStack stick = new ItemStack(280);
						ItemStack leave = event.getBlock().getState().getData().toItemStack(1);
						ItemStack sapling = new ItemStack(6, 1, (short) event.getBlock().getData());

						if (itemId == 275) {
							ipb.addDrop(new CustomDrop(sapling, sp.getLevel(SkillType.Tala), 1, 5));
							ipb.addDrop(new CustomDrop(leave, sp.getLevel(SkillType.Tala), 1, 5));
							ipb.addDrop(new CustomDrop(stick, sp.getLevel(SkillType.Tala), 1, 15));
						}
						if (itemId == 258) {
							ipb.addDrop(new CustomDrop(sapling, sp.getLevel(SkillType.Tala), 1, 10));
							ipb.addDrop(new CustomDrop(leave, sp.getLevel(SkillType.Tala), 2, 10));
							ipb.addDrop(new CustomDrop(stick, sp.getLevel(SkillType.Tala), 2, 20));
						}
						if (itemId == 279) {
							ipb.addDrop(new CustomDrop(sapling, sp.getLevel(SkillType.Tala), 1, 15));
							ipb.addDrop(new CustomDrop(leave, sp.getLevel(SkillType.Tala), 1, 15));
							ipb.addDrop(new CustomDrop(stick, sp.getLevel(SkillType.Tala), 3, 25));
						}

						if (ipb.getDrops().size() > 0) {

							for (ItemStack is : ipb.getDrops()) {
								pl.getServer().getWorld("world").dropItem(blockLocation, is);
							}
						}

						sp.addExperience(SkillType.Tala, 200);
						player.sendMessage("Exp. tala subio 500 puntos. Total: "+ sp.getExperience(SkillType.Tala) + " Level: " + sp.getLevel(SkillType.Tala));

						event.setCancelled(true);
						event.getBlock().setTypeId(0);

					}
				}
			}
		}
	}
}
