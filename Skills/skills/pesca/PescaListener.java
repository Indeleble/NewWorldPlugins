package skills.pesca;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.block.Biome;
import org.bukkit.entity.Fish;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerFishEvent.State;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import core.skills.SkillPlayer;
import core.skills.SkillPlayerManager;
import core.skills.SkillType;

public class PescaListener implements Listener {

	SkillPlayerManager	spm;
	Logger				log;
	Plugin				pl;

	public PescaListener(SkillPlayerManager spm, Logger log, Plugin pl) {

		this.spm = spm;
		this.log = log;
		this.pl = pl;

	}

	@EventHandler(priority = EventPriority.HIGH)
	public void fishEvent(PlayerFishEvent event) {

		Player player = event.getPlayer();
		SkillPlayer sp;
		PermissionUser user = PermissionsEx.getUser(player);
		Biome biome = player.getLocation().getBlock().getBiome();
		if (user.inGroup("pesca")) {

			if (event.getState() == State.IN_GROUND) {
				sp = spm.getSkillPlayer(player.getName());
				ItemStack is = getFish(sp.getLevel(SkillType.Pesca), biome);
				pl.getServer().getWorld("world").dropItem(player.getLocation(), is);
				sp.addExperience(SkillType.Tala, 500);
				player.sendMessage("Pesca subio 500 puntos. Total: "+ sp.getExperience(SkillType.Pesca) + " Level: " + sp.getLevel(SkillType.Pesca));
			}

		} else
			event.setCancelled(true);
	}

	private ItemStack getFish(int lvl, Biome biome) {

		int maxPurity = lvl * 3 + 10;
		Random r = new Random();
		r.setSeed(r.nextLong());

		int purity = r.nextInt(maxPurity) + 1;

		ItemStack fish = new ItemStack(349);

		ItemMeta im = fish.getItemMeta();
		im.setDisplayName(getFishName(purity, biome));
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Calidad: " + purity);
		im.setLore(lore);
		fish.setItemMeta(im);

		return fish;

	}

	private String getFishName(int p, Biome biome) {
		String name = null;

		if (biome == Biome.OCEAN) {
			if (p < 10) {
				name = "Boqueron";
			} else if (p < 25) {
				name = "Salmonete";
			} else if (p < 50) {
				name = "Lenguado";
			} else if (p < 75) {
				name = "Pescadilla";
			} else {
				name = "Dorada";
			}
		} else if (biome == Biome.RIVER) {

			if (p < 50) {
				name = "Trucha";
			} else {
				name = "Salmon";
			}

		} else {
			name = "Desconocido";
		}

		return name;
	}
}
