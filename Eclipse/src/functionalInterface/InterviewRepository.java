/**
 * 
 */
package functionalInterface;
import java.util.ArrayList;
import java.util.List;
import functionalInterface.Candidate;
/**
 * @author utkarsh.mishra1
 *
 */
public class InterviewRepository {
	List<Candidate> candidates=null;
	public InterviewRepository() {
		candidates=new ArrayList<>();
	
	}
	public List<Candidate> getAllCandidates(){
		candidates.add(new Candidate("name1","c","city1",2));
		candidates.add(new Candidate("name2","j","city2",4));
		candidates.add(new Candidate("name3","s","city3",5));
		candidates.add(new Candidate("name4","c","city4",4));
		candidates.add(new Candidate("name5","s","city1",1));
		candidates.add(new Candidate("name6","j","city2",2));
		candidates.add(new Candidate("name7","s","city4",3));
		return candidates;
	}
	public void addCandidates(Candidate c) {
		candidates.add(c);
	}
	public Candidate getCandidate(int index) {
		Candidate c=candidates.get(index);
		return c;
	}
	public void deleteCandidate(int index) {
		candidates.remove(index); 
	}
}
