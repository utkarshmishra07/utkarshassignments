/**
 * 
 */
package assignment;
import java.util.Scanner;
/**
 * @author utkarsh.mishra1
 *
 */
public class FourPointOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to CICIC Bank!!\nCreate New account by entering following details: \n ");

			System.out.println("1. Account holder name 2.Balance");
			Account s1=new Accounts(sc.next(),(int)(Math.random()*((100000000-10000000)+1))+10000000,sc.nextDouble());
			System.out.print(s1.toString()); //for toString()
			//System.out.println("Account with no. "+ s1.getAccNum()+" created with balance: "+s1.getBalance()+"\n");			
			do{
			System.out.println("\n 1. Withdraw 2. Deposit 3. Exit");
			int op=sc.nextInt();
			switch(op){
				case 1:
					System.out.println("enter the amount to withdraw");
					System.out.print(s1.withdraw(sc.nextInt()));
				break;
				case 2:
					System.out.println("enter the amount to deposit");
					System.out.print(s1.deposit(sc.nextInt()));		
				break;
				case 3:
					System.exit(0);
				default:
					System.out.println("invalid operation");
			}
			}while(true);
			
	}

}

abstract class Account{
	private String acc_holder_name;
	private int acc_num;
	protected double balance;
	Account(String acc_holder_name, int acc_num, double balance){
		this.acc_holder_name=acc_holder_name;
		this.acc_num=acc_num;
		this.balance=balance;
	}
	public double getBalance(){
		return balance;	
	}
	public int getAccNum(){
		return acc_num;	
	}
	public String getAccName() {
		return acc_holder_name;
	} 
	@Override
	public String toString() {
		return "Account [acc_holder_name=" + acc_holder_name + ", acc_num=" + acc_num + ", balance=" + balance + "]";
	}
	public abstract double withdraw(int amount);
	public double deposit(double amount){
		if((amount%100)==0)
			balance=balance+amount;
		else
			System.out.print("problem with deposit\n");
		return balance;
		}
	
}

class Accounts extends Account{
	Accounts(String acc_holder_name, int acc_num, double balance){
		super(acc_holder_name, acc_num, balance);
	}
	public double withdraw(int amount){
		if(amount<=(this.balance-500))
			balance=balance-amount;
		else
			System.out.print("\ninsufficient balance\n");
		return balance;
	}
}