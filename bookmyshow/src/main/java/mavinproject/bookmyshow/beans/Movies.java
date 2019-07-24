package mavinproject.bookmyshow.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="movies")
public class Movies {
	private String mname;
	@Id
	private int mid;
	@OneToMany(mappedBy="movie")
	private List<Theater> tid; 
	@ManyToOne
	private User uid;
	
	public List<Theater> getTid() {
		return tid;
	}
	public void setTid(List<Theater> tid) {
		this.tid = tid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	@Override
	public String toString() {
		return "Movies [mname=" + mname + ", mid=" + mid + ", tid=" + tid + "]";
	}
	
}
