package nowater;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Hat implements Listener{
	   
	 
    @EventHandler (priority = EventPriority.HIGH)
    public void onPlayerInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        Action action = event.getAction();
        if(action == Action.LEFT_CLICK_AIR){
           
                player.getInventory().setHelmet(new ItemStack(318,1, (short) 1135));
            
           
        }
    }
}
 