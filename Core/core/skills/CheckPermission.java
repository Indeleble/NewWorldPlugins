package core.skills;

import java.util.logging.Logger;

import ru.tehkode.permissions.PermissionGroup;
import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class CheckPermission {
	
	SkillType skill;
	String playerName;
	int skillLevel;
	Logger log;
	
	public CheckPermission(String playerName, SkillType skill, int skillLevel){
		this.skill = skill;
		this.playerName = playerName;
		this.skillLevel = skillLevel;
	}
	
	public boolean check(){
		
		PermissionUser user = PermissionsEx.getUser(playerName);
		PermissionManager pex = PermissionsEx.getPermissionManager();
		PermissionGroup[] groups = pex.getGroups();
		//Grupo a buscar si existe
		String playerGroup = skill.toString().toLowerCase() +"_"+ String.valueOf(skillLevel);
		
		
		//Recorremos todos los grupos que existen en el permissions
		for (int i = 0;i < groups.length;i++){
			//Si coincide le asigna el grupo
			if (groups[i].getName().equalsIgnoreCase(playerGroup)){
				
				user.addGroup(playerGroup);
				user.save();
				
				return true;
			}
		}		
		return false;
	}
}
