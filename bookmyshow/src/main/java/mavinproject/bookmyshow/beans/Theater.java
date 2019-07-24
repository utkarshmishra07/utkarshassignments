package mavinproject.bookmyshow.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="theater")
public class Theater {
	@Id
	private int tid;
	private String tname;
	private String tlocation;
	private int nhall;
	@OneToMany(mappedBy="theater")
	private List<Hall> hid;
	public Movies getMovie() {
		return movie;
	}
	public void setMovie(Movies movie) {
		this.movie = movie;
	}
	@ManyToOne
	private Movies movie;
	
	public List<Hall> getHid() {
		return hid;
	}
	public void setHid(List<Hall> hid) {
		this.hid = hid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTlocation() {
		return tlocation;
	}
	public void setTlocation(String tlocation) {
		this.tlocation = tlocation;
	}
	public int getNhall() {
		return nhall;
	}
	public void setNhall(int nhall) {
		this.nhall = nhall;
	}
	@Override
	public String toString() {
		return "Theater [tid=" + tid + ", tname=" + tname + ", tlocation=" + tlocation + ", nhall=" + nhall + ", hid="
				+ hid + "]";
	}
	
	
	
}
