package datastralgotuts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import datastralgotuts.LinkedListSly;

public class LListSlyTester {
	private static final int LONG_LIST_LENGTH =10; 

	LinkedListSly shortList;
	LinkedListSly emptyList;
	LinkedListSly longerList;
	LinkedListSly list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new LinkedListSly();
		shortList.add("A");
		shortList.add("B");
		emptyList = new LinkedListSly();
		longerList = new LinkedListSly();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new LinkedListSly();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		boolean a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.getSize());
		
		try {
			emptyList.remove(99);
			fail();
		} catch (IndexOutOfBoundsException e) {
		}
		
		try {
			shortList.remove(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
		}
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd(){
		//assertEquals(true, shortList.add("Hello"));
		assertEquals("Hello", shortList.get(shortList.getSize() - 1));

		try {
			shortList.add(null);
			fail();
		} catch (NullPointerException e) {
		}
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		assertEquals(LONG_LIST_LENGTH, longerList.getSize());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
		try {
			emptyList.add(99, 42);
			fail();
		} catch (IndexOutOfBoundsException e) {
		}
		
		try {
			shortList.add(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
		}

		try {
			shortList.add(0);
			fail();
		} catch (NullPointerException e) {
		}

		list1.add(0, 42);
		assertEquals((Integer) 42, list1.get(0));
	}
	
	/** Test setting an element in the list 
	@Test
	public void testSet()
	{
		try {
			emptyList.set(99, 42);
			fail();
		} catch (IndexOutOfBoundsException e) {
		}
		
		try {
			shortList.set(-1, "42");
			fail();
		} catch (IndexOutOfBoundsException e) {
		}

		try {
			shortList.set(0, null);
			fail();
		} catch (NullPointerException e) {
		}

		list1.set(0, 2187);
		assertEquals((Integer) 2187, list1.get(0));
	}
	*/	
}
