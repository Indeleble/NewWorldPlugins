package skills.carpinteria;

import java.util.logging.Logger;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import core.skills.SkillPlayer;
import core.skills.SkillPlayerManager;
import core.skills.SkillType;

public class CarpinteriaListener implements Listener {

	SkillPlayerManager spm;
	Logger log;

	public CarpinteriaListener(SkillPlayerManager spm, Logger log) {

		this.spm = spm;
		this.log = log;
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void CarpinteriaCraftEvent(CraftItemEvent event){
		
		
		HumanEntity entity = event.getViewers().get(0);
		Player player = (Player) entity;
		SkillPlayer sp;

		PermissionUser user = PermissionsEx.getUser(player);
		ItemStack res = event.getInventory().getResult();
		int resultado = res.getTypeId();
		
		if (user.inGroup("carpinteria")) {
			sp = spm.getSkillPlayer(player.getName());
			if (resultado==5){
				sp.addExperience(SkillType.Carpinteria, 200);
				player.sendMessage("Experiencia en carpinteria subio en 200 puntos");
				player.sendMessage("Experiencia en carpinteria: " + sp.getLevel(SkillType.Carpinteria));
				player.sendMessage("Nivel de carpinteria: " + sp.getLevel(SkillType.Carpinteria));
				player.sendMessage("Nivel total: " + sp.getTotalLevel());
				
			} 
		}
	}
}
