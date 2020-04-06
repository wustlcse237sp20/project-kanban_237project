package kanban;

import static org.junit.jupiter.api.Assertions.*;

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
	
}
