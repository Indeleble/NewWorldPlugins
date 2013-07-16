package agui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.event.spout.SpoutCraftEnableEvent;
import org.getspout.spoutapi.gui.ContainerType;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class GuiHandler implements Listener {
	
	Plugin pl;
	
	public GuiHandler(Plugin pl){
		
		this.pl = pl;
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onJoin(SpoutCraftEnableEvent event) {
		
		final SpoutPlayer sPlayer = SpoutManager.getPlayer(event.getPlayer());
		PlayerHud hud = new PlayerHud(pl, sPlayer);
		hud.setLayout(ContainerType.OVERLAY)
		   .setAnchor(WidgetAnchor.TOP_LEFT)
		   .setX(10)
		   .setY(10)
		   .setWidth(100)
		   .setHeight(100)
		   .setFixed(true);
		AttributeMenu am = new AttributeMenu(sPlayer);
		
		am.setScreen(this.pl, sPlayer.getMainScreen()) .setAnchor(WidgetAnchor.TOP_LEFT)
		   .setX(10)
		   .setY(10)
		   .setWidth(100)
		   .setHeight(100)
		   .setFixed(true);
		
		sPlayer.getMainScreen().attachWidget(this.pl, hud);
		sPlayer.getMainScreen().attachPopupScreen(am);
	}
	

}
