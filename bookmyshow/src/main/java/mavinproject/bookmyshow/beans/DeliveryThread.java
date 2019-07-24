package mavinproject.bookmyshow.beans;
enum Food 
{ 
   ACCEPTED, PREPARING, READY, DISPATCHED, DELIVERED;
} 
class Delivery{
	
	public synchronized void Accepted()throws InterruptedException{

		Food arr[] = Food.values();       
        for (Food Foo : arr) 
        {
        	System.out.println("Order "+ Foo); 
          	Thread.sleep(3000);
        }
	}
}

class DApp extends Thread{
	Delivery d=new Delivery();
	public void run(){
		try {
		d.Accepted();
		
		}catch(InterruptedException e){}
	}	
}


public class DeliveryThread{
	public static void main(String args[]){
		DApp dapp=new DApp();
		dapp.start();
		
	}
}
/*	public synchronized void Preparing()throws InterruptedException{
//		wait();
		if(i==1) {
		System.out.println("Order"+Food.PREPARING);
//		Thread.sleep(6000);
		i=2;
//		notify();
		}
		
	}
	public synchronized void Ready()throws InterruptedException{
//		wait();
		if(i==2)
		System.out.println("Order"+Food.READY);
//		Thread.sleep(6000);
		i=3;
//		notify();
	}
	public synchronized void Dispatched()throws InterruptedException{
//		wait();
		if(i==3)
		System.out.println("Order"+Food.DISPATCHED);
//		Thread.sleep(6000);
		i=4;
//		notify();
	}
	public synchronized void Delievered()throws InterruptedException{
//		wait();
		if(i==4)
		System.out.println("Order"+Food.DELIVERED);
	}	*/

/*
class DApp extends Thread{
	Delivery d=new Delivery();
	public void run(){
		try {
		d.Accepted();
		
		}catch(InterruptedException e){}
	}	
}


public class DeliveryThread{
	public static void main(String args[]){
		DApp dapp=new DApp();
		dapp.start();
		
	}
}*/