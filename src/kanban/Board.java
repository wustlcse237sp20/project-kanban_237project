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
	static SortedMap<Long, String> Backlog = new TreeMap<Long, String>();
	static SortedMap<Long, String> InProgress = new TreeMap<Long, String>();
	static SortedMap<Long, String> Verify = new TreeMap<Long, String>();
	static SortedMap<Long, String> Complete = new TreeMap<Long, String>();
	static SortedMap<Long, String> Blocked = new TreeMap<Long, String>();
	
	static String taskName;
	
	public static void main(String[] args) {
			
		Menu.menuChoice();

	}

	/**
	 * @param mapToDeleteTask the map that the user is deleting a task from
	 * @return void
	 */
	static void deleteTask(SortedMap<Long, String> mapToDeleteTask) {
		System.out.println("What task would you like to delete? Type in full name:");
		Scanner delete = new Scanner(System.in);
		String deleteTask = delete.nextLine();
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
	 static void addTask(SortedMap<Long, String> mapToAddTask, long taskTimeStamp) {
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
	 static void displayTaskMap(SortedMap<Long, String> mapToDisplay, String kanbanCategoryName) {
		System.out.println("Kanban Board Category: " + kanbanCategoryName);
		for (Map.Entry<Long, String> entry : mapToDisplay.entrySet()) {
			System.out.println("Key: " + generateTimestamp(entry.getKey()) + " Value: " + entry.getValue());
		}
		System.out.println();
	}

	
	
	/**
	 * @param mapToDeleteTask is the origin map of the task to be moved
	 * @param taskTimeStamp is the long data type time that is the time associated with when a task was created
	 */
	 static void removeTaskFromOldColumn(SortedMap<Long, String> mapToDeleteTask, long taskTimeStamp) {
		mapToDeleteTask.remove(taskTimeStamp);
	}
	
	/**
	 * @param mapToAddTask is the destination map of the task to be moved
	 * @param taskTimeStamp is the long data type time that is the time associated with when a task was created
	 * @param save is the string value that keeps track of which task you want to move
	 */
	 static void addTaskToNewColumn(SortedMap<Long, String> mapToAddTask, String taskName, long taskTimeStamp) {
		mapToAddTask.put(taskTimeStamp, taskName);
	}
	
	/**
	 * @param mapMovingFrom is the origin map of the task to be moved
	 * @param mapMovingTo is the destination map of the task to be moved
	 * @param taskTimeStamp is the long data type time that is the time associated with when a task was created
	 */
	 static void moveTask(SortedMap<Long, String> mapMovingFrom, SortedMap<Long, String> mapMovingTo, String taskName) {
		
        Iterator<Map.Entry<Long, String>> iterator = mapMovingFrom.entrySet().iterator(); 
        long taskTimeStamp;
        boolean taskExistsOnMapMovingFrom = false;
        		
        while (iterator.hasNext()) { 
            Map.Entry<Long, String> 
            entry = iterator.next(); 
  
            if (taskName.equals(entry.getValue())) {
            	taskExistsOnMapMovingFrom = true;
                taskTimeStamp = entry.getKey();
                removeTaskFromOldColumn(mapMovingFrom, taskTimeStamp);
                addTaskToNewColumn(mapMovingTo, taskName, taskTimeStamp);
            } 
        }
        if(taskExistsOnMapMovingFrom == false) {
        	System.out.println("Error: task \"" + taskName + "\" does not exist in this column."+ "\n");

        }
        else{ 
        	System.out.println("Task \"" + taskName + "\" successfully moved."+ "\n");
        }
		
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
