// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, 
//nor will I accept the actions of those who do.
// Jhanavi Ghadia (jrg2920)
package game;

import bag.Node;
import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * SimpleLinkedbag that imports node
 * @author jhanavi ghadia
 * @param <T> generic type
 * @version 2019.09.29
 */
public class SimpleLinkedBag<T> implements SimpleBagInterface<T> {
    private Node<T> firstNode;
    private int numberOfEntries;

    /**
     * default constructor for SimpleLinkedBag
     */
    public SimpleLinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }
    
    /**
     * Add method for SimpleLinkedBag
     */
    @Override
    public boolean add(T anEntry) {

        if (anEntry == null) {
            return false;
        }
        Node<T> newNode = new Node<>(anEntry);
        newNode.setNext(firstNode);
        firstNode = newNode;
        numberOfEntries++;
        return true;

    }

    /**
     * getCurrentSize method for SimpleLinkedBag
     */
    @Override
    public int getCurrentSize() {

        return numberOfEntries;
    }

    /**
     * isEmpty method for SimpleLinkedBag
     */
    @Override
    public boolean isEmpty() {

        return numberOfEntries == 0;
    }

   /**
    * Pick method for SimpleLinkedBag
    */
    @Override
    public T pick() {
        if (isEmpty()) {
            return null;
        }
        else {
            TestableRandom generator = new TestableRandom();
            int index = generator.nextInt(numberOfEntries);
            Node<T> temporary = firstNode;
            for (int i = 0; i < index; i++) {
                temporary = temporary.next();
            }
            return temporary.data();
        }
    }

    /**
     * Remove method for SimpleLinkedBag
     */
    @Override
    public boolean remove(T anEntry) {
        if (getReferenceTo(anEntry) == null) {
            return false;
        }
        else {
            Node<T> node = getReferenceTo(anEntry);
            node.setData(firstNode.data());
            firstNode = firstNode.next();
            numberOfEntries--;
        }
        return true;
    }

    /**
     * getReference method for SimpleLinkedBag
     * @param anEntry entry for which we need to find the reference
     * @return the node of an entry
     */
    private Node<T> getReferenceTo(T anEntry) {
        boolean found = false;
        Node<T> currentNode = firstNode;
        while (!found && currentNode != null) {
            if (anEntry.equals(currentNode.data())) {
                found = true;
            }
            else {
                currentNode = currentNode.next();
            }
        }
        return currentNode;

    }

}
