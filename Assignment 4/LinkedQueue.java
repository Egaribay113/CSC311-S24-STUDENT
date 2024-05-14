package com.usman.csudh.csc311.adt.impl;
import com.usman.csudh.csc311.adt.List;
import com.usman.csudh.csc311.adt.ListInvalidIndexException;
import com.usman.csudh.csc311.adt.Queue;
import com.usman.csudh.csc311.adt.QueueEmptyException;

/**
 * @author Eric Garibay
 * A linked list implementation of a queue. This implementation uses forward linking nodes
 * to provide the queue functionality. Uses Java generics to accept any parameter data type. 
 */
public class LinkedQueue<T extends Queue> {

    Node<T> head;

    public LinkedQueue() {
        head = null;
    }

    /**
     * Add() method evaluates whether the head node is null. If so, the head is set to the newNode which is the
     * data parameter being thrown in. It then finds the tail to set the tail to the next reference of the tail node to point to the new node,
     * adding it to the end of the list.
     */
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> tail = findTail();
            tail.next = newNode;
        }
    }

    /**
     * Remove() method evaluates whether the head is null and if it is true then it throws an exception.
     * Makes the head node the next node reference.
     * The method then removes the node and returns the item or data stored within that removed node.
     */
    public T remove() throws QueueEmptyException {
        if (head == null) {
            throwQueueEmptyException();
        }

        Node<T> itemNode = head;
        head = head.next;
        return itemNode.data;
    }

    /**
     * Peek() method checks if the head is null, if it is, it throws an exception.
     * Otherwise, it returns the data within the head node.
     */
    public T peek() throws QueueEmptyException {
        if (head == null) {
            throwQueueEmptyException();
        }
        return head.data;
    }

    /**
     * size() method returns the number of elements in the linked list which is the size.
     * It counts the number of nodes as it traverses through the list.
     */
    public int size() {
        Node<T> current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * Determines whether the linked list is empty and returns
     * the head as null if this evaluates to true (the linked list is empty).
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Clears the linked list and sets the head to null
     */
    public void clear() {
        head = null;
    }

    /**
     * Method finds the tail by traversing through the head nodes
     * until finding the last node and then returns that last node as the tail.
     * Since the last node is the tail.
     *
     * @return Returns the tail of the list
     */
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
     * Throws the error if it finds that the queue is empty.
     *
     * @throws QueueEmptyException
     */
    private void throwQueueEmptyException() throws QueueEmptyException {
        throw new QueueEmptyException("Queue is empty");
    }

    /**
     * Node class for representing elements in the linked list.
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
