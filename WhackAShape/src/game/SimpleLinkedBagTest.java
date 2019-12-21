
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, 
//nor will I accept the actions of those who do.
// Jhanavi Ghadia (jrg2920)
package game;
import student.TestableRandom;

/**
 * @author jhanavi ghadia
 * @version 2019.09.29
 * Test class for SimpleLinkedBag
 */
public class SimpleLinkedBagTest extends student.TestCase {
    private SimpleLinkedBag<String> bag1 = new SimpleLinkedBag<String>();
    private SimpleLinkedBag<String> bag2 = new SimpleLinkedBag<String>();


    /**
     * set up method for a LinkedBag test
     */
    public void setUp() {
        bag1.add("apples");
        bag1.add("bananas");
    }
    
    /**
     * test method for add
     */
    public void testAdd() {
        assertTrue(bag1.add("apples"));
        assertFalse(bag1.add(null));
    }
    
    /**
     * test method for getCurrentSize
     */
    public void testGetCurrentSize() {
        assertEquals(2, bag1.getCurrentSize());
    }
    
    /**
     * test method for isEmpty
     */
    public void testIsEmpty() {
        assertTrue(bag2.isEmpty());
        assertFalse(bag1.isEmpty());
    }

    /**
     * test method for pick
     */
    public void testPick() {
        TestableRandom.setNextInts(1);
        assertEquals("apples", bag1.pick());
        assertNull(bag2.pick());
    }
    
    /**
     * test method for pick
     */
    public void testRemove() {
        bag1.remove("apples");
        assertTrue(bag1.remove("bananas"));
        assertFalse(bag1.remove("apples"));
    }

}
