// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, 
//nor will I accept the actions of those who do.
// Jhanavi Ghadia (jrg2920)
package game;

import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * @author jhanavi ghadia
 * @version 2019.09.26
 * @param <T> generic data type
 * Simple Array Bag class with all the methods
 */
public class SimpleArrayBag<T> implements SimpleBagInterface<T> {
    private T[] bag;
    private static final int MAX = 25;
    private int numberOfEntries;


    /**
     * Default constructor for simpleArrayBag
     */
    public SimpleArrayBag() {
        @SuppressWarnings("unchecked")
        T[] tempbag = (T[])new Object[MAX];
        bag = tempbag;
        numberOfEntries = 0;
    }

    /**
     * Method to add an entry in the bag
     */
    @Override
    public boolean add(T anEntry) {

        if ((anEntry == null)) {
            return false;
        }
        if (numberOfEntries < MAX) {
            bag[numberOfEntries] = anEntry;
            numberOfEntries++;
            return true;
        }
        else {
            return false;
        }
    }

    
    /**
     * Method to get the size of the bag
     */
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }
    
    /**
     * method to check if the bag is empty
     */
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }
    
    /**
     * Pick method to call a random entry
     */
    @Override
    public T pick() {
        if (isEmpty()) {
            return null;
        }
        else {
            TestableRandom generator = new TestableRandom();
            int index = generator.nextInt(numberOfEntries);
            return bag[index];
        }
    }

    /**
     * Remove method for removing an entry from the bag
     */
    @Override
    public boolean remove(T anEntry) {
        int index = getIndexOf(anEntry);
        if (index == -1) {
            return false;
        }
        else {
            bag[index] = null;
            bag[index] = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
            return true;
        }
    }

    /**
     * method to get an index of an entry
     * @param anEntry
     * a particular entry in the bag
     * @return the index of that entry
     */
    private int getIndexOf(T anEntry) {
        int index = 0;
        int foundIndex = -1;
        while ((index < numberOfEntries)) {

            if (anEntry.equals(bag[index])) {
                foundIndex = index;
            }
            index++;
        }
        return foundIndex;
    }
}
