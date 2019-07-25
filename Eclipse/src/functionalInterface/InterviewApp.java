/**
 * 
 */
package functionalInterface;
import java.util.List;
import java.util.Scanner;
/**
 * @author utkarsh.mishra1
 *
 */
public class InterviewApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to App");
		InterviewRepository repository=new InterviewRepository();

		do {
			System.out.println("1.Add Candidate\n2.Remove\n3.View Candidate\n4.View All\n5.Exit");
			int choice=sc.nextInt();
			switch(choice) {
			case 1: System.out.println("Enter name, Technical Expertise, City and Years of Experience");
			repository.addCandidates(new Candidate(sc.next(),sc.next(),sc.next(), sc.nextInt()));
			System.out.println("candidate added");
			break;
			case 2: System.out.println("enter the index");
			repository.deleteCandidate(sc.nextInt());
			System.out.println("Deleted");
			break;
			case 3: System.out.println("enter the index");
			Candidate c1=repository.getCandidate(sc.nextInt());
			System.out.println(c1);
			break;
			case 4: System.out.println("List of Candidates");
			List<Candidate> cans=repository.getAllCandidates();
			cans.forEach((c)->System.out.println(c));
			break;
			case 5: System.out.println("Thank You");
			System.exit(0);
			break;
			default : System.out.println("Invalid choice");
			}
	
		}while(true);

	}

}
