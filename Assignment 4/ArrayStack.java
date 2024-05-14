

package com.usman.csudh.csc311.adt.impl;

import com.usman.csudh.csc311.adt.Stack;


/**
 * @author Eric Garibay
 * ArrayStack data structure utlizing an array for a stack or implementing a stack using an array.
 * This allows for an array to become resizable considering it is a fixed size. A new array is created when
 * the array is full. This class includes multiple methods like push,peek,pop etc. to be able to efficiently
 * modify and manipulate data around. 
 */


import com.usman.csudh.csc311.adt.StackEmptyException;

/**
 * 
 *The ArrayStack class implements a stack data structure using an array, 
 *enabling efficient addition and removal of elements from the top of the stack. 
 *It follows the last-in, first-out (LIFO) principle.
 * @author Eric Garibay
 *
 * @param <T> java Generics 
 */


public class ArrayStack <T extends Stack> {
	/**
	 * The default capacity of the stack.
	 *
	 */
	private static final int DEFAULT_CAPACITY = 50;
	
	
	/**
	 * The underlying array will grow by this number when the it is full.
	 */
	private static final int GROW_BY = 25;
	
	
	/**
	 * The underlying array to hold the data.
	 */
	private int[] data;
	
	/**
	 * The pointer variable to keep track the current position of the array
	 */
	int stackPointer=0;
	
	/**
	 * The default constructor to create a stack with the initial capacity.
	 *
	 */
	public ArrayStack() {
		data= new int[DEFAULT_CAPACITY];
	}
	
	/**
	 * The constructor to create a stack with the given size.
	 * 
	 * @param size the size of the stack
	 *
	 */
	public ArrayStack(int size) {
		data = new int[size];
	}
	
	/**
	 * The method to add an item to the stack.
	 * 
	 * @param item the value to be added to the stack
	 *
	 */
	public void push(int item) {
		//check if the array is full and if so, resize it
		if (stackPointer == data.length) {
			resizeArray();
		}
		
		//add the item to the stack
		data[stackPointer++] = item;

	}
	
	/**
	 * The method to remove an item from the stack.
	 * @return the item removed from the stack
	 * @throws StackEmptyException if the stack is empty
	 */
	public int pop() throws StackEmptyException{
		//check if the stack is empty
		if (stackPointer == 0) {
			throw new StackEmptyException("Stack is empty");
		}
		
		//remove the item from the stack
		return data[--stackPointer];
	}
	
	/**
	 * The method to get the value at the top of the stack. It will not remove the
	 * value from the stack.
	 * 
	 * @return the value at the top of the stack
	 * @throws StackEmptyException if the stack is empty
	 */
	public int peek() throws StackEmptyException {
		//check if the stack is empty
		if (stackPointer == 0) {
			throw new StackEmptyException("Stack is empty");
		}
		return data[stackPointer-1];
	}
	
	/**
	 * The method returns the size of the stack.
	 * 
	 * @return the size of the stack
	 */
	public int size() {
		return stackPointer;
	}

	/**
	 * The method returns true if the stack is empty, otherwise it returns false.
	 * 
	 * @return true if the stack is empty, otherwise false
	 */
	public boolean isEmpty() {
		return stackPointer == 0;
	}
	
	/**
	 * The method clears the stack and then
	 * sets the stackPointer to zero. 
	 *
	 */
	public void clear() {
		stackPointer = 0;
	}
	
	
	/**
	 * Method that resizes the array when it is full and
	 * keeps track of the loops as it transverses through the array. 
	 * creating a new array(newData) to store the size of the data and the number it will
	 * grow by when it reaches its peak or length. That data is then stored into data. 
	 * 
	 *
	 */
	private void resizeArray() {
		int loopCount = 0;
		int[] newData = new int[data.length +GROW_BY];
		for (int i = 0; i < data.length; i++) {
			newData[i] = data[i];
			loopCount++;
		}
		data = newData;
		System.out.println("Resize: "+loopCount);
	}
	
	/**
	 * This method returns String representation of the stack.
	 * 
	 * @return the value at the given index
	 */
	@Override
	public String toString() {
		String result = "";
		for (int i = stackPointer-1; i >= 0; i--) {
			result += data[i] + "\n";
		}
		return result;
	}

}
