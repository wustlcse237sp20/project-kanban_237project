package kanban;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Board {	
	
	static int keyCount1 = 0;
	static int keyCount2 = 0;
	static int keyCount3 = 0;
	static int keyCount4 = 0;
	static int keyCount5 = 0;
		
	public static void main(String[] args) {
		// Each SortedMap represents a column on the board
		SortedMap<Integer, String> Backlog = new TreeMap<Integer, String>();
		SortedMap<Integer, String> InProgress = new TreeMap<Integer, String>();
		SortedMap<Integer, String> Verify = new TreeMap<Integer, String>();
		SortedMap<Integer, String> Complete = new TreeMap<Integer, String>();
		SortedMap<Integer, String> Blocked = new TreeMap<Integer, String>();
		
		//Create the set for each column, to store each task
		Set BacklogSet = Backlog.entrySet();
		Set InProgressSet = InProgress.entrySet();
		Set VerifySet = Verify.entrySet();
		Set CompleteSet = Complete.entrySet();
		Set BlockedSet = Blocked.entrySet();
		
		//iterator for every set to find each task
		Iterator a = BacklogSet.iterator();
		Iterator b = InProgressSet.iterator();
		Iterator c = VerifySet.iterator();
		Iterator d = CompleteSet.iterator();
		Iterator e = BlockedSet.iterator();
		
		Scanner task = new Scanner(System.in);
		
		while(true) {
			
		System.out.println("Enter 1 if you would like to add a task");
		System.out.println("Enter 2 if you would like to delete a task");
			
		int userInput = task.nextInt();
		
		if(userInput == 1) {
			System.out.println("Where would you like to add this task?");
			System.out.println("1 = Backlog");
			System.out.println("2 = InProgress");
			System.out.println("3 = Verify");
			System.out.println("4 = Complete");
			System.out.println("5 = Blocked");
			System.out.println("6 = Go Back");
			
			Scanner branchInput = new Scanner(System.in);
			
			int branch = branchInput.nextInt();
			
			//allows user to add tasks to the backlog
			if(branch == 1) {
				System.out.println("What task would you like to add?");
				Scanner add = new Scanner(System.in);
				String addTask = add.nextLine();
				
				keyCount1++;
				
				Backlog.put(keyCount1, addTask);
				//displayBackLog(BacklogSet, a);
				
				for (Map.Entry<Integer, String> entry : Backlog.entrySet()) {
				     System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
				}
			}
			
			//allows user to add tasks to the in progress
			else if(branch == 2) {
				System.out.println("What task would you like to add?");
				Scanner add = new Scanner(System.in);
				String addTask = add.nextLine();
				
				keyCount2++;
				
				InProgress.put(keyCount2, addTask);
				
				for (Map.Entry<Integer, String> entry : InProgress.entrySet()) {
				     System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
				}
			}
			
			//allows user to add tasks to verify
			else if(branch == 3) {
				System.out.println("What task would you like to add?");
				Scanner add = new Scanner(System.in);
				String addTask = add.nextLine();
				
				keyCount3++;
				
				Verify.put(keyCount3, addTask);
				
				for (Map.Entry<Integer, String> entry : Verify.entrySet()) {
				     System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
				}
			}
			
			//allows user to add tasks to complete
			else if(branch == 4) {
				System.out.println("What task would you like to add?");
				Scanner add = new Scanner(System.in);
				String addTask = add.nextLine();
				
				keyCount4++;
				
				Complete.put(keyCount4, addTask);
				
				for (Map.Entry<Integer, String> entry : Complete.entrySet()) {
				     System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
				}
			}
			
			//allows user to add tasks to blocked
			else if(branch == 5) {
				System.out.println("What task would you like to add?");
				Scanner add = new Scanner(System.in);
				String addTask = add.nextLine();
				
				keyCount5++;
				
				Blocked.put(keyCount5, addTask);
				
				for (Map.Entry<Integer, String> entry : Blocked.entrySet()) {
				     System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
				}
			}
			
			//allows user to return to the main menu
			else if(branch == 6) {
				//return to option of add/delete
				continue;
			}
			
		}
		
		else if(userInput == 2) {
			System.out.println("Where would you like to delete the task?");
			System.out.println("1 = Backlog");
			System.out.println("2 = InProgress");
			System.out.println("3 = Verify");
			System.out.println("4 = Complete");
			System.out.println("5 = Blocked");
			System.out.println("6 = Go Back");
						
			Scanner branchInput = new Scanner(System.in);
			
			int branch = branchInput.nextInt();
			
			if(branch == 1) {
				//displayBackLog(BacklogSet, a);
				for (Map.Entry<Integer, String> entry : Backlog.entrySet()) {
				     System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
				}
				System.out.println("What task number would you like to delete?");
				Scanner delete = new Scanner(System.in);
				int deleteTask = delete.nextInt();
				
				Backlog.remove(deleteTask);
				
				keyCount1--;
				
			}
			
			else if(branch == 2) {
				//displayInProgress(InProgressSet, b);
				for (Map.Entry<Integer, String> entry : InProgress.entrySet()) {
				     System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
				}
				System.out.println("What task number would you like to delete?");
				Scanner delete = new Scanner(System.in);
				int deleteTask = delete.nextInt();
				
				Backlog.remove(deleteTask);
				
				keyCount2--;
			}
			
			else if(branch == 3) {
				//displayVerify(VerifySet, c);
				for (Map.Entry<Integer, String> entry : Verify.entrySet()) {
				     System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
				}
				System.out.println("What task number would you like to delete?");
				Scanner delete = new Scanner(System.in);
				int deleteTask = delete.nextInt();
				
				Backlog.remove(deleteTask);
				
				keyCount3--;
			}
			
			else if(branch == 4) {
				//displayComplete(CompleteSet, d);
				for (Map.Entry<Integer, String> entry : Complete.entrySet()) {
				     System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
				}
				System.out.println("What task number would you like to delete?");
				Scanner delete = new Scanner(System.in);
				int deleteTask = delete.nextInt();
				
				Backlog.remove(deleteTask);
				
				keyCount4--;
			}
			
			else if(branch == 5) {
				//displayBlocked(BlockedSet, e);
				for (Map.Entry<Integer, String> entry : Blocked.entrySet()) {
				     System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
				}
				System.out.println("What task number would you like to delete?");
				Scanner delete = new Scanner(System.in);
				int deleteTask = delete.nextInt();
				
				Backlog.remove(deleteTask);
				
				keyCount5--;
			}
			
			else if(branch == 6) {
				continue;
			}
		}
		
		else {
			System.out.println("Please enter a valid number");
			continue;
			
		}			
	}	

		
}
		
		 // Display Backlog column
		static void displayBackLog(Set Backlog, Iterator a) {		
		while (a.hasNext()) {
			Map.Entry<Integer, String> me = (Map.Entry<Integer, String>)a.next();
		      System.out.print("Key is: "+me.getKey() + " & ");
		      System.out.println("Value is: "+me.getValue());
		}
			
		
	}
		//Display In Progress Column
		static void displayInProgress(Set InProgressSet, Iterator b) {		
			while (b.hasNext()) {
				Map.Entry<Integer, String> me = (Map.Entry<Integer, String>)b.next();
			      System.out.print("Key is: "+me.getKey() + " & ");
			      System.out.println("Value is: "+me.getValue());
			}
			
		}
		
		//Printing Verify Column
		static void displayVerify(Set BacklogSet, Iterator c) {		
			while (c.hasNext()) {
				Map.Entry<Integer, String> me = (Map.Entry<Integer, String>)c.next();
			      System.out.print("Key is: "+me.getKey() + " & ");
			      System.out.println("Value is: "+me.getValue());
			}
			
		}
		
		//Display Complete Column
		static void displayComplete(Set CompleteSet, Iterator d) {		
			while (d.hasNext()) {
				Map.Entry<Integer, String> me = (Map.Entry<Integer, String>)d.next();
			      System.out.print("Key is: "+me.getKey() + " & ");
			      System.out.println("Value is: "+me.getValue());
			}
			
		}
		
		//Display Blocked Column
		static void displayBlocked(Set BlockedSet, Iterator e) {		
			while (e.hasNext()) {
				Map.Entry<Integer, String> me = (Map.Entry<Integer, String>)e.next();
			      System.out.print("Key is: "+me.getKey() + " & ");
			      System.out.println("Value is: "+me.getValue());
			}
			
		}

}
