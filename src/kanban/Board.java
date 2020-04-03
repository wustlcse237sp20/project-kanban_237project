package kanban;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Board {
	public static void main(String[] args) {
		// Each SortedMap represents a column on the board
		SortedMap<Integer, String> Backlog = new TreeMap<Integer, String>();
		SortedMap<Integer, String> InProgress = new TreeMap<Integer, String>();
		SortedMap<Integer, String> Verify = new TreeMap<Integer, String>();
		SortedMap<Integer, String> Complete = new TreeMap<Integer, String>();
		SortedMap<Integer, String> Blocked = new TreeMap<Integer, String>();
		
		// "Testing" adding items to the board - make into a formal JUnit test
		// Eventually, we want to prompt the user to add tasks as part of a separate method
		Backlog.put(5,  "Cry over 237");
		Backlog.put(3, "Take exam");
		Backlog.put(4, "Do homework");

		Set BacklogSet = Backlog.entrySet();
		Iterator i = BacklogSet.iterator();

		
		// Printing Backlog column
		while (i.hasNext()) {
			Map.Entry<Integer, String> me = (Map.Entry<Integer, String>)i.next();
		      System.out.print("Key is: "+me.getKey() + " & ");
		      System.out.println("Value is: "+me.getValue());
		}

	}
}
