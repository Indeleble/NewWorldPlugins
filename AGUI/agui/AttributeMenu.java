package agui;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;
import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.gui.Container;
import org.getspout.spoutapi.gui.ContainerType;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericContainer;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.Label;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.Texture;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class AttributeMenu extends GenericPopup {
	
	private final int COLUMN_WIDTH = 90;
	
	private int page;
	
	private Label title;
	
	private Container infoContent;
	private Texture background;
	private Label infoTitle;
	private Label infoDescription;
	
	private Button nextButton;
	private Button prevButton;
	
	private Button closeButton;
	
	private List<Label> benefits = new ArrayList<Label>();
	
	public AttributeMenu(SpoutPlayer player) {

		page = 1;
		
		closeButton = new GenericButton(ChatColor.RED + "Close") {
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
		
		title = new GenericLabel("Attribute Menu");
		title.setTextColor(new Color(107, 142, 35))
			 .setWidth(GenericLabel.getStringWidth(title.getText()))
			 .setHeight(GenericLabel.getStringHeight(title.getText()))
			 .setAnchor(WidgetAnchor.TOP_CENTER)
			 .setX(-(title.getWidth() / 2))
			 .setY(25 - (title.getHeight() / 2))
			 .setFixed(true);
		

		
		prevButton = new GenericButton(ChatColor.GRAY + "<--") {
			@Override
			public void onButtonClick(ButtonClickEvent event) {
				
			}
		};

		
		nextButton = new GenericButton(ChatColor.GRAY + "-->") {
			@Override
			public void onButtonClick(ButtonClickEvent event) {
				
			}
			
		};
		
		infoContent = new GenericContainer();
		infoContent.setLayout(ContainerType.OVERLAY);
		infoContent.setAnchor(WidgetAnchor.CENTER_CENTER)
				   .setWidth(220)
				   .setHeight(220)
				   .setX(-14)
				   .setY(-(infoContent.getHeight() / 2))
				   .setFixed(true);
		
		background = new GenericTexture("attribute_background.png");
		background.setPriority(RenderPriority.Highest)
				  .setAnchor(WidgetAnchor.CENTER_CENTER)
				  .setWidth(380 + 60)
				  .setHeight(200 + 60)
				  .setX(-(background.getWidth() / 2))
				  .setY(-(background.getHeight() / 2))
				  .setFixed(true);
		
		infoTitle = new GenericLabel("Select an attribute!");
		infoTitle.setTextColor(new Color(107, 142, 35))
				 .setAnchor(WidgetAnchor.TOP_LEFT)
				 .setWidth(GenericLabel.getStringWidth(infoTitle.getText()))
				 .setHeight(GenericLabel.getStringHeight(infoTitle.getText()))
				 .setMarginLeft((infoContent.getWidth() / 2) - (infoTitle.getWidth() / 2))
				 .setMarginTop(20 - (infoTitle.getHeight() / 2));
		
		infoDescription = new GenericLabel(WordUtils.wrap("", (infoContent.getWidth() + 20) / GenericLabel.getStringWidth("q")));
		infoDescription.setTextColor(new Color(84, 84, 84))
					   .setAnchor(WidgetAnchor.CENTER_LEFT)
					   .setWidth(GenericLabel.getStringWidth(infoDescription.getText()))
					   .setHeight(GenericLabel.getStringHeight(infoDescription.getText()))
					   .setMarginLeft(20)
					   .setMarginTop(40);
		
		infoContent.addChildren(infoTitle, infoDescription);
		
	
		
		this.page = page;
	}
	
	
	
}
