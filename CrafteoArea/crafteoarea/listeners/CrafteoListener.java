package crafteoarea.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import core.skills.SkillPlayer;

import crafteoarea.CrafteoArea;


public class CrafteoListener implements Listener{
	
	CrafteoArea plugin;

	public CrafteoListener(CrafteoArea listener) {
		this.plugin = listener;
	}

	public void OnPlayerClick(PlayerInteractEvent event){
		if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            Block block = event.getClickedBlock();
            Player player = event.getPlayer();
            if (block.getType().equals(Material.WORKBENCH)) { // cuando el jugador clickea una workbench
            	//añadir a una variable que sea el jugador que craftea y la localizacion del bloque (el workbench)
            }
		}
	}
	
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void PlayerCraftEvent(CraftItemEvent event){
		
		HumanEntity entity = event.getViewers().get(0);
		Player player = (Player) entity;
		SkillPlayer sp;

		PermissionUser user = PermissionsEx.getUser(player);
		ItemStack res = event.getInventory().getResult();
		int resultado = res.getTypeId();

		// checkear el player si tiene los permisos para craftear el item y checkear tambien si el
		// bloque de alrededor del workbench es tal, y si no lo es y lo necesita para crafteos, cancela el evento.
		
		
		
	}




}
