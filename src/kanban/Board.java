package kanban;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Board {
	
	public static void main(String[] args) {
		// Each SortedMap represents a column on the board
		SortedMap<Long, String> Backlog = new TreeMap<Long, String>();
		SortedMap<Long, String> InProgress = new TreeMap<Long, String>();
		SortedMap<Long, String> Verify = new TreeMap<Long, String>();
		SortedMap<Long, String> Complete = new TreeMap<Long, String>();
		SortedMap<Long, String> Blocked = new TreeMap<Long, String>();
		
		Scanner task = new Scanner(System.in);

		while(true) {	

			System.out.println("Enter 1 if you would like to add a task");
			System.out.println("Enter 2 if you would like to delete a task");
			System.out.println("Enter 3 if you would like to display the Kanban Board");
			System.out.println("Enter 4 if you would like to move a task");
			
			String userInput = task.nextLine();

			if(userInput.equals("1")) {
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
					addTask(Backlog, System.currentTimeMillis());
					displayTaskMap(Backlog, "Backlog");
				
				}

				//allows user to add tasks to the in progress
				else if(branch == 2) {
					addTask(InProgress, System.currentTimeMillis());
					displayTaskMap(InProgress, "InProgress");
				}

				//allows user to add tasks to verify
				else if(branch == 3) {
					addTask(Verify, System.currentTimeMillis());
					displayTaskMap(Verify, "Verify");
				}

				//allows user to add tasks to complete
				else if(branch == 4) {
					addTask(Complete, System.currentTimeMillis());					
					displayTaskMap(Complete, "Complete");
				}

				//allows user to add tasks to blocked
				else if(branch == 5) {
					addTask(Blocked, System.currentTimeMillis());
					displayTaskMap(Blocked, "Blocked");
				}

				//allows user to return to the main menu
				else if(branch == 6) {
					continue;
				}	
			}	
			
			else if(userInput.equals("2")) {
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
						
			else if(userInput.equals("3")) {

				displayTaskMap(Backlog, "Backlog");
				displayTaskMap(InProgress, "InProgress");
				displayTaskMap(Verify, "Verify");
				displayTaskMap(Complete, "Complete");
				displayTaskMap(Blocked, "Blocked");
			}
			
			//moveTask
			else if(userInput.equals("4")) {
		
				Scanner whichTask = new Scanner(System.in);
				System.out.println("Where would you like to move this task from?");
				System.out.println("1 = Backlog");
				System.out.println("2 = InProgress");
				System.out.println("3 = Verify");
				System.out.println("4 = Complete");
				System.out.println("5 = Blocked");
				System.out.println("6 = Go Back");
				
				//TaskNumber
				String branchTaskIsMovingFrom = whichTask.nextLine();
				
				System.out.println("Which task would you like to move?");
				System.out.println("Enter task name: ");

				//close leak
				//Scanner branchInput = new Scanner(System.in);
				String taskName = whichTask.nextLine();
				
				System.out.println("Where would you like to move this task to?");
				System.out.println("1 = Backlog");
				System.out.println("2 = InProgress");
				System.out.println("3 = Verify");
				System.out.println("4 = Complete");
				System.out.println("5 = Blocked");
				System.out.println("6 = Go Back");
				
				
				
				//Scanner branchOutput = new Scanner(System.in);
				int branchTaskIsMovingToo = whichTask.nextInt();

				//allows user to add tasks to the backlog
				
				if(branchTaskIsMovingFrom.equals("1")) {
					
					
						if(branchTaskIsMovingToo == 2) {
							moveTask(Backlog, InProgress, taskName);
						}
						else if(branchTaskIsMovingToo == 3) {
							moveTask(Backlog, Verify, taskName);
						}
						else if(branchTaskIsMovingToo == 4) {
							moveTask(Backlog, Complete, taskName);
						}
						else if(branchTaskIsMovingToo == 5) {
							moveTask(Backlog, Blocked, taskName);
						}	       
//					moveTask(Backlog, backlogCount);
//					displayTaskMap(Backlog, "Backlog"); delete with permission
				}

		
				else if(branchTaskIsMovingFrom.equals("2")) {
					
					
						if(branchTaskIsMovingToo == 1) {
							moveTask(InProgress, Backlog, taskName);
						}
						else if(branchTaskIsMovingToo == 3) {
							moveTask(InProgress, Verify, taskName);
						}
						else if(branchTaskIsMovingToo == 4) {
							moveTask(InProgress, Complete, taskName);
						}
						else if(branchTaskIsMovingToo == 5) {
							moveTask(InProgress, Blocked, taskName);
						}	       
//					moveTask(Backlog, backlogCount);
//					displayTaskMap(Backlog, "Backlog");
				}

				//allows user to add tasks to verify
				else if(branchTaskIsMovingFrom.equals("3")) {
					
						if(branchTaskIsMovingToo == 1) {
							moveTask(Verify, Backlog, taskName);
						}
						else if(branchTaskIsMovingToo == 2) {
							moveTask(Verify, InProgress, taskName);
						}
						else if(branchTaskIsMovingToo == 4) {
							moveTask(Verify, Complete, taskName);
						}
						else if(branchTaskIsMovingToo == 5) {
							moveTask(Verify, Blocked, taskName);
						}	       
//					moveTask(Backlog, backlogCount);
//					displayTaskMap(Backlog, "Backlog");
				}

				//allows user to add tasks to complete
				else if(branchTaskIsMovingFrom.equals("4")) {
					
					
					System.out.println("Which task would you like to move?");
					System.out.println("Enter task name: ");
					
						if(branchTaskIsMovingToo == 1) {
							moveTask(Complete, Backlog, taskName);
						}
						else if(branchTaskIsMovingToo == 2) {
							moveTask(Complete, InProgress, taskName);
						}
						else if(branchTaskIsMovingToo == 3) {
							moveTask(Complete, Verify, taskName);
						}
						else if(branchTaskIsMovingToo == 5) {
							moveTask(Complete, Blocked, taskName);
						}	       
//					moveTask(Backlog, backlogCount);
//					displayTaskMap(Backlog, "Backlog");
				}

				//allows user to add tasks to blocked
				else if(branchTaskIsMovingFrom.equals("5")) {
					
					
					System.out.println("Which task would you like to move?");
					System.out.println("Enter task name: ");
					
						if(branchTaskIsMovingToo == 1) {
							moveTask(Blocked, Backlog, taskName);
						}
						else if(branchTaskIsMovingToo == 2) {
							moveTask(Blocked, InProgress, taskName);
						}
						else if(branchTaskIsMovingToo == 3) {
							moveTask(Blocked, Verify, taskName);
						}
						else if(branchTaskIsMovingToo == 4) {
							moveTask(Blocked, Complete, taskName);
						}	       
//					moveTask(Backlog, backlogCount);
//					displayTaskMap(Backlog, "Backlog");
				}

				//allows user to return to the main menu
				else if(branchTaskIsMovingFrom.equals("6")) {
					continue;
				}	
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
	private static void deleteTask(SortedMap<Long, String> mapToDeleteTask) {
		System.out.println("What task would you like to delete? Type in full name:");
		Scanner delete = new Scanner(System.in);
		String deleteTask = delete.nextLine();
		
        Iterator<Map.Entry<Long, String>> iterator = mapToDeleteTask.entrySet().iterator(); 
  
        while (iterator.hasNext()) { 
            Map.Entry<Long, String> 
            entry = iterator.next(); 
  
            if (deleteTask.equals(entry.getValue())) {
                iterator.remove(); 
            } 
            else {
                throw new IllegalArgumentException("Task does not exist in this map");
            }
        }
        
        System.out.println("Task \"" + deleteTask + "\" successfully deleted."+ "\n");
	}

	/**
	 * @param mapToAddTask the map that the user is adding a task to
	 * @param taskCounter the index of in the map that the task is being added to
	 * @return void
	 */
	private static void addTask(SortedMap<Long, String> mapToAddTask, long taskTimeStamp) {
		System.out.println("What task would you like to add?");
		Scanner add = new Scanner(System.in);
		String addTask = add.nextLine();
		mapToAddTask.put(taskTimeStamp, addTask);

	}

	/**
	 * @param mapToDisplay the map that is being printed 
	 * @param kanbanCategoryName the category of the Kanban board that the map represents
	 * @return void
	 */
	private static void displayTaskMap(SortedMap<Long, String> mapToDisplay, String kanbanCategoryName) {
		System.out.println("Kanban Board Category: " + kanbanCategoryName);
		for (Map.Entry<Long, String> entry : mapToDisplay.entrySet()) {
			System.out.println("Key: " + generateTimestamp(entry.getKey()) + " Value: " + entry.getValue());
		}
		System.out.println();
	}

	
	
	/**
	 * @param mapToDeleteTask is the map that contains the task to be deleted
	 * @param taskTimeStamp is the long data type time that is the time associated with when a task was created
	 */
	private static void moveDelete(SortedMap<Long, String> mapToDeleteTask, long taskTimeStamp) {
		mapToDeleteTask.remove(taskTimeStamp);
	}
	
	/**
	 * @param mapToAddTask is the map that contains the task to be added
	 * @param taskTimeStamp is the long data type time that is the time associated with when a task was created
	 * @param save is the string value that keeps track of which task you want to move
	 */
	private static void moveAdd(SortedMap<Long, String> mapToAddTask, String taskName, long taskTimeStamp) {
		mapToAddTask.put(taskTimeStamp, taskName);
	}
	
	/**
	 * @param mapMovingFrom is the map that contains the task to be moved
	 * @param mapMovingTo is the map that is where the task is being moved to
	 * @param taskTimeStamp is the long data type time that is the time associated with when a task was created
	 */
	private static void moveTask(SortedMap<Long, String> mapMovingFrom, SortedMap<Long, String> mapMovingTo, String taskName) {
		
        Iterator<Map.Entry<Long, String>> iterator = mapMovingFrom.entrySet().iterator(); 
        long taskTimeStamp;
        		
        while (iterator.hasNext()) { 
            Map.Entry<Long, String> 
            entry = iterator.next(); 
  
            if (taskName.equals(entry.getValue())) {
                taskTimeStamp = entry.getKey();
                moveDelete(mapMovingFrom, taskTimeStamp);
                moveAdd(mapMovingTo, taskName, taskTimeStamp);
            } 
            else {
            	throw new IllegalArgumentException("Task does not exist in this map");
            }
        }
        System.out.println("Task \"" + taskName + "\" successfully moved."+ "\n");
		
	}
	
	/**
	 * @param currentTime is the time that is associated with when a task is created by the user
	 * @return we are returning the time in a formatted string value
	 */
	public static String generateTimestamp(long currentTime) {
		Timestamp timestamp = new Timestamp(currentTime);
		return timestamp.toString();
	}
}
