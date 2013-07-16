package husbandry;

import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Logger;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Wolf;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import core.husbrandy.AnimalDb;
import core.husbrandy.HusAnimalManager;
import core.skills.SkillPlayer;
import de.ntcomputer.minecraft.controllablemobs.api.ControllableMob;
import de.ntcomputer.minecraft.controllablemobs.api.ControllableMobs;

public class WolfCommands implements CommandExecutor {

	Logger				log;
	HusAnimalManager	hum;
	Player				player;
	SkillPlayer			sp;
	PermissionUser		user;
	ArrayList<AnimalDb>	wolfs;
	World				world;
	String				args;

	public WolfCommands(HusAnimalManager hum, World world) {
		this.hum = hum;
		this.world = world;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 2)
			this.args = args[1];
		if (cmd.getName().equalsIgnoreCase("lobos")) {

			if (!(sender instanceof Player)) {
				sender.sendMessage("This command can only be run by a player.");
				return true;

			} else {

				player = (Player) sender;

				if (args.length >= 1) {

					user = PermissionsEx.getUser(player);

					if (user.inGroup("ganaderia")) {

						this.wolfs = hum.getWolfs(player.getName());
						// Comprobamos si tiene lobos
						if (wolfs != null) {

							makeAction(args[0]);
							return true;

							// Si no tiene lobos
						} else {
							player.sendMessage("No tienes lobos adiestrados");
							return true;
						}

						// Si no es ganadero o tameador
					} else {
						player.sendMessage("No sabes adiestrar lobos");
						return true;
					}

				} else {
					player.sendMessage("Comando mal escrito");
					return true;
				}
			}
		}

		return true;
	}

	private void makeAction(String string) {

		string = string.toLowerCase();
		WolfCall action = WolfCall.getFromString(string);
		switch (action) {

			case llamar:

				for (AnimalDb wolfDb : wolfs) {

					Wolf wolf = getWolf(wolfDb.getUuid());
					wolf.setSitting(false);
					ControllableMob<Wolf> cWolf = getControlledWolf(wolf);
					cWolf.getActions().moveTo(player.getLocation());
					wolf.setSitting(true);
				}
			break;

			case traer:

				ArrayList<AnimalDb> cattle;

				switch (args) {

					case "vacas":
						cattle = hum.getCows(player.getName());
						if (cattle == null)
							player.sendMessage("No tienes vacas");
					break;

					case "ovejas":
						cattle = hum.getSheeps(player.getName());
						if (cattle == null)
							player.sendMessage("No tienes ovejas");
					break;

					default:
						player.sendMessage("Solo ovejas o vacas");
						cattle = null;
					break;
				}

				if (cattle != null) {
					int flag = 0;
					for (AnimalDb a : cattle) {

						Wolf wolf = getWolf(wolfs.get(flag).getUuid());
						LivingEntity animal = getCattleEntity(a.getUuid());

						wolf.setSitting(false);

						ControllableMob<Wolf> cWolf = getControlledWolf(wolf);
						ControllableMob<LivingEntity> cAnimal = ControllableMobs.getOrAssign(animal);

						cWolf.getActions().moveTo(animal.getLocation(), true);
						cAnimal.getProperties().setMovementSpeed(0.15f);
						cAnimal.getActions().follow(wolf, true, 6, 2);

						if (flag == wolfs.size() - 1) {
							flag = 0;

						} else flag++;

					}
				}

			break;

			default:
				player.sendMessage("Comando mal escrito");
			break;
		}
	}

	private Wolf getWolf(UUID uid) {

		for (Wolf w : world.getEntitiesByClass(Wolf.class)) {

			if (w.getUniqueId() == uid)
				return w;
		}
		return null;
	}

	private LivingEntity getCattleEntity(UUID uid) {

		for (Entity e : world.getEntitiesByClasses(Cow.class, Sheep.class)) {

			if (e.getUniqueId() == uid)
				return (LivingEntity) e;
		}

		return null;
	}

	private ControllableMob<Wolf> getControlledWolf(Wolf wolf) {
		return ControllableMobs.getOrAssign(wolf, true);
	}

}
