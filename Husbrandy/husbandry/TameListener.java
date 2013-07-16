package husbandry;

import org.bukkit.Material;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.Plugin;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import core.husbrandy.AnimalDb;
import core.husbrandy.HusAnimalManager;
import de.ntcomputer.minecraft.controllablemobs.api.ControllableMob;
import de.ntcomputer.minecraft.controllablemobs.api.ControllableMobs;
import de.ntcomputer.minecraft.controllablemobs.api.actions.ActionType;
import de.ntcomputer.minecraft.controllablemobs.api.ai.behaviors.AIBehavior;

public class TameListener implements Listener {

	Plugin				pl;
	HusAnimalManager	ham;

	public TameListener(Plugin pl, HusAnimalManager ham) {

		this.pl = pl;
		this.ham = ham;
	}

	@EventHandler
	public void PlayerInteractEvent(PlayerInteractEntityEvent ev) {

		Player p = ev.getPlayer();
		LivingEntity e = (LivingEntity) ev.getRightClicked();
		ControllableMob<LivingEntity> conEn;
		PermissionUser user = PermissionsEx.getUser(ev.getPlayer());

		if (user.inGroup("ganaderia")) {

			if (p.getItemInHand().getType() == Material.BONE && (e.getType() == EntityType.SHEEP || e.getType() == EntityType.COW || e.getType() == EntityType.WOLF)) {

				// Si tiene dueño

				if (ham.animalHasOwner(e.getUniqueId()) != null) {

					// Si el que le llama es el dueño
					if (ham.animalHasOwner(e.getUniqueId()).equalsIgnoreCase(p.getName())) {

						// Si tiene dueño y no es el que activa el evento
					} else {
						p.sendMessage("Ese animal tiene dueño");
					}

				} else {

					AnimalDb animal = new AnimalDb();
					animal.setAge(e.getTicksLived() / 20);
					animal.setOwner(p.getName());
					animal.setUuid(e.getUniqueId());
					animal.setType(e.getType().getTypeId());
					animal.setQuality(10);

					ham.addNewAnimalToDb(p.getName(), animal);
					
					if (e.getType() == EntityType.WOLF){
						Wolf wolf = (Wolf) e;
						wolf.setOwner(p);
					}

				}

			}

		}
	}

}
