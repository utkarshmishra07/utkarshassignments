/**
 * 
 */
package Beans;

/**
 * @author utkarsh.mishra1
 *
 */
public class Student implements Comparable<Student>{
	private int sId;
	private String sName;
	private int sMarks;
	private int sAge;
	
	
	public Student(int sId, String sName, int sMarks, int sAge) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sMarks = sMarks;
		this.sAge = sAge;
	}
	/**
	 * @param args
	 */

	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getsMarks() {
		return sMarks;
	}
	public void setsMarks(int sMarks) {
		this.sMarks = sMarks;
	}
	public int getsAge() {
		return sAge;
	}
	public void setsAge(int sAge) {
		this.sAge = sAge;
	}
	@Override
	public int compareTo(Student s) {
		if(sId>s.getsId()) return 1;
		else if(sId<s.getsId()) return -1;
		else return 0;
	}
	

}
