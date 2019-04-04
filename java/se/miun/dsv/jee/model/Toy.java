package se.miun.dsv.jee.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "TOYS")
public class Toy implements Serializable {

	private static final long serialVersionUID = 3L;
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private int id;
	private String name;
	private String manufacturer;
	
	public Toy() {
	}
	
	public Toy(String pName, String pManufacturer) {
		name = pName;
		manufacturer = pManufacturer;
	}
	
	public Toy(int pId, String pName, String pManufacturer) {
		id = pId;
		name = pName;
		manufacturer = pManufacturer;
	}

	@Override
	public String toString() {
		return name + " (" + manufacturer + ")";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String lastName) {
		this.name = lastName;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
}
