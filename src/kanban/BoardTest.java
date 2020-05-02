package kanban;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

class BoardTest {

	@Test
	void testAddTask() {
		SortedMap<Integer, String> testMap = new TreeMap<Integer, String>();
		testMap.put(1, "studying");
		assertEquals(testMap.size(), 1);
		assertEquals("studying", testMap.get(1));
	}

	@Test
	void testDeleteTask() {
		SortedMap<Integer, String> testMap = new TreeMap<Integer, String>();
		testMap.put(3, "working");
		testMap.remove(3, "working");
		assertEquals(testMap.size(), 0);
		assertNull(testMap.get(3), "working");

	}

	@Test
	void testMoveTask() {
		SortedMap<Integer, String> testMapFrom = new TreeMap<Integer, String>();
		SortedMap<Integer, String> testMapTo = new TreeMap<Integer, String>();

		testMapFrom.put(1, "studying");
		String val = testMapFrom.get(1);
		testMapFrom.remove(1,"studying");
		testMapTo.put(1, val);
		assertEquals(testMapFrom.size(), 0);
		assertEquals(testMapTo.size(), 1);
		assertEquals("studying", testMapTo.get(1));
		assertEquals(null, testMapFrom.get(1));
	}

	@Test
	void testRemoveTaskFromOldColumn() {
		SortedMap<Integer, String> testMap = new TreeMap<Integer, String>();
		testMap.put(54, "almost done with 237");
		testMap.remove(54, "almost done with 237");
		assertEquals(testMap.size(), 0);
		assertNull(testMap.get(54), "almost done with 237");
	}

	@Test
	void testAddTaskToNewColumn() {
		SortedMap<Integer, String> testMap = new TreeMap<Integer, String>();
		testMap.put(434, "working on 237");
		assertEquals(testMap.size(), 1);
		assertEquals("working on 237", testMap.get(434));
	}

	@Test	
	void testDisplayTaskMap() {
		SortedMap<Integer, String> testMap = new TreeMap<Integer, String>();
		int[] arr = new int[3];
		String[] arr2 = new String[3];

		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr2[0] = "hello";
		arr2[1] = "im";
		arr2[2] = "working";

		testMap.put(1, "hello");
		testMap.put(2, "im");
		testMap.put(3, "working");
		int i = 0;
		for (Map.Entry<Integer, String> entry : testMap.entrySet()) {
			assertEquals(arr[i] + ", " + arr2[i], entry.getKey() + ", " + entry.getValue());		
			i++;
		}
	}

	@Test
	void testGetBranchName() {
		Menu testMenu = new Menu();
		String result1 = testMenu.getBranchName("1");
		assertEquals("Backlog", result1);
	}

	@Test
	void testGetBranch() {
		Menu testMenu = new Menu();
		Board testbrd = new Board();
		testMenu.board = testbrd;
		SortedMap<Long, String> testMap = new TreeMap<Long, String>();
		testMap = testMenu.getBranch("1");
		testbrd.addTask(testMap, System.currentTimeMillis());
		testbrd.displayTaskMap(testMap, "1");
	}

	@Test
	void testDisplayTaskMapAlphabetical() {
		Menu testMenu = new Menu();
		Board testbrd = new Board();
		testMenu.board = testbrd;
		SortedMap<Long, String> testMap = new TreeMap<Long, String>();
		testMap = testMenu.getBranch("1");
		testbrd.addTask(testMap, System.currentTimeMillis());
		testMap = testMenu.getBranch("1");
		testbrd.addTask(testMap, System.currentTimeMillis());
		testbrd.displayTaskMapAlphabetical(testMap, "1");
	}
}
