package skills.agricultura;

import java.util.logging.Logger;

import org.bukkit.CropState;
import org.bukkit.block.Block;
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

public class AgriculturaListener implements Listener {

	SkillPlayerManager	spm;
	Logger				log;
	Plugin				pl;

	public AgriculturaListener(SkillPlayerManager spm, Logger log, Plugin pl) {

		this.spm = spm;
		this.log = log;
		this.pl = pl;
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void AgriculturaDamageEvent(BlockBreakEvent event) {

		Block block = event.getBlock();
		int bId = block.getTypeId();
		Player player = event.getPlayer();
		SkillPlayer sp;
		PermissionUser user;
		ItemPurityBuilder ipb;

		user = PermissionsEx.getUser(player);

		if (user.inGroup("agricultura")) {
			log.info("Detecta grupo agricultura");

			sp = spm.getSkillPlayer(player.getName());
			ipb = new ItemPurityBuilder();
			int level = sp.getLevel(SkillType.Agricultura);
			int dropLevel = Double.valueOf(level / 2).intValue();

			boolean canFarm = false;
			int drop = 0;
			int seed = 0;

			for (AgBlocks agb : AgBlocks.values()) {

				if (bId == agb.getId()) {
					canFarm = true;
					drop = agb.getDropId();
					seed = agb.getSeedId();
					event.setCancelled(false);
					break;
				}
				event.setCancelled(true);
			}

			if (canFarm && player.getItemInHand().getTypeId() == 292) {

				/* Bloques de crecimiento Trigo, patata, zanahoria */
				if (bId == 59 || bId == 142 || bId == 141) {

					// Si el bloque esta 100% crecido
					if (block.getData() == CropState.RIPE.getData()) {

						// 2 de drop
						ipb.addDrop(new CustomDrop(new ItemStack(drop), level, 2, dropLevel));
						// Semilla
						ipb.addDrop(new CustomDrop(new ItemStack(seed), level, 1, 2000 / level));

						event.setCancelled(true);
						block.setTypeId(0);

						sp.addExperience(SkillType.Agricultura, 500);
						player.sendMessage("Exp. agricultura subio 500 puntos. Total: " + sp.getExperience(SkillType.Agricultura) + "Level: " + sp.getLevel(SkillType.Agricultura));
					}

					else {
						ipb.addDrop(new CustomDrop(new ItemStack(seed), level, 1, 100));

						event.setCancelled(true);
						block.setTypeId(0);

						sp.addExperience(SkillType.Agricultura, 250);
						player.sendMessage("Exp. agricultura subio 250 puntos. Total: " + sp.getExperience(SkillType.Agricultura) + "Level: " + sp.getLevel(SkillType.Agricultura));
					}
				} else if (bId == 103 || bId == 86) {

					// 1 de drop ya que siempre estará plantado
					ipb.addDrop(new CustomDrop(new ItemStack(drop), level, 1, dropLevel));

					event.setCancelled(true);
					block.setTypeId(0);

					sp.addExperience(SkillType.Agricultura, 500);
					player.sendMessage("Exp. agricultura subio 500 puntos. Total: " + sp.getExperience(SkillType.Agricultura) + "Level: " + sp.getLevel(SkillType.Agricultura));
				}
			} else if(bId == 104 && player.getItemInHand().getTypeId() == 292){
				
				ipb.addDrop(new CustomDrop(new ItemStack(AgBlocks.Calabaza.getSeedId()), level, 1, 90));

				event.setCancelled(true);
				block.setTypeId(0);

				sp.addExperience(SkillType.Agricultura, 500);
				player.sendMessage("Exp. agricultura subio 500 puntos. Total: " + sp.getExperience(SkillType.Agricultura) + "Level: " + sp.getLevel(SkillType.Agricultura));
				
			} else if(bId == 105 && player.getItemInHand().getTypeId() == 292){
				
				ipb.addDrop(new CustomDrop(new ItemStack(AgBlocks.Melon.getSeedId()), level, 1, 90));

				event.setCancelled(true);
				block.setTypeId(0);

				sp.addExperience(SkillType.Agricultura, 500);
				player.sendMessage("Exp. agricultura subio 500 puntos. Total: " + sp.getExperience(SkillType.Agricultura) + "Level: " + sp.getLevel(SkillType.Agricultura));
				
			}

			if (ipb.getDrops().size() > 0) {
				for (ItemStack is : ipb.getDrops()) {
					if (is.getTypeId() != 0)
						pl.getServer().getWorld("world").dropItem(block.getLocation(), is);
				}
			}
		}
	}
}
