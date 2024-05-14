package com.usman.csudh.csc311.adt.impl;

import com.usman.csudh.csc311.adt.List;
import com.usman.csudh.csc311.adt.ListInvalidIndexException;

/**
 * A linked list implementation of the List interface. Linked list stores its as
 * nodes. Each data item is stored in a separate node. Each node contains a
 * reference to the next node in the list. To get to any particular node, you
 * have to start at the head and follow the next references.
 * 
 * @author Usman Aslam
 * @param <T>
 * 
 */

/**
 * @author Eric Garibay
 * @param <T>
 * Implements java generics that allows LinkedList data structure 
 * to take in any object type for this matter.LinkedList class data structure where elements are stored as individual nodes,
 * each containing a reference to the next node in the sequence.
 */

public class LinkedList<T>  {
    Node<T> head;

    public LinkedList() {
        head = null;
    }

    
    /**
     * Adds an item to the tail (end of list)
     * @param item
     */
    
    public void add(T item) {
        Node<T> newNode = new Node<>(item);

        Node<T> tail = findTail();

        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
    }

    /**
     * Copies a whole array of items to the array.
     * It adds the elements to it.  
     * @param items
     */
    
    public void add(T[] items) {
        for (T item : items) {
            add(item);
        }
    }

    /**
     * inserts items within the array at a specific index. 
     * @param items
     */
     
    public void insert(int loc, T item) throws ListInvalidIndexException {
        Node<T> current = (loc == 0 ? head : findNode(loc - 1));
        if (current == null) {
            throwInvalidIndexException();
        }
        Node<T> newNode = new Node<>(item);

        if (loc == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
    }
    /**
     *  The put method inserts items at specified locations in the linked list
     *  while also handling exception errors that may occur. 
     * @param loc
     * @param item
     * @throws ListInvalidIndexException
     */
    public void put(int loc, T item) throws ListInvalidIndexException {
        Node<T> current = (loc == 0 ? head : findNode(loc - 1));

        if (current == null || current.next == null)
            throwInvalidIndexException();

        Node<T> newNode = new Node<>(item);

        if (loc == 0) {
            newNode.next = head.next;
            head = newNode;
        } else {
            newNode.next = current.next.next;
            current.next = newNode;
        }
    }
    
    /**
     * Removes items from specified location, handles error exceptions and returns
     * removed item from linkedList. 
     * @param loc
     * @return
     * @throws ListInvalidIndexException
     */

    public T remove(int loc) throws ListInvalidIndexException {
        if (loc >= size())
            throwInvalidIndexException();

        Node<T> n = (loc == 0 ? head : findNode(loc - 1));

        if (n == null)
            throwInvalidIndexException();

        T data;

        if (loc == 0) {
            data = head.data;
            head = head.next;
        } else {
            data = n.next.data;
            n.next = n.next.next;
        }

        return data;
    }
    
    /**
     * Gets item from specified location, handles exception error and proceeds to return
     * retrieved item. 
     * @param loc
     * @return
     * @throws ListInvalidIndexException
     */

    public T get(int loc) throws ListInvalidIndexException {
        Node<T> n = findNode(loc);

        if (n == null)
            throwInvalidIndexException();

        return n.data;
    }
    
    /**
     * size method works by returning the size of the list if the head is null and if not
     * it then proceeds to transverse through the list while increnting the size of it. Finally
     * it then returns the size. 
     * @return
     */

    public int size() {
        int size = 0;
        if (head == null) return size;

        Node<T> current = head;
        while (current != null) {
            current = current.next;
            size++;
        }
        return size;
    }
    /**
     * immediately clears the list and sets the head to null
     * as there is nothing within the list. 
     */

    public void clear() {
        head = null;
    }
    /**
     * checks whether the list is empty and if it is,
     * it returns head as null. 
     * @return
     */

    public boolean isEmpty() {
        return head == null;
    }
    /**
     * Returns a string representation of the list.
     * @return string containing the elements of the list
     */
    @Override
    public String toString() {
        Node<T> current = head;
        StringBuilder result = new StringBuilder();
        while (current != null) {
            result.append(current.data).append(" ");
            current = current.next;
        }
        return result.toString();
    }
    
    /**
     * 
     * @param loc
     * @return
     * @throws ListInvalidIndexException
     */

    private Node<T> findNode(int loc) throws ListInvalidIndexException {
        if (loc < 0 || (head == null && loc > 0))
            
        	throwInvalidIndexException();

        Node<T> current = head;
        int idx = 0;

        while (current != null) {
            if (idx == loc)
                return current;
            current = current.next;
            idx++;
        }
        return null;
    }

    private Node<T> findTail() {
        if (head == null) {
            return null;
        }

        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }
    
    
    /**
     * 
     * @throws ListInvalidIndexException
     */
    
    private void throwInvalidIndexException() throws ListInvalidIndexException {
        throw new ListInvalidIndexException("Invalid index");
    }
    
    /**
     * 
     * @author soul
     *	Class defines a private static nested class Node, which represents a node in a linked list. 
     *	Each node containing data of type T while also having a reference to the next node in the linkedlist. 
     *	The constructor initializes the node with the given data and sets the next reference to null.
     * @param <T>
     */

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}
