package mavinproject.beans;

import org.springframework.stereotype.Component;

@Component
public class Tyre {
	@Override
	public String toString() {
		return "Tyre [t_brand=" + t_brand + ", size=" + size + ", psi=" + psi + "]";
	}
	public String t_brand;
	private int size;
	private int psi;
	public String getT_brand() {
		return t_brand;
	}
	public void setT_brand(String t_brand) {
		this.t_brand = t_brand;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPsi() {
		return psi;
	}
	public void setPsi(int psi) {
		this.psi = psi;
	}
	
}
