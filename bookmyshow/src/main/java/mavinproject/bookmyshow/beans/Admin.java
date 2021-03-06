package mavinproject.bookmyshow.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
	@Id
	private int aid;
	private String apassword;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getApassword() {
		return apassword;
	}

	public void setApassword(String apassword) {
		this.apassword = apassword;
	}

	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", apassword=" + apassword + "]";
	}
	
}
