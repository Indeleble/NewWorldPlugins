package gui.command;

import org.getspout.spoutapi.event.input.KeyBindingEvent;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.keyboard.BindingExecutionDelegate;


public class GuiHandler implements BindingExecutionDelegate{

	@Override
	public void keyPressed(KeyBindingEvent event) {
	}

	@Override
	public void keyReleased(KeyBindingEvent event) {
		if (!event.getPlayer().isSpoutCraftEnabled()) return;
		if (event.getPlayer().getActiveScreen() == ScreenType.GAME_SCREEN) {
			if (event.getBinding().getId().equalsIgnoreCase("menu de inventario sacra")) {
				GuiMenu giMenu = new GuiMenu(event.getPlayer());
				event.getPlayer().getMainScreen().attachPopupScreen(giMenu);
				return;
			}
		}
	}
}
