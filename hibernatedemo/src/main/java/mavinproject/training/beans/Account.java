package mavinproject.training.beans;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



@Entity
@Inheritance(strategy=InheritanceType.JOINED)
//@Inheritence(strategy=InheritanceType.SINGLE_TABLE)
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Account {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	
	
	private int acc_no;
	private String name;
	private Date acc_date;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}
	public Date getAcc_date() {
		return acc_date;
	}
	public void setAcc_date(Date acc_date) {
		this.acc_date = acc_date;
	}
	@Override
	public String toString() {
		return "Account [acc_no=" + acc_no + ", name=" + name + ", acc_date=" + acc_date + "]";
	}
}
