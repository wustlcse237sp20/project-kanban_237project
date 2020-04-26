package kanban;

import java.util.Scanner;

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
			int branch = branchInput.nextInt();

			//allows user to add tasks to the backlog
			if(branch == 1) {
				Board.addTask(Board.Backlog, System.currentTimeMillis());
				Board.displayTaskMap(Board.Backlog, "Backlog");
			}

			//allows user to add tasks to the in progress
			else if(branch == 2) {
				Board.addTask(Board.InProgress, System.currentTimeMillis());
				Board.displayTaskMap(Board.InProgress, "InProgress");
			}

			//allows user to add tasks to verify
			else if(branch == 3) {
				Board.addTask(Board.Verify, System.currentTimeMillis());
				Board.displayTaskMap(Board.Verify, "Verify");
			}

			//allows user to add tasks to complete
			else if(branch == 4) {
				Board.addTask(Board.Complete, System.currentTimeMillis());					
				Board.displayTaskMap(Board.Complete, "Complete");
			}

			//allows user to add tasks to blocked
			else if(branch == 5) {
				Board.addTask(Board.Blocked, System.currentTimeMillis());
				Board.displayTaskMap(Board.Blocked, "Blocked");
			}

			//allows user to return to the main menu
			else if(branch == 6) {
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

			int branch = branchInput.nextInt();

			if(branch == 1) {
				Board.displayTaskMap(Board.Backlog, "Backlog");
				Board.deleteTask(Board.Backlog);
			}

			else if(branch == 2) {
				Board.displayTaskMap(Board.InProgress, "InProgress");
				Board.deleteTask(Board.InProgress);	
			}

			else if(branch == 3) {
				Board.displayTaskMap(Board.Verify, "Verify");
				Board.deleteTask(Board.Verify);			
			}

			else if(branch == 4) {
				Board.displayTaskMap(Board.Complete, "Complete");
				Board.deleteTask(Board.Complete);			
			}

			else if(branch == 5) {
				Board.displayTaskMap(Board.Blocked, "Blocked");
				Board.deleteTask(Board.Blocked);		
			}

			else if(branch == 6) {
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

	static void moveATask() {

		System.out.println("Where would you like to move this task from?");
		System.out.println("1 = Backlog");
		System.out.println("2 = InProgress");
		System.out.println("3 = Verify");
		System.out.println("4 = Complete");
		System.out.println("5 = Blocked");
		System.out.println("6 = Go Back");

		//TaskNumber
		Scanner whichTask = new Scanner(System.in);
		int taskNumber = whichTask.nextInt();

		System.out.println("Which task would you like to move?");
		System.out.println("Enter a valid key: ");

		//close leak
		Scanner branchInput = new Scanner(System.in);
		int branchTaskIsMovingFrom = branchInput.nextInt();

		System.out.println("Where would you like to move this task to?");
		System.out.println("1 = Backlog");
		System.out.println("2 = InProgress");
		System.out.println("3 = Verify");
		System.out.println("4 = Complete");
		System.out.println("5 = Blocked");
		System.out.println("6 = Go Back");

		int branchTaskIsMovingTo = branchInput.nextInt();



		Board.moveTask(branchTaskIsMovingFrom, branchTaskIsMovingTo, Board.taskName);



	}





}

