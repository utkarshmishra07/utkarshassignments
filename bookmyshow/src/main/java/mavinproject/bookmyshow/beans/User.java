package mavinproject.bookmyshow.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user1")
public class User {
	@Id
	private int userid;
	private String uname;
	private String upassword;
	@OneToMany
	private List<Movies> mid;
	@OneToMany
	private List<Hall> nseats;
	
	
	public List<Hall> getNseats() {
		return nseats;
	}
	public void setNseats(List<Hall> nseats) {
		this.nseats = nseats;
	}
	public List<Movies> getMid() {
		return mid;
	}
	public void setMid(List<Movies> mid) {
		this.mid = mid;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	@Override
	public String toString() {
		return "User [uid=" + userid + ", uname=" + uname + ", upassword=" + upassword + " , mid=" + mid + ", nseats="
				+ nseats + "]";
	}
	

}
