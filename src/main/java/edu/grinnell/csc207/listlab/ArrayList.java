package edu.grinnell.csc207.listlab;

import java.util.Arrays;

/**
 * An array-based implementation of the list ADT.
 */
public class ArrayList {

    int[] data = {0};
    int size;




    /**
     * Adds <code>value</code> to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    public void add(int value) {
        ensureCapacity();
        data[size] = value;
        size++;
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        return size;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public int get(int index) {
        return data[index];
    }

    /**
     * Removes the value at <code>index</code> from the list
     * 
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public int remove(int index) {
        if(size == 0){
            return -1;
        } else if(size == 1){
            size--;
            return data[0];
        } else{
            int goal = data[index];
            for (int i = index; i < size; i++) {
                data[i] = data[i + 1];
            } size--;
            return goal;
        }
    }

    private void ensureCapacity() {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }
}
