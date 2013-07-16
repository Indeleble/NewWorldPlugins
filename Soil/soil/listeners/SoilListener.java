package soil.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;

import soil.Soil;

public class SoilListener implements Listener{
	
	Soil soil;
	
	public SoilListener(Soil keys) {
		this.soil = keys;
	}
	 
	@EventHandler
    public void soilToDirtEvent(BlockFadeEvent evnt) {
		
		Block block = evnt.getBlock();
			
			if (block.getType() == Material.SOIL){
				evnt.setCancelled(true);
			}
	}
}
		
		
        