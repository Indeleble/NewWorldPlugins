package armasfuego.rifle;


import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import armasfuego.ArmasFuego;

public class RifleEventHandler implements Listener{


	ArmasFuego plugin;
	
	public RifleEventHandler(ArmasFuego armasfuego) {
		this.plugin = armasfuego;
	}
	
	@EventHandler (priority = EventPriority.HIGH)
    public static void PlayerInteractEvent(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        Action action = event.getAction();
        Location target = player.getEyeLocation();
        Block block = event.getClickedBlock();
        Block blocklook = player.getEyeLocation().getBlock();
		Material material;   

        boolean hasRifle = player.getItemInHand().getTypeId()==369; // Blaze Rod
        boolean hasPolvora = player.getInventory().contains(289); // Gunpowder
        boolean hasMunicion = player.getInventory().contains(402); // Firework Star
		boolean bcristal = blocklook.getTypeId()==20 || blocklook.getTypeId()==102;
        boolean enRango=false;

        int locX = event.getPlayer().getLocation().getBlockX(); // +
        int locY = event.getPlayer().getLocation().getBlockY(); // +
        int locZ = event.getPlayer().getLocation().getBlockZ(); // +

        int locx = event.getPlayer().getLocation().getBlockX(); // -
        int locy = event.getPlayer().getLocation().getBlockY(); // -
        int locz = event.getPlayer().getLocation().getBlockZ(); // -

        if (block == null) {
            material = Material.AIR;
        }

        else {
            material = block.getType();
        }

        switch (action) {
        case RIGHT_CLICK_BLOCK:

        	player.sendMessage("test block");

        	break;
        case RIGHT_CLICK_AIR:

        	player.sendMessage("test air");

        	if(hasRifle==true){  
        		if ((hasPolvora == true) && (hasMunicion==true)){
/*			        for(locX = 0;locX>30;locX++){ // checkear radio, y reproducir el sonido de disparo en todas las entidades de al lado, si la entidad esta siendo vista, quitarle vida. Si es cristal romperlo
                    	for(locY = 0;locY>30;locY++){
                        	for(locZ = 0;locZ>30;locZ++){
                        		if(target==player){
                        		
                        		}
                        	}
                    	}
                	}*/
//        			player.sendMessage("el jugador esta mirando al bloque "+blocklook+", y a la entidad "+target);
        			
        			player.getWorld().playSound(player.getLocation(), Sound.EXPLODE, 2, 2);
        			
        			if(bcristal==true){
        				blocklook.setTypeId(0);
        				player.getWorld().playSound(blocklook.getLocation(), Sound.GLASS, 1, 1);
        			}
        			
        			player.sendMessage(ChatColor.GREEN+"Te preparas para disparar el rifle");
        			
        			
        		}else if ((hasPolvora==true)&&(hasMunicion==false)){
        			player.sendMessage(ChatColor.RED+"No tienes municion para disparar el rifle");
        		}else if ((hasPolvora==false)&&(hasMunicion==true)){
        			player.sendMessage(ChatColor.RED+"No tienes polvora para disparar el rifle");
        		}else if((hasPolvora==false)&&(hasMunicion==false)){
        			player.sendMessage(ChatColor.RED+"No tienes municion ni polvora para disparar el rifle");
        		}
        	}
        	break;
        
        default:
		
        	break;
        }
    }
}
