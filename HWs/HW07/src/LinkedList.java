//I worked on the homework assignment alone, using only course materials.
import java.util.NoSuchElementException;

/**
 * This class represents a singly-linked linked list
 * @author Donaven Lobo
 * @version 1.0
 *
 * @param <T> represent the generic type the node will conatian
 */

public class LinkedList<T> implements List<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Only constructor for linked list
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Getter method for head node
     * @return the head node
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Getter method for the tail node
     * @return the tail node
     */
    public Node<T> getTail() {
        return tail;
    }

    @Override
    public void addAtIndex(T data, int index) {
        if (index < 0 || index > size) {
            throw(new IllegalArgumentException("Your index is out of bounds"));
        }
        if (data == null) {
            throw(new IllegalArgumentException("You cannot add null data to the list"));
        }
        Node<T> current = head;
        if (index == 0) {
            //System.out.println("Case when index is 0");
            //System.out.println("Current data: " + data);
            head = new Node(data, current);
            if (size == 0) {
                //System.out.println("Case where list was intially empty");
                tail = head;
            }
        } else {
            int i = 0;
            //System.out.println("Given index is: " + index + " Data to add is: " + data);
            //System.out.println("We are entering a loop");
            do {
                //System.out.println("Current i value: " + i);
                if (i != 0) {
                    current = current.getNext();
                }

                //System.out.println("Current data value: " + current.getData());
                if (i == (index - 1)) {
                    current.setNext(new Node(data, current.getNext()));
                }
                if (i == size) {
                    tail = current;
                    //System.out.println("We are leaving due to i == size");
                    break;
                }
                i++;
            } while (current.getNext() != null);
        }
        size++;
        //System.out.println("New size of the list is: " +  size);
    }

    @Override
    public T getAtIndex(int index) {
        Node<T> current;
        if (index < 0 || index > (size - 1)) {
            throw(new IllegalArgumentException("Your index is out of bounds"));
        } else {
            current = head;
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    break;
                }
                current = current.getNext();
            }
        }
        return current.getData();
    }

    @Override
    public T removeAtIndex(int index) {
        T returnData = null;
        if (index < 0 || index > (size - 1)) {
            throw(new IllegalArgumentException("Your index is out of bounds"));
        } else {
            Node<T> current = head;
            int i = 0;
            do {
                //System.out.println("Current i value: " + i);
                if (i != 0) {
                    current = current.getNext();
                }
                //System.out.println("Current data value: " + current.getData());
                if (index == 0) {
                    returnData = current.getData();
                    head = current.getNext();
                } else if (i == (index - 1)) {
                    Node<T> nextNode = current.getNext();
                    returnData = nextNode.getData();
                    current.setNext(nextNode.getNext());
                }
                /*if (i == (size - 1)) {
                    System.out.println("End of loop condition met! Tail is now set to: " + current);
                    tail = current;
                    break;
                }*/
                i++;
            } while (current.getNext() != null);
            size--;
            tail = current;
        }
        return returnData;
    }

    @Override
    public T remove(T data) {
        T returnData = null;
        if (data == null) {
            throw(new IllegalArgumentException("You cannot remove null data to the list"));
        } else {
            boolean dataPresent = false;
            Node<T> current = head;
            //System.out.println("The data value we are looking for is: " + data);
            for (int i = 0; i < size; i++) {
                T currentData = current.getData();
                //System.out.println("Current Data Value is: " + currentData);
                if (currentData.equals(data)) {
                    //System.out.println("We have entered the if condition, current i value is: " + i);
                    returnData = removeAtIndex(i);
                    dataPresent = true;
                } else {
                    current = current.getNext();
                }
            }
            if (!dataPresent) {
                throw (new NoSuchElementException("The data is not present in the list."));
            }
        }
        return returnData;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
