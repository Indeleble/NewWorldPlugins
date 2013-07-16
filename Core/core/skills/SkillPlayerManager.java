package core.skills;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.avaje.ebean.EbeanServer;

public class SkillPlayerManager extends BukkitRunnable {

	EbeanServer			db;
	List<SkillPlayer>	skillPlayerList;
	Logger				log;
	Plugin				core;

	public SkillPlayerManager(EbeanServer db, Logger log, Plugin core) {

		this.db = db;
		this.log = log;
		this.core = core;

		skillPlayerList = new ArrayList<SkillPlayer>();
		this.runTaskTimerAsynchronously(this.core, 500, 500);
	}

	public EbeanServer getDatabase() {
		return this.db;
	}

	public void saveDb() {

		log.info("Saving database. Number of players to save: " + skillPlayerList.size());
		for (SkillPlayer sp : this.skillPlayerList) {

			db.update(sp);
			// log.info(String.valueOf(sp.getTalaExp()));
			// log.info(String.valueOf(sp.getTalaLvl()));
		}
	}

	public void createSkillPlayer(String player) {

		SkillPlayer sp = db.createEntityBean(SkillPlayer.class);
		sp.setAccountName(player);
		db.save(sp);
		this.skillPlayerList.add(sp);
	}

	public void addSkillPlayer(SkillPlayer player) {

		this.skillPlayerList.add(player);
	}

	public List<SkillPlayer> getSkillPlayerList() {

		return skillPlayerList;

	}

	public boolean existPlayerInDb(String name) {

		if (this.getSkillPlayer(name) != null) {
			return true;
		}

		return false;
	}

	public SkillPlayer getSkillPlayer(String accountName) {

		SkillPlayer player;

		if (skillPlayerList != null) {

			if (skillPlayerList.size() > 0) {

				for (int i = 0; i < skillPlayerList.size(); i++) {

					if (skillPlayerList.get(i).getAccountName().compareToIgnoreCase(accountName) == 0) {
						player = skillPlayerList.get(i);
						return player;
					}
				}
				return null;

			} else
				return null;

		} else
			return null;
	}

	public void removeSkillPlayer(String accountName) {

		if (skillPlayerList != null) {

			if (skillPlayerList.size() > 0) {

				for (int i = 0; i < skillPlayerList.size(); i++) {

					if (skillPlayerList.get(i).getAccountName().compareToIgnoreCase(accountName) == 0) {
						skillPlayerList.remove(i);
						break;
					}
				}
			}
		}
	}

	@Override
	public void run() {
		this.saveDb();
	}

	public void resetPlayer(String name) {

		SkillPlayer sp = this.getSkillPlayer(name);

		this.db.delete(sp.getSkills());

	}

	public void removeSkill(String name, String skillName) {

		SkillPlayer sp = this.getSkillPlayer(name);
		SkillType skillType = SkillType.getFromString(skillName);

		for (Skill s : sp.getSkills()) {

			if (s.getType().equals(skillType)) {
				this.db.delete(s);
				break;
			}
		}

	}

	public void addSkillToPlayer(String name, String skillName) {

		SkillPlayer sp = this.getSkillPlayer(name);
		SkillType skillType = SkillType.getFromString(skillName);

		boolean check = true;

		for (Skill s : sp.getSkills()) {

			if (s.getType().equals(skillType)) {
				check = false;
				break;
			}
		}

		if (check) {
			Skill skill = db.createEntityBean(Skill.class);
			skill.setPlayer(sp);
			db.save(skill);
		}
	}

	public void updateSkillToPlayer(String name, String skillName, String level) {
		
		SkillPlayer sp = this.getSkillPlayer(name);
		SkillType skillType = SkillType.getFromString(skillName);
		int lvl = Integer.valueOf(level);


		for (Skill s : sp.getSkills()) {

			if (s.getType().equals(skillType)) {
				
				s.setLevel(lvl);
				s.setExperience(0);
				db.update(s);
				break;
			}
		}
		
	}
}
