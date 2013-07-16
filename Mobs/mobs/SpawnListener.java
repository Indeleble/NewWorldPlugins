package mobs;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;


public class SpawnListener implements Listener {
	
	Mobs plugin;

	public SpawnListener(Mobs listener) {
		this.plugin = listener;
	}

	@EventHandler(priority=EventPriority.HIGH)
	public void onCreatureSpawn(CreatureSpawnEvent event){
		
		LivingEntity lentity = event.getEntity();

		CreatureSpawnEvent.SpawnReason spawnreason = event.getSpawnReason();
		EntityType entitytype = event.getEntityType();
		Location originalloc = event.getLocation();
		
 		/* En proceso */
 		
 		
 		
 		
 		
 		
 	}
}
