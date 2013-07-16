package keys.commands;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KeysCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
		Random r = new Random();
		int random = 0;
    	Player player = (Player) sender;

		if((args[0].equalsIgnoreCase("dado"))){
	    	random = r.nextInt(6);
			if(random==0){
				random=6;
			}
	        player.chat(ChatColor.DARK_GREEN+"/me lanza un dado al aire que cae en "+random);
		}else if((args[0].equalsIgnoreCase("moneda"))){
	    	random = r.nextInt(2);
			if(random==0){
				player.chat(ChatColor.DARK_GREEN+"/me lanza una moneda al aire que cae en cara");
			}else if(random==1){
				player.chat(ChatColor.DARK_GREEN+"/me lanza una moneda al aire que cae en cruz");
			}
		}
		return false;
	}
}
