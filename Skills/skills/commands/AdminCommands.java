package skills.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import core.skills.Skill;
import core.skills.SkillPlayer;
import core.skills.SkillPlayerManager;
import core.skills.SkillType;

public class AdminCommands implements CommandExecutor {

	SkillPlayerManager	spm;

	public AdminCommands(SkillPlayerManager spm) {
		this.spm = spm;
	}

	/*
	 * User commands
	 */
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		SkillPlayer sp;
		PermissionUser user;
		PermissionManager pex = PermissionsEx.getPermissionManager();

		if (cmd.getName().equalsIgnoreCase("dedodedios")) {

			if (args.length > 1) {

				String command = args[1];
				String name= args[0];

				switch (command) {

					case "reset":
						spm.resetPlayer(name);
						break;
						
					case "quitar":
						spm.removeSkill(args[0],args[2]);
						break;
						
					case "dar":
						spm.addSkillToPlayer(args[0], args[2]);
						break;
						
					case "level":
						spm.updateSkillToPlayer(args[0], args[2], args[3]);
						break;
						
				}

			}

			return true;
		}
		return true;
	}

}