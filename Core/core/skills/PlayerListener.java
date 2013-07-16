package core.skills;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.avaje.ebean.Query;

import core.husbrandy.AnimalDb;
import core.husbrandy.HusAnimalManager;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PlayerListener implements Listener {

	SkillPlayerManager	spm;
	HusAnimalManager ham;
	Logger				log;

	public PlayerListener(SkillPlayerManager spm, HusAnimalManager ham, Logger log) {

		this.spm = spm;
		this.log = log;
		this.ham = ham;
	}

	@EventHandler
	public void PlayerJoin(PlayerJoinEvent ev) {

		Player player = ev.getPlayer();
		PermissionUser user = PermissionsEx.getUser(player);
		
		
		/*
		 *  Skill player
		 */
		
		Query<SkillPlayer> query = spm.db.find(SkillPlayer.class);

		query.where().eq("accountName", player.getName());

		query.setMaxRows(1);

		List<SkillPlayer> beans = query.findList();

		if (beans == null || beans.size() == 0) {

			player.sendMessage("Bienvenido a Sacra RP, esperamos que lo pases bien");
//			SkillPlayer sp = new SkillPlayer();
//			sp.setAccountName(player.getName());
			
			spm.addSkillPlayer(player.getName());
			
			user.addGroup("user");

		} else {
			player.sendMessage("Bienvenido de nuevo a Sacra RP");
			spm.addSkillPlayer(beans.get(0));
		}
		
		/*
		 *  Husbandry
		 */
		if (user.inGroup("ganaderia")){
			
			Query<AnimalDb> animalQuery = spm.db.find(AnimalDb.class);

			animalQuery.where().eq("owner", player.getName());
			

			List<AnimalDb> animalBeans = animalQuery.findList();

			if (animalBeans == null || beans.size() == 0) {
				
				ham.addOnlineUser(player.getName());
			}else{
				
				List<AnimalDb> al =  animalBeans;
				ham.addOnlineUser(player.getName(), al);
			}	
		}
	}

	@EventHandler
	public void PlayerQuit(PlayerQuitEvent ev) {
		
		PermissionUser user = PermissionsEx.getUser(ev.getPlayer());
		
		spm.db.update(spm.getSkillPlayer(ev.getPlayer().getName()));
		spm.removeSkillPlayer(ev.getPlayer().getName());
		
		if (user.inGroup("ganaderia")){
			
			ham.removeOnlineUser(ev.getPlayer().getName());
		}
	}
}