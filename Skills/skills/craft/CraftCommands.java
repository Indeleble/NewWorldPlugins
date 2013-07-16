package skills.craft;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.PermissionUser;
import core.skills.SkillPlayer;
import core.skills.SkillPlayerManager;
import core.skills.SkillType;

public class CraftCommands implements CommandExecutor {

	SkillPlayerManager	spm;

	public CraftCommands(SkillPlayerManager spm) {
		this.spm = spm;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		SkillPlayer sp;
		PermissionUser user;
		PermissionManager pex;

		if (cmd.getName().equalsIgnoreCase("pangolin")) {
			if (args.length == 2){
				
				sp = spm.getSkillPlayer(sender.getName());
				sp.addExperience(SkillType.getFromString(args[0]), Integer.valueOf(args[1]));
				
			}
			sender.sendMessage("Algo ha ido mal. Avisa a un administrador por favor. Codigo: <craft>");
			return true;
		}
		return false;
	}
}