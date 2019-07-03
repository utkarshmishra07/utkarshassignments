import java.util.Scanner;
class p12{
void hasTeen(String s, int n)
{
for(int i=0;i<15;i++)
{
System.out.print(s);
}
}
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.print("Enter a string: ");
String s=sc.nextLine();
System.out.print("Enter a number: ");
int n=sc.nextInt();
p12 m=new p12();
m.hasTeen(s, n);
}
}
