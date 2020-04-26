package kanban;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.SortedMap;

public class Menu {

	static void menuChoice() {
		
		while(true) {
			System.out.println("Enter 1 if you would like to add a task");
			System.out.println("Enter 2 if you would like to delete a task");
			System.out.println("Enter 3 if you would like to display the Kanban Board");
			System.out.println("Enter 4 if you would like to move a task");

			Scanner task = new Scanner(System.in);
			int userInput = task.nextInt();

			if(userInput == 1){
				addATask();
			}
			else if(userInput == 2) {
				deleteATask();
			}
			else if(userInput == 3) {
				displayATask();
			}
			else if(userInput == 4) {
				moveATask();
			}
			else {
				System.out.println("Enter a valid number: ");
				continue;
			}
		}
	}

	static void addATask() {
		while(true) {
			System.out.println("Where would you like to add this task?");
			System.out.println("1 = Backlog");
			System.out.println("2 = InProgress");
			System.out.println("3 = Verify");
			System.out.println("4 = Complete");
			System.out.println("5 = Blocked");
			System.out.println("6 = Go Back");

			//close leak
			Scanner branchInput = new Scanner(System.in);
			
			try {
				int branch = branchInput.nextInt();
				
				if(branch == 6) {
					menuChoice();
				}
				
				else if(branch < 1 || branch > 6) {
					continue;
				}
				
				else {
					Board.displayTaskMap(getBranch(branch), getBranchName(branch));
					Board.addTask(getBranch(branch), System.currentTimeMillis());
				}
				}
				catch(InputMismatchException e) {
					System.out.println("Please add a valid branch number");
					continue;
				}
	  }	
	}

	static void deleteATask() {
		while(true) {
			System.out.println("Where would you like to delete the task?");
			System.out.println("1 = Backlog");
			System.out.println("2 = InProgress");
			System.out.println("3 = Verify");
			System.out.println("4 = Complete");
			System.out.println("5 = Blocked");
			System.out.println("6 = Go Back");

			Scanner branchInput = new Scanner(System.in);
			try {
			int branch = branchInput.nextInt();
			
			if(branch == 6) {
				menuChoice();
			}
			
			else if(branch < 1 || branch > 6) {
				continue;
			}
			
			else {
				Board.displayTaskMap(getBranch(branch), getBranchName(branch));
				Board.deleteTask(getBranch(branch));
			}
			}
			catch(InputMismatchException e) {
				System.out.println("Please add a valid branch number");
				continue;
			}
		}
	}

	static void displayATask() {
		Board.displayTaskMap(Board.Backlog, "Backlog");
		Board.displayTaskMap(Board.InProgress, "InProgress");
		Board.displayTaskMap(Board.Verify, "Verify");
		Board.displayTaskMap(Board.Complete, "Complete");
		Board.displayTaskMap(Board.Blocked, "Blocked");	
	}

	static SortedMap<Long, String> getBranch(int branch) {
	
		if(branch == 1) {
			return Board.Backlog;			
		}
		else if(branch == 2) {
			return Board.InProgress;
		}
		else if(branch == 3) {
			return Board.Verify;
		}
		else if(branch == 4) {
			return Board.Complete;
		}
		else if(branch == 5) {
			return Board.Blocked;
		}
		else {
			return null;
		}
		
	}
	
	static String getBranchName(int branch) {
		
		if(branch == 1) {
			return "Backlog";			
		}
		else if(branch == 2) {
			return "InProgress";
		}
		else if(branch == 3) {
			return "Verify";
		}
		else if(branch == 4) {
			return "Complete";
		}
		else if(branch == 5) {
			return "Blocked";
		}
		else {
			return "null";
		}
		
	}
	
	
	static void moveATask() {
	
		while(true) {
			
		System.out.println("Where would you like to move this task from?");
		System.out.println("1 = Backlog");
		System.out.println("2 = InProgress");
		System.out.println("3 = Verify");
		System.out.println("4 = Complete");
		System.out.println("5 = Blocked");
		System.out.println("6 = Go Back");

		//TaskNumber
		Scanner whichBranch = new Scanner(System.in);
		try {
			int branchTaskIsMovingFrom = whichBranch.nextInt();
			
			if(branchTaskIsMovingFrom == 6) {
				menuChoice();
			}
			
			else if(getBranchName(branchTaskIsMovingFrom) == null) {
				continue;
			}
			

		System.out.println("Which task would you like to move?");
		System.out.println("Enter a valid key: ");

		//close leak
		Scanner whichTask = new Scanner(System.in);
		String taskToBeMoved = whichTask.nextLine();
		
		System.out.println("Where would you like to move this task to?");
		System.out.println("1 = Backlog");
		System.out.println("2 = InProgress");
		System.out.println("3 = Verify");
		System.out.println("4 = Complete");
		System.out.println("5 = Blocked");
		System.out.println("6 = Go Back");
		
		Scanner toBranch = new Scanner(System.in);
			
			int branchTaskIsMovingTo = toBranch.nextInt();
			
			if(branchTaskIsMovingTo == 6) {
				menuChoice();
			}
			
			else if(getBranchName(branchTaskIsMovingTo) == null) {
				continue;
			}
			else {
				Board.moveTask(getBranch(branchTaskIsMovingFrom), getBranch(branchTaskIsMovingTo), Board.taskName);
			}
		}
			catch(InputMismatchException e) {
				System.out.println("Please add a valid branch number");
				continue;
			}
		}
	}





}

