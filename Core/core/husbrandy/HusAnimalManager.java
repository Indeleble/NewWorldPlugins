package core.husbrandy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.bukkit.entity.EntityType;
import org.bukkit.plugin.Plugin;

import com.avaje.ebean.EbeanServer;

public class HusAnimalManager {

	HashMap<String, List<AnimalDb>>	animals;

	EbeanServer								db;
	Logger									log;
	Plugin									core;

	public HusAnimalManager(EbeanServer db, Logger log, Plugin core) {

		this.animals = new HashMap<String, List<AnimalDb>>();

		this.log = log;
		this.core = core;
		this.db = core.getDatabase();
	}

	public void saveDb() {

		for (String name : animals.keySet()) {
			updateDb(name);
		}

	}

	public void updateDb(String name) {

		if (animals.get(name) != null) {

			for (AnimalDb adb : animals.get(name)) {
				db.update(adb);
			}
		}

	}

	public void addNewAnimalToDb(String user, AnimalDb animal) {

		if (animals.get(user) != null) {

			animals.get(user).add(animal);
			db.save(animal);
		} else {

			ArrayList<AnimalDb> l = new ArrayList<AnimalDb>();
			l.add(animal);
			animals.put(user, l);
			db.save(animal);
		}
	}

	public void removeAnimalFromDb(String user, AnimalDb animal) {

		if (animals.get(user) != null) {

			db.delete(animal);
			animals.get(user).remove(animal);
		}

	}

	public void addOnlineUser(String name) {

		if (animals.get(name) != null) {

			animals.put(name, new ArrayList<AnimalDb>());
		}

	}

	public void addOnlineUser(String name, List<AnimalDb> al) {

		if (animals.get(name) != null) {

			animals.put(name, al);
		}

	}

	public void removeOnlineUser(String name) {

		if (animals.get(name) != null) {
			updateDb(name);
			animals.remove(name);
		}
	}

	public String animalHasOwner(UUID id) {

		for (String name : animals.keySet()) {

			for (AnimalDb animal : animals.get(name)) {

				if (animal.getUuid() == id) {
					return name;
				}
			}
		}
		return null;
	}

	public ArrayList<AnimalDb> getWolfs(String name) {

		ArrayList<AnimalDb> wolfs = new ArrayList<AnimalDb>();

		if (animals.get(name) != null) {

			for (AnimalDb animal : animals.get(name)) {

				if (animal.getType() == EntityType.WOLF.getTypeId()) {

					wolfs.add(animal);
				}

			}
			if (wolfs.size() >0) return wolfs;
		}

		return null;
	}
	//Cattle = ganado
	//Returns cows and sheeps
	public ArrayList<AnimalDb> getCattle(String name) {

		ArrayList<AnimalDb> cattle = new ArrayList<AnimalDb>();

		if (animals.get(name) != null) {

			for (AnimalDb animal : animals.get(name)) {

				if (animal.getType() == EntityType.COW.getTypeId() || animal.getType() == EntityType.SHEEP.getTypeId()) {

					cattle.add(animal);
				}
			}
			if (cattle.size() >0) return cattle;
		}

		return null;
	}
	
	public ArrayList<AnimalDb> getCows(String name) {

		ArrayList<AnimalDb> cattle = new ArrayList<AnimalDb>();

		if (animals.get(name) != null) {

			for (AnimalDb animal : animals.get(name)) {

				if (animal.getType() == EntityType.COW.getTypeId()) {

					cattle.add(animal);
				}
			}
			if (cattle.size() >0) return cattle;
		}

		return null;
	}
	
	public ArrayList<AnimalDb> getSheeps(String name) {

		ArrayList<AnimalDb> cattle = new ArrayList<AnimalDb>();

		if (animals.get(name) != null) {

			for (AnimalDb animal : animals.get(name)) {

				if (animal.getType() == EntityType.SHEEP.getTypeId()) {

					cattle.add(animal);
				}
			}
			if (cattle.size() >0) return cattle;
		}

		return null;
	}

}
