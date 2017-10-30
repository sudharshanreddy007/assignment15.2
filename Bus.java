package bus;

import java.util.Scanner;
/*
 Bus reservation class extended the Thread class
*/
public class Bus extends Thread {

/*
 Run method used by thread 
*/
public void run()
{
//Invoking the run() method from main thread, the run() method goes 
//onto the current call stack rather than at the beginning of a new call stack.
//declared required variables
	int noOfTickets;//int will represent the number
	String []names;
//string is basically an object that represents sequence of char values. 
//An array of characters works same as java string.
	Scanner sc = new Scanner(System.in);
//Invoking the run() method from main thread, the run() method goes 
//onto the current call stack rather than at the beginning of a new call stack.
//synchronized block
synchronized(this){
//asking for number of tickets
	System.out.print("Enter the No of tickets you want to book : ");
	noOfTickets = sc.nextInt();
//initialize the name array
//that will store the names of the passenger
	names=new String[noOfTickets];
//running the loop for passenger name
	for(int i=0;i<noOfTickets;i++)
	{
		System.out.print("Name of "+(i+1)+" passenger : ");
		names[i]=sc.next();//position in the array
	}
	//printing the report
	System.out.println(Thread.currentThread().getName() + " has booked "+noOfTickets+" Ticket(s).");
	for(int i=0;i<noOfTickets;i++)
	{
		System.out.println((i+1)+" Passenger : "+names[i]);
	}
	}
	}
//main method for executing the above program
public static void main(String[] args) {

System.out.println("\n***Welcome to Online Bus reservation***\n\n");
//created the thread 
Bus thread  = new Bus();
//name the thread 
thread.setName("Thread 1");
//started the thread
thread.start();
}
}//end of class
