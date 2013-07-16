package keys.listeners;

import java.util.Random;

import keys.Keys;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;


public class KeysListener implements Listener{
	
	Keys keys;
	
	public KeysListener(Keys keys) {
		this.keys = keys;
	}
	 
	@EventHandler
    public void onPlayerInteract(PlayerInteractEvent evnt) {
		
		
        Player player = evnt.getPlayer();
        Action action = evnt.getAction();
        Block block = evnt.getClickedBlock();
        ItemStack inHand = evnt.getPlayer().getItemInHand();
        
        int iih = player.getItemInHand().getTypeId();
        //330 369
        
        
        switch (action) {
        }
        }

/*		
	
	public static List<Material> getTransparentMaterials(){
		Material[] materials = {Material.AIR, Material.BED, Material.BED_BLOCK, Material.BREWING_STAND, Material.BROWN_MUSHROOM,
				Material.BURNING_FURNACE, Material.CACTUS, Material.CAKE_BLOCK, Material.CAULDRON, Material.CHEST,
				Material.DEAD_BUSH, Material.DETECTOR_RAIL, Material.DIODE, Material.DIODE_BLOCK_OFF, Material.DIODE_BLOCK_ON,
				Material.DISPENSER, Material.DRAGON_EGG, Material.EGG, Material.ENCHANTMENT_TABLE, Material.ENDER_PORTAL, Material.ENDER_PORTAL_FRAME,
				Material.ENDER_STONE, Material.FENCE, Material.FENCE_GATE, Material.FIRE, Material.FURNACE, Material.GLASS, Material.HUGE_MUSHROOM_1, Material.HUGE_MUSHROOM_2,
				Material.IRON_DOOR_BLOCK, Material.IRON_FENCE, Material.JUKEBOX, Material.LADDER, Material.LAVA, Material.LEVER, Material.LONG_GRASS, Material.MELON_STEM,
				Material.MOB_SPAWNER, Material.NETHER_FENCE, Material.NETHER_STALK, Material.NETHER_WARTS, Material.PAINTING, Material.PISTON_BASE, Material.PISTON_EXTENSION,
				Material.PISTON_MOVING_PIECE, Material.PISTON_STICKY_BASE, Material.PORTAL, Material.PUMPKIN_STEM, Material.RED_ROSE, Material.RED_MUSHROOM, Material.SAPLING, Material.SIGN, Material.SIGN_POST, Material.STATIONARY_LAVA,
				Material.SNOW, Material.STATIONARY_WATER, Material.STONE_BUTTON, Material.SUGAR_CANE_BLOCK, Material.THIN_GLASS, Material.TNT, Material.TORCH, Material.TRAP_DOOR, Material.VINE, Material.WALL_SIGN,
				Material.WATER, Material.WEB, Material.WHEAT, Material.WOODEN_DOOR, Material.WORKBENCH, Material.YELLOW_FLOWER};

		return Arrays.asList(materials);
	}

	private BlockFace getPlayerFacing(Player player) {
		float y = player.getLocation().getYaw();
        if( y < 0 ) y += 360;
        y %= 360;
        int i = (int)((y+8) / 22.5);
        
        if(i == 0) return BlockFace.WEST;
        else if(i == 1) return BlockFace.NORTH_WEST;
        else if(i == 2) return BlockFace.NORTH_WEST;
        else if(i == 3) return BlockFace.NORTH_WEST;
        else if(i == 4) return BlockFace.NORTH;
        else if(i == 5) return BlockFace.NORTH_EAST;
        else if(i == 6) return BlockFace.NORTH_EAST;
        else if(i == 7) return BlockFace.NORTH_EAST;
        else if(i == 8) return BlockFace.EAST;
        else if(i == 9) return BlockFace.SOUTH_EAST;
        else if(i == 10) return BlockFace.SOUTH_EAST;
        else if(i == 11) return BlockFace.SOUTH_EAST;
        else if(i == 12) return BlockFace.SOUTH;
        else if(i == 13) return BlockFace.SOUTH_WEST;
        else if(i == 14) return BlockFace.SOUTH_WEST;
        else if(i == 15) return BlockFace.SOUTH_WEST;

        return BlockFace.WEST;

	}

	@EventHandler //----- Tocar a la puerta
	public void onBlockDamage(BlockDamageEvent event) {

        Player player = event.getPlayer();
        Block block = event.getBlock();
        int material = block.getTypeId();

		if(player.hasMetadata("NPC")) return;

		if((material==64) || (material==71)){
			player.getWorld().playSound(block.getLocation(), Sound.ZOMBIE_WOOD, 1, 1);
		}
	}

	/* Romper hielos y demases */
	@EventHandler 
	public void OnPlayerMoveEvent(PlayerMoveEvent event){
		Player player = event.getPlayer();
		if(player.getGameMode()==GameMode.SURVIVAL){
			Location loc = event.getPlayer().getLocation();
			loc.setY(loc.getY() - 1);
			Location loc2 = event.getPlayer().getLocation();
			loc2.setY(loc.getY() -2);
			
			World w = loc.getWorld();
			Block b = w.getBlockAt(loc);
			Block b2 = w.getBlockAt(loc2);
			
			if ((b.getType() == Material.ICE) && (b2.getType() == (Material.STATIONARY_WATER) || b2.getType() == (Material.WATER))){
				int r2=0;
				Random r = new Random();
				
				r2 = r.nextInt(10);
				if (r2==1){
					
					/* Bucles y demases */
					int x = b.getX();
					int z = b.getZ();
					x++;
					z++;
					Location bLoc = b.getLocation();
					bLoc.setX(x);
					bLoc.setZ(z);

					for (int i = 0;i<3;i++){
						for (int j = 0;j<3;j++){
							
							if (player.getWorld().getBlockAt(bLoc).getType() == Material.ICE){
								player.getWorld().getBlockAt(bLoc).setType(Material.WATER);								
							}
							bLoc.setZ(bLoc.getZ() - 1);							
						}
						bLoc.setZ(bLoc.getZ() + 3);
						bLoc.setX(bLoc.getX() - 1);				
					}
					

					player.sendMessage(ChatColor.DARK_RED+"¡Has roto el hielo por el que caminabas!");
				}
			}

		}
		
		
		
		// for server getworld getblockat
	}
/*	@EventHandler //----- Sprint
	public void onPlayerSprint(final PlayerToggleSprintEvent event){
		
		final Player player = event.getPlayer();
	    final Timer tiempoespera = new Timer();    
	    long tiempoaguante = 5000; // Colocar 5000 (5 segs) * nivel de resistencia del jugador para que aumente la distancia que puedes sprintar sin cansarte.
	    
	    TimerTask timerTask = new TimerTask(){
	    	public void run(){
	    		if(player.isSprinting()){
		    		event.setCancelled(true);
					if(!player.hasPotionEffect(PotionEffectType.SLOW)){
						player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 3));
					}
					tiempoespera.cancel();
	    		}
		    }
	    };
	    
	    if(player.isSprinting()){
	    	tiempoespera.scheduleAtFixedRate(timerTask, tiempoaguante, 1); 
	    }

	}*/



}
