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
			if(getBranchName(branch) == null) {
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

			if(getBranchName(branch) == null) {
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
		while(true) {
			System.out.println("Would you like to display tasks in alphabetical order? (y/n)");
			String yesOrNo = returnUserInput();
			if(yesOrNo.equals("y")) {
				board.displayTaskMapAlphabetical(board.getBacklog(), "Backlog");
				board.displayTaskMapAlphabetical(board.getInProgress(), "InProgress");
				board.displayTaskMapAlphabetical(board.getVerify(), "Verify");
				board.displayTaskMapAlphabetical(board.getComplete(), "Complete");
				board.displayTaskMapAlphabetical(board.getBlocked(), "Blocked");
				return;
			}
			else if (yesOrNo.equals("n")) {
				board.displayTaskMap(board.getBacklog(), "Backlog");
				board.displayTaskMap(board.getInProgress(), "InProgress");
				board.displayTaskMap(board.getVerify(), "Verify");
				board.displayTaskMap(board.getComplete(), "Complete");
				board.displayTaskMap(board.getBlocked(), "Blocked");
				return;
			}
			else {
				System.out.println("Error: Invalid input.");
				continue;
			}
		}
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
		else if(branch.equals("6")) {
			menuChoice();
			return "Menu";
		}
		else {
			System.out.println("Error: please enter valid column number");
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

	public String getTaskUserWantsToMove() {
		System.out.println("Which task would you like to move? Enter task name: ");
		String taskName = returnUserInput();
		return taskName;
	}

	public String getBranchTaskMoveFrom() {
		System.out.println("Enter branch number task is currently in: ");
		listBranchOptionsToConsole();
		String branchTaskIsMovingFrom = returnUserInput();
		return branchTaskIsMovingFrom;
	}

	public String getBranchTaskMoveTo() {
		System.out.println("Which branch number would you like to move this task to?");
		listBranchOptionsToConsole();
		String branchTaskIsMovingTo = returnUserInput();
		return branchTaskIsMovingTo;
	}

	public void selectBranchToMoveTaskFromAndTo() {
		while(true) {
			String branchTaskIsMovingFrom = getBranchTaskMoveFrom();
			if(getBranchName(branchTaskIsMovingFrom) == null) {
				continue;
			}
			board.displayTaskMap(getBranch(branchTaskIsMovingFrom), getBranchName(branchTaskIsMovingFrom));	
			String taskName = getTaskUserWantsToMove();
			String branchTaskIsMovingTo = getBranchTaskMoveTo();
			if(getBranchName(branchTaskIsMovingTo) == null) {
				continue;
			}
			else {
				board.moveTask(getBranch(branchTaskIsMovingFrom), getBranch(branchTaskIsMovingTo), taskName);
				menuChoice();
			}
		}
	}

}

