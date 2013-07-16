package core.skills;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Skills")
public class Skill {
	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="LEVEL")
	private int level = 0;
	
	@Column(name="EXPERIENCE")
	private int experience = 0;
	
	@Column(name="MAXLEVEL")
	private int maxLevel = 0;
	
	@Column(name="TYPE", nullable=false)
	private SkillType type;
	
	@ManyToOne
	@Column(name="PLAYER_ID", nullable=false)
	private SkillPlayer	player;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void addLevel(int newLevel) {
		setLevel(getLevel()+newLevel);
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public void addExperience(int newExperience) {
		setExperience(getExperience()+newExperience);
	}
	
	public int getMaxLevel() {
		return maxLevel;
	}

	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}

	public SkillType getType() {
		return type;		
	}
	public void setType(SkillType type) {
		this.type= type;		
	}

	public void setPlayer(SkillPlayer skillPlayer) {
		this.player = skillPlayer;
		
	}
	public SkillPlayer getPlayer(){
		return player;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skill other = (Skill) obj;
		if (type != other.type)
			return false;
		return true;
	}
	
}
