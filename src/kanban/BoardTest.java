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
		
		arr2[0] = "hello";
		arr2[1] = "im";
		arr2[2] = "working";
		arr2[3] = "!";
		//testMap.put(");
		testMap.put(1, arr2[1]);
		testMap.put(3, "working");
		for (Map.Entry<Long, String> entry : mapToDisplay.entrySet()) {
			assertEquals()		
		}
		
	}
	
}
