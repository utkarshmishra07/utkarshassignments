/**
 * 
 */
package functionalInterface;

/**
 * @author utkarsh.mishra1
 *
 */
public class Candidate {
	private String name;
	private String techexpertise;
	private String city;
	private int yearsOfExperience;


	public Candidate(String name, String techexpertise, String city, int yearsOfExperience) {
		super();
		this.name = name;
		this.techexpertise = techexpertise;
		this.city = city;
		this.yearsOfExperience = yearsOfExperience;
	}
	/**
	 * @param args
*/


	public String getName() {
		return name;
	}
	public String getTechexpertise() {
		return techexpertise;
	}
	public String getCity() {
		return city;
	}
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	@Override
	public String toString() {
		return "Candidate [Name: " + name + ", Tech Expertise: " + techexpertise + ", City: " + city
				+ ", Years Of Experience: " + yearsOfExperience + "]";
	}
}

