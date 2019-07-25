package mavinproject.beans;

import org.springframework.stereotype.Component;

@Component
public class PetrolEngine implements Engine{
	private int hp;
	private int cc;
	private int cylinder;
	private String emodel;
	public int getHp() {
		return hp;
	}
	@Override
	public String toString() {
		return "PetrolEngine [hp=" + hp + ", cc=" + cc + ", cylinder=" + cylinder + ", emodel=" + emodel + "]";
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public int getCylinder() {
		return cylinder;
	}
	public void setCylinder(int cylinder) {
		this.cylinder = cylinder;
	}
	public String getEmodel() {
		return emodel;
	}
	public void setEmodel(String emodel) {
		this.emodel = emodel;
	}
	

}
