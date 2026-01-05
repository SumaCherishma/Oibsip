import java.util.Scanner;
import java.util.ArrayList;

class Customer{
	String User_ID;
	String PIN;
	double Balance;
	ArrayList<String> transactions;
	
	Customer(String User_ID,String PIN,double Balance){
		this.User_ID=User_ID;
		this.PIN=PIN;
		this.Balance=Balance;
		this.transactions= new ArrayList<>();
	}
}

public class ATMinterface {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Customer user = new Customer("LILY@1","1234",1000000);
		Customer user2 = new Customer("ROSE@2","5678",200000);
		System.out.println("Enter User_ID:");
		String u = sc.nextLine();
		System.out.println("Enter PIN");
		String p = sc.nextLine();
		
		Customer currentUser = null;
		
		if(u.equals(user.User_ID) && p.equals(user.PIN)) {
			currentUser = user;
		}else if(u.equals(user2.User_ID) && p.equals(user2.PIN)) {
			currentUser = user2;
		}else {
			System.out.println("Invalid User Id or Pin");
			return;
		}
		System.out.println("\n Logged in Successfully");
		
		while(true) {
		System.out.println("\n1.Transaction History \n2.Withdraw \n3.Deposit \n4.Transfer \n5.Quit");
		System.out.print("Enter Your choice:");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("\nTransaction History:");
			if(currentUser.transactions.isEmpty()) {
				System.out.println("No transactions History yet");
			}else {
				for(String t : currentUser.transactions) {
					System.out.println(t);
				}
			}
			break;
		case 2:
			System.out.println("Enter the ammount to Withdraw:");
			double w = sc.nextDouble();
			if(w <= 0) {
				System.out.println("Invalid amount");
			}else if(w <= currentUser.Balance) {
				currentUser.Balance -= w;
				currentUser.transactions.add("withdrawal:"+w);
				System.out.println("Withdrawal succeeful");
			}else {
				System.out.println("Insufficient balance");
			}
			break;
			
		case 3:
			System.out.println("Enter amount to deposit:");
			double d = sc.nextInt();
			if(d>0) {
				currentUser.Balance += d;
				currentUser.transactions.add("deposited:"+d);
				System.out.println("Deposited successfully:");
			}else {
				System.out.println("Invalid deposit:");
			}
			break;
			
		case 4:
			System.out.println("Enter receiver User Id:");
			sc.nextLine();
			String receiverId = sc.nextLine();
			Customer receiver = null;
			if(receiverId.equals(user.User_ID)) {
				receiver = user;
			}else if(receiverId.equals(user2.User_ID)) {
				receiver = user2;
			}if(receiver == null || receiver == currentUser) {
				System.out.println("Invalid Receiver");
				break;
			}
			
			System.out.print("Enter amount to Transfer:");
			double amt = sc.nextDouble();
			
			if(amt > 0 && amt<= currentUser.Balance) {
				currentUser.Balance -= amt;
				receiver.Balance += amt;
				
				currentUser.transactions.add("Transferred" + amt + "to" + receiver.User_ID);
				receiver.transactions.add("Transferred" + amt + "to" + currentUser.User_ID);
				System.out.println("Transferred Successfully.");
			}
			else {
				System.out.println("Invalid Or Insufficient balance");
			}
			break;
				
		case 5:
			System.out.println("Thank you for using the ATM.");
			return;
			
		default:
			System.out.println("Invalid option.");
		}
		System.out.println("Current Balance:" + currentUser.Balance);
		}
	}

}
