package mavinproject.training.beans;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("CURRENT_ACC")
public class CurrentAccount extends Account{
	private String type;
	private String name;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type=type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
