/**
 * This class represents a node for the linked list
 * @author Donaven Lobo
 * @version 1.0
 *
 * @param <T> represent the generic type the node will conatian
 */

public class Node<T> {

    private T data;
    private Node<T> next;

    /**
     * Main Node constructor
     * @param data data value with the generic type
     * @param next points to the next node in the list
     */
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Constructor chained to main constructor
     * @param data data value with the generic type
     */
    public Node(T data) {
        this(data, null);
    }

    /**
     * Getter method for data value
     * @return current data value
     */
    public T getData() {
        return data;
    }

    /**
     * Getter method for next Node
     * @return next Node
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Setter Method for the data
     * @param data new data value
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Setter Method for the next node
     * @param next new next Node object
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
}
