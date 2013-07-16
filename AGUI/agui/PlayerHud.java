package agui;

import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.gui.ContainerType;
import org.getspout.spoutapi.gui.GenericContainer;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.Label;
import org.getspout.spoutapi.gui.Texture;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class PlayerHud extends GenericContainer {
	
	private GenericBar healthBar;
	private GenericBar manaBar;
	private GenericBar staminaBar;
	
	private Label level;
	
	private Texture currExp;
	
	private Texture bgExp;
	
	private Texture bgAp;
	
	private Label apText;
	
	public PlayerHud(Plugin plugin, final SpoutPlayer player) {
		//final MPlayer mPlayer = MRPG.getPlayer(player);
		
		int backHeight = 166 / 3;
		int backWidth = 337 / 3;
		
		this.setLayout(ContainerType.OVERLAY)
			.setWidth(backWidth)
			.setHeight(backHeight)
			.setAnchor(WidgetAnchor.BOTTOM_LEFT);
		
		level = new GenericLabel("1");
		
		bgExp = new GenericTexture("mrpg_hud_3_label.png");
		bgExp.setAnchor(WidgetAnchor.TOP_LEFT)
			 .setFixed(true)
			 .setWidth(54)
			 .setHeight(50);		
		
		healthBar = new GenericBar("http://imageshack.us/a/img96/2773/wipreddepleted001.png",
								   "http://imageshack.us/a/img571/9848/wipred001.png",
								   100, 8, new Color(255, 255, 255));

		
		healthBar.setFixed(true)
				 .setAnchor(WidgetAnchor.TOP_LEFT)
				 .setMarginLeft(bgExp.getWidth() - 5)
				 .setMarginTop(14);
		
		manaBar = new GenericBar("http://imageshack.us/a/img443/806/wipbluedepleted001.png",
				   				 "http://imageshack.us/a/img22/4250/wipblue001.png",
				   				 100, 8, new Color(255, 255, 255));
		
		manaBar.setFixed(true)
			   .setAnchor(WidgetAnchor.TOP_LEFT)
			   .setMarginLeft(bgExp.getWidth() - 5)
			   .setMarginTop(healthBar.getMarginTop() + healthBar.getHeight() + 1);
		

		
		
		staminaBar = new GenericBar("http://imageshack.us/a/img502/5195/wipgolddepleted001.png",
				   					"http://imageshack.us/a/img843/3645/wipgold001.png",
				   					 100, 8, new Color(255, 255, 255));
		
		
		staminaBar.setFixed(true)
			   .setAnchor(WidgetAnchor.TOP_LEFT)
			   .setMarginLeft(bgExp.getWidth() - 5)
			   .setMarginTop(manaBar.getMarginTop() + manaBar.getHeight() + 1);
		
		healthBar.addChildren(manaBar, staminaBar, bgExp);
		
		addChildren(healthBar);
	}
	

	
	public Label getLevel() {
		return level;
	}
	
	public Label getSkillPoints() {
		return apText;
	}
	
	public GenericBar getStaminaBar() {
		return staminaBar;
	}
	
	public GenericBar getManaBar() {
		return manaBar;
	}
	
	public GenericBar getHealthBar() {
		return healthBar;
	}
	
}
