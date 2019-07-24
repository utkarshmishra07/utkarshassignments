package mavinproject.bookmyshow.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="hall")
public class Hall {
	
	private int nseats;
	@Id
	private int hid;
	private String hname;
	private String htype;
	private int hprice;
	@OneToOne
	private Movies mid;
	
	@ManyToOne
	private Theater theater;
	
	public Theater getTheater() {
		return theater;
	}
	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	public Movies getMid() {
		return mid;
	}
	public void setMid(Movies mid) {
		this.mid = mid;
	}
	public int getHprice() {
		return hprice;
	}
	public void setHprice(int hprice) {
		this.hprice = hprice;
	}
	public int getNseats() {
		return nseats;
	}
	public void setNseats(int nseats) {
		this.nseats = nseats;
	}
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getHtype() {
		return htype;
	}
	public void setHtype(String htype) {
		this.htype = htype;
	}
	@Override
	public String toString() {
		return "Hall [nseats=" + nseats + ", hid=" + hid + ", hname=" + hname + ", htype=" + htype + ", hprice="
				+ hprice + ", mid=" + mid + "]";
	}
	
}
