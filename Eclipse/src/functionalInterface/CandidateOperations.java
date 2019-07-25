package functionalInterface;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CandidateOperations {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterviewRepository repo=new InterviewRepository();
		List<Candidate> candidates=repo.getAllCandidates();
		System.out.println("===================");
		for(Candidate c:candidates) {
			System.out.println(c);
		}
		System.out.println("1.Candidates from Indore\n2.List city\n3.Technical and Count\n4.Freshers");
		System.out.println("===================");
		List<Candidate> indoreCan=repo.getAllCandidates().stream().filter((can)->can.getCity().equals("city2")).collect(Collectors.toList());
		for(Candidate c:indoreCan) {
			System.out.println(c);
		}
		System.out.println("===================");
		Map<String,List<Candidate>> canCount=repo.getAllCandidates().stream().collect(Collectors.groupingBy((can)->can.getCity()));
		for(String city:canCount.keySet()) {
			System.out.println(city+" "+canCount.get(city).size());
		}
		System.out.println("===================");
		Map<String,List<Candidate>> techCount=repo.getAllCandidates().stream().collect(Collectors.groupingBy((can)->can.getTechexpertise()));
		for(String tech:techCount.keySet()) {
			System.out.println(tech+" "+techCount.get(tech).size());
		}
		System.out.println("===================");
		int maxExp=5;
		List<Candidate> yearCount=repo.getAllCandidates().stream().filter((c)->c.getYearsOfExperience()==maxExp).collect(Collectors.toList());
		for(Candidate e:yearCount) {
			System.out.println(e);
		}
	}
}