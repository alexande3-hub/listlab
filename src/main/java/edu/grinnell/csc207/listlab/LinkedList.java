package edu.grinnell.csc207.listlab;

/**
 * A linked implementation of the list ADT.
 */
public class LinkedList {



    private static class Node {
        public int value;
        public Node next;
    
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node first;

    public LinkedList(){
        this.first = null;
    }

    /**
     * Adds <code>value</code> to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    public void add(int value) {
        Node new_node = new Node(value, null);
        Node current = this.first;
        while (current != null) {
            current = current.next;
        } current = new_node;
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        Node current = this.first;
        int num = 0;
        while (current != null) {
            num += 1;
            current = current.next;
        } return num;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public int get(int index) {
        Node current = this.first;
        for(int i = 0; i < index; i++){
           current = current.next;
        }
        return current.value;
    }

    /**
     * Removes the value at <code>index</code> from the list
     * 
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public int remove(int index) {
        Node current = this.first;
        if (size() == 1){
            this.first = null;
            return current.value;
        }
        for(int i = 0; i < index-1; i++){
           current = current.next;
        }
        int return_value = current.next.value;
        current.next = current.next.next;
        return return_value;
    }
}
