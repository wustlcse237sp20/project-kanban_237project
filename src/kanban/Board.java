package kanban;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.*;

public class Board {

	static Menu menu = new Menu();

	private SortedMap<Long, String> Backlog;
	private SortedMap<Long, String> InProgress;
	private SortedMap<Long, String> Verify;
	private SortedMap<Long, String> Complete;
	private SortedMap<Long, String> Blocked;
	private String taskname;

	public Board() {
		this.Backlog = new TreeMap<>();
		this.InProgress = new TreeMap<>();
		this.Verify = new TreeMap<>();
		this.Complete = new TreeMap<>();
		this.Blocked = new TreeMap<>();
	}


	public SortedMap<Long, String> getBacklog() {
		return Backlog;
	}


	public SortedMap<Long, String> getInProgress() {
		return InProgress;
	}


	public SortedMap<Long, String> getVerify() {
		return Verify;
	}


	public SortedMap<Long, String> getComplete() {
		return Complete;
	}


	public SortedMap<Long, String> getBlocked() {
		return Blocked;
	}


	public String getTaskname() {
		return taskname;
	}


	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}


	public static void main(String[] args) {
		menu.menuChoice();
	}

	/**
	 * @param mapToDeleteTask the map that the user is deleting a task from
	 * @return void
	 */
	public void deleteTask(SortedMap<Long, String> mapToDeleteTask) {
		System.out.println("What task would you like to delete? Type in full name:");
		String deleteTask = returnUserInputBoard();
		boolean taskExistsOnMapDeletingFrom = false;

		Iterator<Map.Entry<Long, String>> iterator = mapToDeleteTask.entrySet().iterator(); 

		while (iterator.hasNext()) { 
			Map.Entry<Long, String> 
			entry = iterator.next(); 

			if (deleteTask.equals(entry.getValue())) {
				taskExistsOnMapDeletingFrom = true;
				iterator.remove(); 
			} 
		}
		if(taskExistsOnMapDeletingFrom == false) {
			System.out.println("Error: task \"" + deleteTask + "\" does not exist in column."+ "\n");

		}
		else {
			System.out.println("Task \"" + deleteTask + "\" successfully deleted."+ "\n");
		}
	}
	
	/** 
	 * @param mapToAddTask the map that the user is adding a task to
	 * @param taskCounter the index of in the map that the task is being added to
	 * @return void
	 */
	public void addTask(SortedMap<Long, String> mapToAddTask, long taskTimeStamp) {
		System.out.println("Enter a task name:");
		String addTask = returnUserInputBoard();
		mapToAddTask.put(taskTimeStamp, addTask);
		System.out.println("Task \"" + addTask + "\" successfully added."+ "\n");
	}

	/**
	 * @param mapToDisplay the map that is being printed 
	 * @param kanbanCategoryName the category of the Kanban board that the map represents
	 * @return void
	 */
	public void displayTaskMap(Map<Long, String> mapToDisplay, String kanbanCategoryName) {
		System.out.println("Kanban Board Category: " + kanbanCategoryName);
		for (Map.Entry<Long, String> entry : mapToDisplay.entrySet()) {
			System.out.println("Key: " + generateTimestamp(entry.getKey()) + " Value: " + entry.getValue());
		}
		System.out.println();
	}
	
	/**
	 * @param mapToDisplay the map to be resorted by alphabetical value (task name)
	 * @param kanbanCategoryName the category of the Kanban board that the map represents
	 */
	public void displayTaskMapAlphabetical(SortedMap<Long, String> mapToDisplay, String kanbanCategoryName) {
        List<Map.Entry<Long, String>> list = new LinkedList<Map.Entry<Long, String>>(mapToDisplay.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Long, String>>() {
            public int compare(Map.Entry<Long, String> o1, Map.Entry<Long, String> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<Long, String> sortedMapToDisplay = new LinkedHashMap<Long, String>();
        for (Map.Entry<Long, String> entry : list) {
            sortedMapToDisplay.put(entry.getKey(), entry.getValue());
        }
        displayTaskMap(sortedMapToDisplay, kanbanCategoryName);
	}

	/**
	 * @param mapToDeleteTask is the origin map of the task to be moved
	 * @param taskTimeStamp is the long data type time that is the time associated with when a task was created
	 * @return void
	 */
	public void removeTaskFromOldColumn(SortedMap<Long, String> mapToDeleteTask, long taskTimeStamp) {
		mapToDeleteTask.remove(taskTimeStamp);
	}

	/**
	 * @param mapToAddTask is the destination map of the task to be moved
	 * @param taskTimeStamp is the long data type time that is the time associated with when a task was created
	 * @param save is the string value that keeps track of which task you want to move
	 * @return void
	 */
	public void addTaskToNewColumn(SortedMap<Long, String> mapToAddTask, String taskName, long taskTimeStamp) {
		mapToAddTask.put(taskTimeStamp, taskName);
	}

	/**
	 * @param mapMovingFrom is the origin map of the task to be moved
	 * @param mapMovingTo is the destination map of the task to be moved
	 * @param taskName is a String representing the name of the task to be moved
	 * @return void
	 */
	public void moveTask(SortedMap<Long, String> mapMovingFrom, SortedMap<Long, String> mapMovingTo, String taskName) {
		long taskTimeStamp;
		boolean taskExistsOnMapMovingFrom = false;

		for (Map.Entry<Long, String> entry : mapMovingFrom.entrySet()) { 
			if (taskName.equals(entry.getValue())) {
				taskExistsOnMapMovingFrom = true;
				taskTimeStamp = entry.getKey();
				addTaskToNewColumn(mapMovingTo, taskName, taskTimeStamp);
				removeTaskFromOldColumn(mapMovingFrom, taskTimeStamp);
				break;
			} 
		}
		
		if(taskExistsOnMapMovingFrom == false) {
			System.out.println("Error: task \"" + taskName + "\" does not exist in this column."+ "\n");

		}
		else { 
			System.out.println("Task \"" + taskName + "\" successfully moved."+ "\n");
		}

	}

	/**
	 * @param currentTime is the time that is associated with when a task is created by the user
	 * @return time in a formatted string value
	 */
	public String generateTimestamp(long currentTime) {
		Timestamp timestamp = new Timestamp(currentTime);
		return timestamp.toString();
	}

	/**
	 * @return String representation of user input
	 */
	public String returnUserInputBoard() {
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();
		return userInput;
	}
}
