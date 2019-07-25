package mavinproject.qanda.beans;


import org.springframework.stereotype.Component;

@Component
public class Users {
	
	private int uid;
	private String uname;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	@Override
	public String toString() {
		return "Users [uid=" + uid + ", uname=" + uname + "]";
	}
}
