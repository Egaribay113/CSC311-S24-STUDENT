/**
 * This class represents a list of integers. The underlying data structure is an array. 
 * Array is a fixed size data structure, where is the List is supposed to be flexible. Therefore, to create 
 * flexible list, the array is created with a fixed size and when the array is full, a new array is created  
 * with higher capacity and the data is copied to the new array.
 * 
 * The creation of new array and copying of data is an expensive operation will impact on the performance
 * of the list and its Big O notation.
 * 
 * @author Usman Aslam
 * @version 1.0
 * @since 2024-03-08
 * 
 */

//ArrayList<T> myarr = new ArrayList<T>();



package com.usman.csudh.csc311.adt.impl;

import com.usman.csudh.csc311.adt.List;
import com.usman.csudh.csc311.adt.ListInvalidIndexException;



/**
 * ArrayList class data structure is a list that can become resizeable while allowing
 * access to elements in specified locations or indexes. It can also retrieve items, insert, clear, or remove. 
 * This list can grow or shrink in size depending on the task it is used for. 
 * @author Eric Garibay
 *
 * @param <T> java generics to accept any parameter type. 
 */

public class ArrayList<T extends List>  {

    /**
     * The initial capacity of the list.
     */
    static final int INITIAL_CAPACITY = 50;

    /**
     * The underlying array will grow by this number when the it is full.
     */
    static final int GROW_BY = 25;

    /**
     * The underlying array to hold the data.
     */
    private Object[] data;

    /**
     * The pointer variable to keep track the current position of the array
     */
    int arrayPointer = 0;

    /**
     * The default constructor to create a list with the initial capacity.
     */
    public ArrayList() {
        data = new Object[INITIAL_CAPACITY];
    }

    /**
     * The constructor to create a list with the given size.
     *
     * @param size the size of the list
     */
    public ArrayList(int size) {
        data = new Object[size];
    }

    /**
     * The method to add an item to the list. The item is added to the end of the
     * list. The size of the underlying array is checked and if the array is full, a
     * new array is created with higher capacity.
     *
     * @param item the value to add to the list
     */
    public void add(T item) {
        if (arrayPointer == data.length) {
            resizeArray();
        }
        data[arrayPointer++] = item;
    }

    /**
     * The method to get the value at the given index. It will replace the existing
     * value at the given index.
     *
     * @param index the index of the value to get
     * @param item  the value to add to the list
     * @return the value at the given index
     */
    public void put(int index, T item) throws ListInvalidIndexException {
        if (index > arrayPointer - 1 || index < 0) {
            throwInvalidIndexException();
        }
        data[index] = item;
    }

    /**
     * The method returns the size of the list.
     *
     * @return the size of the list
     */
    public int size() {
        return arrayPointer;
    }

    /**
     * Method checks the list if it is empty and then checks to whether the
     * arrayPointer == 0. 
     *
     * @return the size of the list
     */
    public boolean isEmpty() {
        return arrayPointer == 0;
    }

    public void clear() {
        arrayPointer = 0;
        data = new Object[INITIAL_CAPACITY];
    }

    /**
     * The method inserts the given value at the given index. The existing value at
     * the given index is moved to the right. If the array is full, a new array is
     * created with higher capacity.
     *
     * @param item  the value to insert
     * @param index the index to insert the value
     */
    public void insert(int index, T item) throws ListInvalidIndexException {
        // Check if the index is valid
        if (index > arrayPointer || index < 0) {
            throwInvalidIndexException();
        }
        // Counter to keep track of the number of loops for the insert operation
        int loopCount = 0;

        // Check if the array is full and resize the array if it is full
        if (arrayPointer == data.length) {
            resizeArray();
        }

        // Move the values to the right to create space for the new value
        for (int i = arrayPointer; i > index; i--) {
            data[i] = data[i - 1];
            loopCount++;
        }

        // Insert the value at the given index
        data[index] = item;

        // Increment the array pointer
        arrayPointer++;
        System.out.println("Insert: " + loopCount);
    }

    public T get(int index) throws ListInvalidIndexException {

        // Check if the index is valid
        if (index >= arrayPointer || index < 0) {
            throwInvalidIndexException();
        }

        return (T) data[index];

    }

    /**
     * This method deletes the value at the given index. The values to the right of
     * the given index are moved to the left.
     *
     * @param index the index of the value to delete
     */

    public T remove(int index) throws ListInvalidIndexException {

        // Check if the index is valid
        if (index > arrayPointer || index < 0) {
            throwInvalidIndexException();
        }

        int loopCount = 0;

        T value = (T) data[index];

        // Move the values to the left to fill the space created by the deleted value
        for (int i = index; i < arrayPointer; i++) {
            data[i] = data[i + 1];
            loopCount++;
        }
        // Decrement the array pointer because the value is deleted
        arrayPointer--;
        System.out.println("Delete: " + loopCount);
        return value;
    }

    /**
     * This method returns String representation of the list.
     *
     * @return the value at the given index
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arrayPointer; i++) {
            result.append(data[i]).append(" ");
        }
        return result.toString();
    }

    /**
     * Method resizes the array by creating a new array with higher capacity and
       copying the data to the new array
     */
    private void resizeArray() {
        int loopCount = 0;
        Object[] newData = new Object[data.length + GROW_BY];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
        System.out.println("Resize: " + loopCount);
    }

    /**
     * 
     * @throws ListInvalidIndexException
     */
    
    private void throwInvalidIndexException() throws ListInvalidIndexException {
        throw new ListInvalidIndexException("Invalid index");
    }
}

