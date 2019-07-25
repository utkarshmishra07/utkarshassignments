package mavinproject.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DieselEngine implements Engine{
	@Override
	public String toString() {
		return "DieselEngine [hp=" + hp + ", cc=" + cc + ", cylinder=" + cylinder + ", emodel=" + emodel + "]";
	}
	private int hp;
	private int cc;
	private int cylinder;
	private String emodel;
	public int getHp() {
		return hp;
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
