package mavinproject.qanda.beans;

import java.util.Set;

public class Answer {
	private int aid;
	private String answer;
	private Set<Users> users;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Set<Users> getUsers() {
		return users;
	}
	public void setUsers(Set<Users> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "Answer [aid=" + aid + ", answer=" + answer + ", users=" + users + "]";
	}
}
