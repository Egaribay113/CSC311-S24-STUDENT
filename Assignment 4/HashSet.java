package com.usman.csudh.csc311.adt.impl;
import com.usman.csudh.csc311.adt.Set;
import com.usman.csudh.csc311.adt.SetItemNotFoundException;


/**
 * 
 * @author Eric Garibay
 *	This HashSet class implements a set with values or objects that are non-duplicates and can be stored. 
 *	It then modifies and compensates for duplicates by utilzing its remove method or computing method. Items could
 *	then be added, removed, modified, and computed. 
 */
public class HashSet <T extends Set>{

	private static final int DEFAULT_SET_SIZE = 16;
	private static final double DEFAULT_LOAD_FACTOR = 0.75;
	
	Node[] hashBuckets=new Node[16];
	
	public HashSet() {
		hashBuckets = new Node[(int)((double)DEFAULT_SET_SIZE/DEFAULT_LOAD_FACTOR)];
	}
	
	
	public HashSet(int size) {
		hashBuckets = new Node[(int)((double)size/DEFAULT_LOAD_FACTOR)];
	}
	
	public HashSet(int size, double loadFactor) {
		hashBuckets = new Node[(int) ((double) size / loadFactor)];
	}
	
	
	/**
	 * Rehashes and adds a new node.
	 * 
	 * Creates a new node, computes to see if the position of the bukcet is empty and then it adds a node at the end
	 *  as it traverses through the list. Checks for any duplicate values.
	 * 
	 * @param item in bucekt
	 */
	public void add(int item) {
		rehash();
		//Create new node
		Node newNode = new Node(item);
		//Compute bucket (0 to length-1 of buckets array)
		int bucket = computeBucket(item);
		
		//if the position is empty then add the new node
		Node head = hashBuckets[bucket];
		if (head == null) {
			hashBuckets[bucket] = newNode;
			return;
		} 
		//traverse the list and add the new node at the end
	    Node current=head;
	    
		while (current != null) {
			//check for duplicates
			System.out.println("Current: "+current.data);
			if (current.data == item) {
				return;
			}
			current = current.next;
		}
		current.next = newNode;
		
		
	}
	
	
	/**
	 * Rehashing method used to essentially create a new array with the items of the old array. The old
	 * array stored into a new array twice the size to compensate. 
	 * Iterates through the elements in the new array and computes the new bucket index for each element
	 * based on the new array size. 
	 *  
	 *  This class is resposible for resizing the interanl array of buckets when the load factor of the set
	 *  exceeds the threshold. 
	 */
	
	private void rehash() {
		if (size() < hashBuckets.length * DEFAULT_LOAD_FACTOR) {
			return;
		}
		
		System.out.println("Reshasing...");
		//TODO: Implement rehashing
		
		Node[] backupBuckets= hashBuckets; //create a new array with old array.
		hashBuckets=new Node[backupBuckets.length*2]; //new array with twice the original size. 
		//Create a new array of buckets, twice the original size
		//Iterate over the old buckets and (computeBucket) method
		//Add the items to the new array
		
		
		for(Node n : backupBuckets) {  
			
			if(n!=null) {
				while(n!=null) {
					add(n.data);
					n=n.next;
				}
			}
			
		}
		
		 
		
			
	}
	
	/**	computeBucket method returns index, a integer has code value. It calculates an index for the hashtable
	 * and represents the position in the hash table where the item should be stored. 
	 * 
	 * @param item
	 * @return index
	 */
	
	private int computeBucket(Integer item) {
		int hash = item.hashCode();
		int index = hash % hashBuckets.length; //Calculates index for hashtable
//represents the position in the hash table where the item should be stored.
		return index; 
	}

	
	
	/**
	 * Remove method transverses through buckets and the list in that specific bucket. It searches for the node
	 * containing the item within the set. Removes the node and returns the item, if found. 
	 * 
	 * 
	 * @param item
	 * @return bucketIndex
	 * 
	 */
	public int remove(int item) throws SetItemNotFoundException {
		
		
		Node newNode = new Node(item);
		
		System.out.println("removing item from bucket");
		
		int bucketIndex = computeBucket(item);
		
	    Node current = hashBuckets[bucketIndex];
	    Node prev = null;

	    while (current != null) {
	        if (current.data == item) {
	            if (prev == null) {
	                hashBuckets[bucketIndex] = current.next; // Remove first node in the bucket
	            } else {
	                prev.next = current.next; // Remove node from middle or end of the list
	            }
	            return item; // Return removed item
	        }
	        prev = current;
	        current = current.next;
	}
		return bucketIndex;
}

	/**
	 * 
	 * Contains method iterates and transverses through buckets to find an item. If item is found it returns
	 * true, otherwise false if not found. 
	 * 
	 * @param item
	 * @return false
	 */
	public boolean contains(int item) {
		
		int bucketIndex = computeBucket(item);
	    Node current = hashBuckets[bucketIndex];
	    
	    while (current != null) {
	        if (current.data == item) {
	            return true; // Item is found in the bucket
	        }
	        current = current.next;
	    }
	    
	    return false; // Item cannot be found in the bucket.
	}

	/**
	 * 
	 * Size method iterates through the array of the hashbucket and transverses through its elements. It then returns
	 * the number of iterations to represent the size. 
	 * 
	 */
	public int size() {
		
		int count = 0;
		for (int i = 0; i < hashBuckets.length; i++) {
			Node current = hashBuckets[i];
			while (current != null) {
				count++;
				current = current.next;
			}
		}
		return count;
		
	}

	/**
	 * isEmpty method checks the size and looks to see if there are any elements within the set. 
	 * @return false
	 */
	public boolean isEmpty() {
		
		return size() == 0; 
		 
	}

	/**
	 *  clear method, clears the bucket items that are contained within the specific bucket.
	 *  It clear by setting every bucket item to null, effectively removing them.  
	 */
	public void clear() {
		
		
		for (int j = 0; j < hashBuckets.length; j++) {
			
		        hashBuckets[j] = null; //setting buckets to null and removing the elements contained within the bucket.
		    }
	}
	
	/**
	 * 
	 * toString method iterates through the array and transverses through the list of elements. 
	 * The method also prints to the console a set with brackets and its respective elements in that set. 
	 * 
	 * @return result
	 */
	public String toString() {
		String result = "{";
		for (int i = 0; i < hashBuckets.length; i++) {
			Node current = hashBuckets[i];
			while (current != null) {
				result += current.data + " ";
				current = current.next;
			}
		}
		return result += "}";
	}

}
