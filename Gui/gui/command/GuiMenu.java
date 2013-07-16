package gui.command;


import org.bukkit.ChatColor;
import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.Label;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

import ru.tehkode.permissions.PermissionUser;

import core.skills.SkillPlayer;
import core.skills.SkillPlayerManager;


public class GuiMenu extends GenericPopup{

	private Label title;
	private Button closeButton;

	SkillPlayerManager spm;
	
	public GuiMenu(SkillPlayerManager spm) {
		this.spm = spm;
	}
	
	SkillPlayer sp;
	PermissionUser user;


	public GuiMenu(SpoutPlayer player) {
		
		sp = spm.getSkillPlayer(player.getName());
		
//		MPlayer giplayer = Gui.getPlayer(player);
		
		
		closeButton = new GenericButton(ChatColor.RED +"Close") {
			@Override
			public void onButtonClick(ButtonClickEvent event) {
				getPlayer().getMainScreen().closePopup();
			}
		};
		closeButton.setAnchor(WidgetAnchor.BOTTOM_CENTER)
		.setWidth(64)
		.setHeight(20)
		.setX(-(closeButton.getWidth() / 2))
		.setY(-(closeButton.getHeight() / 2) - getHeight() / 2)
		.setFixed(true);
		
		title = new GenericLabel("Menu de Jugador");
		title.setTextColor(new Color(107, 142, 35))
		.setWidth(GenericLabel.getStringWidth(title.getText()))
		.setHeight(GenericLabel.getStringHeight(title.getText()))
		.setAnchor(WidgetAnchor.TOP_CENTER)
		.setX(-(title.getWidth() / 2))
		.setY(25 - (title.getHeight() / 2))
		.setFixed(true);
	}
}
