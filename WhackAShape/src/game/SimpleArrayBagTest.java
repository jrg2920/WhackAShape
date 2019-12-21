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
 * @version 2019.09.28
 * Test class for simple array bag
 */
public class SimpleArrayBagTest extends student.TestCase {

    private SimpleArrayBag<String> bag1;
    private SimpleArrayBag<String> bag2;

    /**
     * setUp method to set the values in the bag
     */
    public void setUp() {
        bag1 = new SimpleArrayBag<String>();
        bag2 = new SimpleArrayBag<String>();

        bag1.add("apples");
        bag1.add("bananas");
        bag1.add("butter");
    }

    /**
     * Test the add method of simple array bag
     */
    public void testAdd() {
        for (int i = 0; i < 22; i++) {
            bag1.add("fruits");
        }
        assertFalse(bag1.add("papayas"));
        assertFalse(bag1.add(null));
    }

    /**
     * Test a method of a class
     */
    public void testGetCurrentsize() {
        assertEquals(3, bag1.getCurrentSize());
        
    }
    
    /**
     * Test a method of a class
     */
    public void testIsEmpty() {
        assertFalse(bag1.isEmpty());
        assertTrue(bag2.isEmpty());
    }

    /**
     * Test a method of a class
     */
    public void testPick() {
        TestableRandom.setNextInts(1);
        assertEquals("bananas", bag1.pick());
        assertNull(bag2.pick());
    }

    /**
     * Test a method of a class
     */
    public void testRemove() {
        bag1.remove("apples");
        assertFalse(bag1.remove("apples"));
    }
}
