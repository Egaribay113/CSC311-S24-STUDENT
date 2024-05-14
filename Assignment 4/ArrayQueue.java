package com.usman.csudh.csc311.adt.impl;

import com.usman.csudh.csc311.adt.Queue;
import com.usman.csudh.csc311.adt.QueueEmptyException;

/**
 * The ArrayQueue class implements a queue data structure using an array, allowing elements to be added at the rear 
 * and removed from the front efficiently. It maintains the first-in, first-out (FIFO) order of elements, 
 * commonly used in scenarios requiring sequential processing like task scheduling or breadth-first searches.
 * Utilizing all the methods like add, remove, resize, peek, etc. to move around data. 
 * @author Eric Garibay
 *
 * @param <T>
 */


public class ArrayQueue  <T extends Queue> {
	/**
	 * The initial capacity of the list.
	 *
	 */

	static final int INITIAL_CAPACITY = 50;
	static final int QUEUE_HEAD=0;

	/**
	 * The underlying array will grow by this number when the it is full.
	 */

	static final int GROW_BY = 25;

	/**
	 * The underlying array to hold the data.
	 */
	private T[] data;

	/**
	 * The pointer variable to keep track the current position of the array
	 */
	int qPointer = 0;

	/**
	 * The default constructor to create a list with the initial capacity.
	 *
	 */
	public ArrayQueue() {
		data = (T[]) new Object[INITIAL_CAPACITY];
	}

	/**
	 * The constructor to create a list with the given size.
	 * 
	 * @param size the size of the list
	 *
	 */
	public ArrayQueue(int size) {
		data = (T[]) new Object[size];
	}
	
	/**
	 * 
	 * Method add() adds an item to a queue by implementing an array. 
	 * If the array is full, it resizes the array to accommodate more elements. 
	 * Then, it adds the item to the end of the queue and increments the queue pointer.
	 * @param item
	 */
	
	public void add(T item) {
		if (qPointer == data.length) {
			resizeArray();
		}
		data[qPointer++] = item;

	}

	/**
	 * The remove() method removes and returns the item at the front of a queue and keeps track of the loops as it tranverses.  
	 * when it retrieves an item to return, it begins to shift all remaining items to the left 
	 * to fill the gap created by the removal of the item while decrementing the queue pointer.
	 * @return itemToReturn
	 * @throws QueueEmptyException if the queue is empty
	 */
	
	public T remove() throws QueueEmptyException {
		
		// Check if the index is valid
		if (qPointer==0) {
			throw new QueueEmptyException("Queue is empty");
		}
		T itemToReturn = data[QUEUE_HEAD];
		int loopCount = 0;

		// Move the values to the left to fill the space created by the deleted value
		for (int i = 0; i < qPointer; i++) {
			data[i] = data[i + 1];
			loopCount++;
		}
		// Decrement the array pointer because the value is deleted
		qPointer--;
		System.out.println("Delete: " + loopCount);
		return itemToReturn;
	}
	
	/**
	 *  Method resizes the array by creating a new array with higher capacity and
	 *  copies the data to the new array. 
	 */
	private void resizeArray() {
		int loopCount = 0;
		T[] newData = (T[])new Object[data.length + GROW_BY];
		for (int i = 0; i < data.length; i++) {
			newData[i] = data[i];
			loopCount++;
		}
		data = newData;
		System.out.println("Resize: " + loopCount);
	}

	/**
	 * Determines whether the queue is empty by using the queue pointer. If the queue is not 
	 * empty, then it returns the item at the head of the queue 
	 * @return
	 * @throws QueueEmptyException
	 */
	
	public T peek() throws QueueEmptyException {
		
		if (qPointer == 0) {
			throw new QueueEmptyException("Queue is empty");
		}
		return data[QUEUE_HEAD];
	}
	
	/**
	 * checks the size of the queue and returns the qpointer value that 
	 * refers the number of elements. 
	 * @return
	 */

	public int size() {
		return qPointer;
	}
	
	/**
	 * checks whether the queue is empty and if not, it then returns the qpointer
	 * @return
	 */

	public boolean isEmpty() {
		return qPointer == 0;
	}

	/**
	 * clears the queue and resets it by initializing the pointer to zero. 
	 */
	public void clear() {
		qPointer = 0;
		
	}

	

}
