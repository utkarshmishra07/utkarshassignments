/**
 * 
 */
package assignment2;
import java.util.Scanner;
/**
 * @author utkarsh.mishra1
 *
 */
abstract class Account{
	
	protected String acc_holder_name;
	protected int acc_num;
	protected double balance;
	Account(){}
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
	public abstract double withdraw(int amount, double balance);
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
	public double withdraw(int amount, double balance){
	return amount;
	}

}
class CurrentAccount extends Account{
	CurrentAccount(String acc_holder_name,int acc_num, double balance){
		super(acc_holder_name, acc_num, balance);
	}
	public double withdraw(int amount, double balance){
		int overdraftlimit=5000;
		boolean a=false;
		if(amount<=(this.balance+overdraftlimit)) {
			balance=balance-amount;
			a=false;
			System.out.print("\nOverdraft limit reached: "+a);
		}else
		{	a=true;
			System.out.print("\nOverdraft limit reached: "+a);
		}return balance;
	}
}
class SavingsAccount extends Account{
	SavingsAccount(String acc_holder_name, int acc_num, double balance){
		super(acc_holder_name, acc_num, balance);
	}		
	public double withdraw(int amount, double balance){
	if(amount<=(this.balance-500))
			balance=balance-amount;
		else
			System.out.println("\n insufficient balance\n");
		return balance;
	}
}
public class FourPointTwo{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to CICIC Bank!!\nCreate New account by entering following details: \n ");
		System.out.println("1. Account holder name 2.Balance");		
		Account s=new Accounts(sc.next(),(int)(Math.random()*((100000000-10000000)+1))+10000000,sc.nextDouble());
		System.out.println("Account with no. "+ s.getAccNum()+" created with balance: "+s.getBalance()+"\n");	
		System.out.println("Select Account type \n 1. Savings 2.Current");
		int choice=sc.nextInt();
		if(choice==1){
			Account s1=new SavingsAccount(s.getAccName(), s.getAccNum(), s.getBalance());
			do{
			System.out.println("\n 1. Withdraw 2. Deposit 3. Exit");
			int op=sc.nextInt();
			switch(op){
				case 1:
					System.out.println("enter the amount to withdraw");
					System.out.print(s1.withdraw(sc.nextInt(), s.getBalance()));
				break;
				case 2:
					System.out.println("enter the amount to deposit");
					System.out.print(s.deposit(sc.nextInt()));		
				break;
				case 3:
					System.exit(0);
				default:
					System.out.println("invalid operation");
			}
			}while(true);
		}
		
		else if(choice==2){
			Account s2=new CurrentAccount(s.getAccName(),s.getAccNum(),s.getBalance());
			do{
			System.out.println("\n 1. Withdraw 2. Deposit 3. Exit");
			int op=sc.nextInt();
			switch(op){
				case 1:
					System.out.println("enter the amount to withdraw");
					System.out.print(s2.withdraw(sc.nextInt(),s2.getBalance()));
				break;
				case 2:
					System.out.println("enter the amount to deposit");
					System.out.print(s2.deposit(sc.nextInt()));		
				break;
				case 3:
					System.exit(0);
				default:
					System.out.println("invalid operation");
			}
			}while(true);
		
		}
	}
}