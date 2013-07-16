package core.husbrandy;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Animals")
public class AnimalDb {

	@Id
	@Column(name = "ID")
	private int					id;
	
	@Column(name = "UUID")
	private UUID					uuid;

	@Column(name = "OWNER", nullable = false)
	private String				owner;
	
	@Column(name = "AGE")
	private int					age;
	
	@Column(name = "TYPE")
	private short 				type;
	
	@Column(name = "QUALITY")
	private int					quality;

	public AnimalDb() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public UUID getUuid() {
		return uuid;
	}


	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}


	public String getOwner() {
		return owner;
	}


	public void setOwner(String owner) {
		this.owner = owner;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	public short getType() {
		return type;
	}

	public void setType(short type) {
		this.type = type;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	
}