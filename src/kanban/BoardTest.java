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

	void testDeleteTask() {
		SortedMap<Integer, String> testMap = new TreeMap<Integer, String>();
		testMap.put(3, "working");
		testMap.remove(3, "working");
		assertEquals(testMap.size(), 0);
		assertNull(testMap.get(3), "working");

	}

	void testdisplayTaskMap(SortedMap<Long, String> mapToDisplay, String kanbanCategoryName) {
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
		for (Map.Entry<Long, String> entry : mapToDisplay.entrySet()) {
			assertEquals(arr[i] + ", " + arr2[i], entry.getKey() + ", " + entry.getValue());		
			i++;
		}
	}	
}
