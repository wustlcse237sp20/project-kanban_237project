package kanban;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.SortedMap;

public class Menu {
	
	Board board = new Board();

	public void menuChoice() {

		while(true) {
			displayMenuOptions();
			
			String userInput = returnUserInput();

			if(userInput.equals("1")){
				selectBranchToAddTo();
			}
			else if(userInput.equals("2")) {
				selectBranchToDeleteFrom();
			}
			else if(userInput.equals("3")) {
				displayATask();
			}
			else if(userInput.equals("4")) {
				selectBranchToMoveTaskFromAndTo();
			}
			else {
				System.out.println("Enter a valid number: ");
				continue;
			}
		}
	}

	public void selectBranchToAddTo() {
		while(true) {
			System.out.println("Where would you like to add this task?");
			listBranchOptionsToConsole();

			String branch = returnUserInput();

			if(branch == "6") {
				menuChoice();
			}

			else if(getBranchName(branch) == null) {
				System.out.println("Error: please enter valid column number");
				continue;
			}

			else {
				board.displayTaskMap(getBranch(branch), getBranchName(branch));
				board.addTask(getBranch(branch), System.currentTimeMillis());
				menuChoice();
			}
		}
	}	


	public void selectBranchToDeleteFrom() {
		while(true) {
			System.out.println("Where would you like to delete the task?");
			listBranchOptionsToConsole();

			String branch = returnUserInput();

			if(branch == "6") {
				menuChoice();
			}

			else if(getBranchName(branch) == null) {
				System.out.println("Error: please enter valid column number");
				continue;
			}

			else {
				board.displayTaskMap(getBranch(branch), getBranchName(branch));
				board.deleteTask(getBranch(branch));
				menuChoice();
			}
		}
	}


	public void displayATask() {
		board.displayTaskMap(board.getBacklog(), "Backlog");
		board.displayTaskMap(board.getInProgress(), "InProgress");
		board.displayTaskMap(board.getVerify(), "Verify");
		board.displayTaskMap(board.getComplete(), "Complete");
		board.displayTaskMap(board.getBlocked(), "Blocked");	
	}
	

	public SortedMap<Long, String> getBranch(String branch) {

		if(branch.equals("1")) {
			return board.getBacklog();			
		}
		else if(branch.equals("2")) {
			return board.getInProgress();
		}
		else if(branch.equals("3")) {
			return board.getVerify();
		}
		else if(branch.equals("4")) {
			return board.getComplete();
		}
		else if(branch.equals("5")) {
			return board.getBlocked();
		}
		else {
			return null;
		}
	}

	public String getBranchName(String branch) {

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
	
	public void displayMenuOptions() {
		System.out.println("Enter 1 if you would like to add a task");
		System.out.println("Enter 2 if you would like to delete a task");
		System.out.println("Enter 3 if you would like to display the Kanban Board");
		System.out.println("Enter 4 if you would like to move a task");
	}
	
	public void listBranchOptionsToConsole() {
		System.out.println("1 = Backlog");
		System.out.println("2 = InProgress");
		System.out.println("3 = Verify");
		System.out.println("4 = Complete");
		System.out.println("5 = Blocked");
		System.out.println("6 = Go Back");
	}
	
	public String returnUserInput() {
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();
		return userInput;
	}


	public void selectBranchToMoveTaskFromAndTo() {

		while(true) {
			System.out.println("Where would you like to move this task from?");
			listBranchOptionsToConsole();

			String branchTaskIsMovingFrom = returnUserInput();

			board.displayTaskMap(getBranch(branchTaskIsMovingFrom), getBranchName(branchTaskIsMovingFrom));
			
			System.out.println("Which task would you like to move?");
			System.out.println("Enter a valid key: ");

			String taskName = returnUserInput();

			System.out.println("Where would you like to move this task to?");
			listBranchOptionsToConsole();

			String branchTaskIsMovingTo = returnUserInput();

			if(branchTaskIsMovingFrom.equals("6")|| branchTaskIsMovingTo.equals("6")) {
				menuChoice();
			}

			else if(getBranchName(branchTaskIsMovingTo) == null || getBranchName(branchTaskIsMovingFrom) == null) {
				System.out.println("Error: please enter valid column number");
				continue;
			}
			else {
				board.moveTask(getBranch(branchTaskIsMovingFrom), getBranch(branchTaskIsMovingTo), taskName);
				menuChoice();
			}
		}

	}
}

