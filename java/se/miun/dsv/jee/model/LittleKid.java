package se.miun.dsv.jee.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "KIDS")
public class LittleKid implements Serializable {

	private static final long serialVersionUID = 2L;

	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY ) 
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private int howGood;

	@OneToMany( targetEntity=Toy.class, fetch = FetchType.EAGER )
    private List<Toy> toyList;
	
	public LittleKid() {
	}
	
	public LittleKid(String pFirst, String pLast, int pAge, int pHowGood) {
		firstName = pFirst;
		lastName = pLast;
		age = pAge;
		howGood = pHowGood;
	}
	
	public LittleKid(int pId, String pFirst, String pLast, int pAge, int pHowGood, List<Toy> pList) {
		id = pId;
		firstName = pFirst;
		lastName = pLast;
		age = pAge;
		howGood = pHowGood;
		toyList = pList;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public List<Toy> getToyList() {
		return toyList;
	}

	public void setToyList(List<Toy> toyList) {
		this.toyList = toyList;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHowGood() {
		return howGood;
	}

	public void setHowGood(int howGood) {
		this.howGood = howGood;
	}
	
}
