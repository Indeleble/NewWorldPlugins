package gui;

import gui.command.GuiHandler;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.keyboard.Keyboard;

public class Gui extends JavaPlugin{
	
	private static GuiHandler gHandler;

	
	@Override
	public void onLoad() {
		gHandler = new GuiHandler();
	}
	@Override
	public void onEnable(){
		Logger log = this.getLogger();
		log.info("Gui activado");
	}

	@Override
	public void onDisable(){
		Logger log = this.getLogger();
		log.info("Gui desactivado");
	}
	
	public void registerKeys() {
		SpoutManager.getKeyBindingManager().registerBinding("menu de inventario sacra", Keyboard.KEY_F12, "Abre el menu de personaje", gHandler, this);
	}
	
	public static GuiHandler getGuiHandler() {
		return gHandler;
	}

}
