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
				selectBranchToAddTo();
			}
			else if(userInput == 2) {
				selectBranchToDeleteFrom();
			}
			else if(userInput == 3) {
				displayATask();
			}
			else if(userInput == 4) {
				selectBranchToMoveTaskFromAndTo();
			}
			else {
				System.out.println("Enter a valid number: ");
				continue;
			}
		}
	}

	static void selectBranchToAddTo() {
		while(true) {
			System.out.println("Where would you like to add this task?");
			listBranchOptionsToConsole();
			
			//close leak
			Scanner branchInput = new Scanner(System.in);

			String branch = branchInput.nextLine();

			if(branch == "6") {
				menuChoice();
			}

			else if(getBranchName(branch) == null) {
				continue;
			}

			else {
				Board.displayTaskMap(getBranch(branch), getBranchName(branch));
				Board.addTask(getBranch(branch), System.currentTimeMillis());
				menuChoice();
			}
		}
	}	


	static void selectBranchToDeleteFrom() {
		while(true) {
			System.out.println("Where would you like to delete the task?");
			listBranchOptionsToConsole();

			Scanner branchInput = new Scanner(System.in);

			String branch = branchInput.nextLine();

			if(branch == "6") {
				menuChoice();
			}

			else if(getBranchName(branch) == null) {
				continue;
			}

			else {
				Board.displayTaskMap(getBranch(branch), getBranchName(branch));
				Board.deleteTask(getBranch(branch));
				menuChoice();
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

	static SortedMap<Long, String> getBranch(String branch) {

		if(branch.equals("1")) {
			return Board.Backlog;			
		}
		else if(branch.equals("2")) {
			return Board.InProgress;
		}
		else if(branch.equals("3")) {
			return Board.Verify;
		}
		else if(branch.equals("4")) {
			return Board.Complete;
		}
		else if(branch.equals("5")) {
			return Board.Blocked;
		}
		else {
			return null;
		}

	}

	static String getBranchName(String branch) {

		if(branch.equals("1")) {
			return "Backlog";			
		}
		else if(branch.equals("2")) {
			return "InProgress";
		}
		else if(branch.equals("3")) {
			return "Verify";
		}
		else if(branch.equals("4")) {
			return "Complete";
		}
		else if(branch.equals("5")) {
			return "Blocked";
		}
		else {
			return null;
		}

	}
	
	static void listBranchOptionsToConsole() {
		System.out.println("1 = Backlog");
		System.out.println("2 = InProgress");
		System.out.println("3 = Verify");
		System.out.println("4 = Complete");
		System.out.println("5 = Blocked");
		System.out.println("6 = Go Back");
	}


	static void selectBranchToMoveTaskFromAndTo() {

		while(true) {
			//TaskNumber
			Scanner whichBranch = new Scanner(System.in);
			Scanner whichTask = new Scanner(System.in);
			Scanner toBranch = new Scanner(System.in);

			System.out.println("Where would you like to move this task from?");
			listBranchOptionsToConsole();

			String branchTaskIsMovingFrom = whichBranch.nextLine();

			System.out.println("Which task would you like to move?");
			System.out.println("Enter a valid key: ");

			String taskName = whichTask.nextLine();

			System.out.println("Where would you like to move this task to?");
			listBranchOptionsToConsole();

			String branchTaskIsMovingTo = toBranch.nextLine();

			if(branchTaskIsMovingFrom.equals("6")|| branchTaskIsMovingTo.equals("6")) {
				menuChoice();
			}

			else if(getBranchName(branchTaskIsMovingTo) == null || getBranchName(branchTaskIsMovingFrom) == null) {
				System.out.println("Error: please enter valid column names");
				continue;
			}
			else {
				Board.moveTask(getBranch(branchTaskIsMovingFrom), getBranch(branchTaskIsMovingTo), taskName);
				menuChoice();
			}
		}

	}
}

