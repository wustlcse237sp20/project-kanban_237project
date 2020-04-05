package kanban;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Board {	

	static int backlogCount = 0;
	static int inprogressCount = 0;
	static int verifyCount = 0;
	static int completeCount = 0;
	static int blockedCount = 0;

	public static void main(String[] args) {
		// Each SortedMap represents a column on the board
		SortedMap<Integer, String> Backlog = new TreeMap<Integer, String>();
		SortedMap<Integer, String> InProgress = new TreeMap<Integer, String>();
		SortedMap<Integer, String> Verify = new TreeMap<Integer, String>();
		SortedMap<Integer, String> Complete = new TreeMap<Integer, String>();
		SortedMap<Integer, String> Blocked = new TreeMap<Integer, String>();


		//close leak
		Scanner task = new Scanner(System.in);

		while(true) {

			System.out.println("Enter 1 if you would like to add a task");
			System.out.println("Enter 2 if you would like to delete a task");
			System.out.println("Enter 3 if you would like to display the Kanban Board");

			int userInput = task.nextInt();

			if(userInput == 1) {
				System.out.println("Where would you like to add this task?");
				System.out.println("1 = Backlog");
				System.out.println("2 = InProgress");
				System.out.println("3 = Verify");
				System.out.println("4 = Complete");
				System.out.println("5 = Blocked");
				System.out.println("6 = Go Back");

				//close leak
				Scanner branchInput = new Scanner(System.in);
				int branch = branchInput.nextInt();

				//allows user to add tasks to the backlog
				if(branch == 1) {
					addTask(Backlog);

					displayTaskMap(Backlog, "Backlog");
				}

				//allows user to add tasks to the in progress
				else if(branch == 2) {
					addTask(InProgress);

					displayTaskMap(InProgress, "InProgress");
				}

				//allows user to add tasks to verify
				else if(branch == 3) {
					addTask(Verify);

					displayTaskMap(Verify, "Verify");
				}

				//allows user to add tasks to complete
				else if(branch == 4) {
					addTask(Complete);

					displayTaskMap(Complete, "Complete");
				}

				//allows user to add tasks to blocked
				else if(branch == 5) {
					addTask(Blocked);

					displayTaskMap(Blocked, "Blocked");
				}

				//allows user to return to the main menu
				else if(branch == 6) {
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
					displayTaskMap(Backlog, "Backlog");
					deleteTask(Backlog);
				}

				else if(branch == 2) {
					displayTaskMap(InProgress, "InProgress");
					deleteTask(InProgress);	
				}

				else if(branch == 3) {
					displayTaskMap(Verify, "Verify");
					deleteTask(Verify);			
				}

				else if(branch == 4) {
					displayTaskMap(Complete, "Complete");
					deleteTask(Complete);			
				}

				else if(branch == 5) {
					displayTaskMap(Blocked, "Blocked");
					deleteTask(Blocked);		
				}

				else if(branch == 6) {
					continue;
				}
			}
			else if(userInput == 3) {

				displayTaskMap(Backlog, "Backlog");
				displayTaskMap(InProgress, "InProgress");
				displayTaskMap(Verify, "Verify");
				displayTaskMap(Complete, "Complete");
				displayTaskMap(Blocked, "Blocked");
			}

			else {
				System.out.println("Please enter a valid number");
				continue;
			}			
		}	
	}

	
	private static void deleteTask(SortedMap<Integer, String> mapToDeleteTask) {
		System.out.println("What task number would you like to delete?");
		Scanner delete = new Scanner(System.in);
		int deleteTask = delete.nextInt();
		mapToDeleteTask.remove(deleteTask);
	}

	private static void addTask(SortedMap<Integer, String> mapToAddTask) {
		System.out.println("What task would you like to add?");
		Scanner add = new Scanner(System.in);
		String addTask = add.nextLine();
		backlogCount++;
		mapToAddTask.put(backlogCount, addTask);
	}

	private static void displayTaskMap(SortedMap<Integer, String> a, String kanbanCategoryName) {
		System.out.println("Kanban Board Category: " + kanbanCategoryName);
		for (Map.Entry<Integer, String> entry : a.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
		}
		System.out.println();
	}
}
