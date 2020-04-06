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
					addTask(Backlog, backlogCount);
					displayTaskMap(Backlog, "Backlog");
				}

				//allows user to add tasks to the in progress
				else if(branch == 2) {
					addTask(InProgress, inprogressCount);
					displayTaskMap(InProgress, "InProgress");
				}

				//allows user to add tasks to verify
				else if(branch == 3) {
					addTask(Verify, verifyCount);
					displayTaskMap(Verify, "Verify");
				}

				//allows user to add tasks to complete
				else if(branch == 4) {
					addTask(Complete, completeCount);					
					displayTaskMap(Complete, "Complete");
				}

				//allows user to add tasks to blocked
				else if(branch == 5) {
					addTask(Blocked, blockedCount);
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

	/**
	 * @param mapToDeleteTask the map that the user is deleting a task from
	 * @return void
	 */
	private static void deleteTask(SortedMap<Integer, String> mapToDeleteTask) {
		System.out.println("What task number would you like to delete?");
		Scanner delete = new Scanner(System.in);
		int deleteTask = delete.nextInt();
		mapToDeleteTask.remove(deleteTask);
		
	}

	/**
	 * @param mapToAddTask the map that the user is adding a task to
	 * @param taskCounter the index of in the map that the task is being added to
	 * @return void
	 */
	private static void addTask(SortedMap<Integer, String> mapToAddTask, int taskCounter) {
		System.out.println("What task would you like to add?");
		Scanner add = new Scanner(System.in);
		String addTask = add.nextLine();
		taskCounter++;
		mapToAddTask.put(taskCounter, addTask);

	}

	/**
	 * @param mapToDisplay the map that is being printed 
	 * @param kanbanCategoryName the category of the Kanban board that the map represents
	 * @return void
	 */
	private static void displayTaskMap(SortedMap<Integer, String> mapToDisplay, String kanbanCategoryName) {
		System.out.println("Kanban Board Category: " + kanbanCategoryName);
		for (Map.Entry<Integer, String> entry : mapToDisplay.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
		}
		System.out.println();
	}
}
