package skills.construccion;

import java.util.logging.Logger;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import core.skills.SkillPlayer;
import core.skills.SkillPlayerManager;
import core.skills.SkillType;

public class QuarzPaintListener implements Listener {

	SkillPlayerManager	spm;
	Logger				log;
	Plugin				pl;

	public QuarzPaintListener(SkillPlayerManager spm, Logger log, Plugin pl) {

		this.spm = spm;
		this.log = log;
		this.pl = pl;
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void ConstruccionBlockPlaceEvent(BlockPlaceEvent event) {

		Block b = event.getBlock();
		Player player = event.getPlayer();
		PermissionUser user = PermissionsEx.getUser(player);
		SkillPlayer sp;
		ItemStack mat = player.getItemInHand();

		
		

		player.sendMessage(b.getMetadata("prueba").get(0).toString());
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void ConstruccionBreakPlaceEvent(BlockBreakEvent event) {

		Block b = event.getBlock();
		Player player = event.getPlayer();
		PermissionUser user = PermissionsEx.getUser(player);
		SkillPlayer sp;
		ItemStack mat = player.getItemInHand();

		player.sendMessage(b.getMetadata("prueba").get(0).toString());
	}

}
