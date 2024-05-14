package com.usman.csudh.csc311.adt.impl;
import java.util.List;
import java.util.ArrayList; 

import com.usman.csudh.csc311.adt.Map;

/**
 * 
 * @author Eric Garibay
 *	HashMap class implemented to create a list of keys and values that can be 
 *	effectively modified, deleted, inserted, and rehashed.   
 */

public class HashMap <T extends Map>{
	
	//Intitial bucket size
	private static final int DEFAULT_BUCKET_SIZE = 16;
	
	//default load factor
	private static final double DEFAULT_LOAD_FACTOR = 0.75;
	
	//Buckets
	MapNode buckets[];
						//MapNode<T>[] buckets; ???
	double loadFactor;
	
	
	public HashMap() {
		loadFactor = DEFAULT_LOAD_FACTOR;
		buckets = new MapNode[DEFAULT_BUCKET_SIZE];		
	}
	
	public HashMap(int maxItems) {
		this(maxItems, DEFAULT_LOAD_FACTOR);
	}
	
	public HashMap(int maxItems, double loadFactor) {
		buckets = new MapNode[(int)((double)maxItems/loadFactor)];
	}
	
	
	/**
	 * computeBucket method takes a string input and then calculates hash code according to the given key. 
	 * This method then maps hash code to a bukcet index within an array of buckets and uses modulus operator to then
	 * create the index to be within the range of buckets that can be used. Returns the indezx of the bucket that the input is to 
	 * be placed. 
	 * @param key
	 * @return index
	 */
	private int computeBucket(String key) {
		int hash = key.hashCode();
		
		//evaluate a value between 0 and 15
		int index = hash % buckets.length;
		return index;
	}
	
	
	/**
	 * rehash method checks the size of the map and determines whether to rehash or not. The contents of the old array are then
	 * stored in a new array double the size of the original one to ensure that values can be rehashed and place into their 
	 * corresponding position. Transverses through the list of nodes in the old array and begins the process of rehashing. 
	 */
	private void rehash() {
	    if (size() < buckets.length * loadFactor) {
	        return;
	    }
	    
	    System.out.println("Rehashing");
	    
	    MapNode[] oldBuckets = buckets;
	    buckets = new MapNode[oldBuckets.length * 2];
	    
	    for (MapNode oldNode : oldBuckets) {
	        while (oldNode != null) {
	            put(oldNode.key, oldNode.value);
	            //size(); 
	            oldNode = oldNode.next; // Move to the next node in the old bucket
	        }
	    }
	}
	
	
	/**
	 * 
	 * put method adds or updates key-value pairs in the hashmap, ensuring that each key is associates with a unique value.
	 * Transverses through the list to check for duplicate keys. 
	 * This method then handles any collisions by using linked lists in the buckets.  
	 * @param key
	 * @param value
	 */
	public void put(String key, String value) {
		rehash();
		MapNode newNode = new MapNode(key, value);
		
		int bucket= computeBucket(key);
		MapNode head = buckets[bucket];
		
		
		if (head == null) {
			head = newNode;
			buckets[bucket] = head;
			return;
		}
		
		MapNode current = head;
		
		while (current.next != null) {
			current = current.next;
		
			//Ensure there is no duplicate key
			if (current.key.equals(key)) {
				current.value = value;
				return;
			}
		}	
		current.next = newNode;
	}

	/**
	 * get() method computes the map and checks to see if it is empty. It then transverses through the nodes until it finds a key,
	 * if no key is found as it transverses, then it returns null. 
	 * 
	 * @param key
	 */
	public String get(String key) {
		int bucket= computeBucket(key);
		MapNode head = buckets[bucket];
		//return null if the map is empty
		if (head == null) {
			return null;
		}
		
		//if map is not empty then start from head
		// and keep moving to the next node until the key is found
		MapNode current = head;
		
		while (current != null) {
			if (current.key.equals(key)) {
				return current.value;
			}
			current = current.next;
		}
		return null;
	}
	/**
	 * toString() method prints out a set using brackets. 
	 */
	public String toString() {
		String result = "{";
//		MapNode current = head;
//		while (current != null) {
//			result += current.key + " : " + current.value + "\n";
//			current = current.next;
//		}
		return result+="}";
	}

	
	
	/**
	 * Remove() method returns a key or value from removing a node in the bucket. Transversing through each value 
	 * in the node and then returning if theres any key or value found. 
	 * @param key
	 * @return null
	 */
	public String remove(String key) {
		
		int bucketIndex = computeBucket(key);
	    MapNode current = buckets[bucketIndex];
	    MapNode prev = null;

	    while (current != null) {
	        if (current.key.equals(key)) {
	            if (prev == null) {
	                buckets[bucketIndex] = current.next; // Remove first node in the bucket
	            } else {
	                prev.next = current.next; // Remove node from middle or end of the list
	            }
	            return current.value; // Return the value of the removed node
	        }
	        prev = current;
	        current = current.next;
	    }
	    
	    return null; // Key not found
		
		
	}

	/**
	 * containsKey() method will transverse the list to find a key within a node of a bucket and return false if nothing found. 
	 * @param key
	 */
	public boolean containsKey(String key) {
		
		int bucketIndex = computeBucket(key);
	    MapNode current = buckets[bucketIndex];
	    
	    while (current != null) {
	        if (current.key.equals(key)) {
	            return true; //returns true if there is a key. 
	        }
	        current = current.next;
	    }
	    
	    return false; // If Key not found in any node of bucket. 
	}

	/**
	 * 
	 * containsValue() method checks for specific values within the hashMap. Iterates through list of key value pairs,
	 * compares the parameter value with every key within the map and returns true if hashMap contains specificied value, 
	 * otherwise false if no key values are found. 
	 * 
	 * @param value
	 */
	public boolean containsValue(String value) {
		
		for (MapNode bucket : buckets) {
	        MapNode current = bucket;
	        while (current != null) {
	            if (current.value.equals(value)) {
	                return true; // Value found
	            }
	            current = current.next;
	        }
	    }
	    return false; //If no value is found. 
		
		
		
	}

	/**
	 * size () method iterates through buckets, count the number of nodes as it transverses through every node.
	 * returns the number of iterations to get the size. 
	 */
	public int size() {
		//Iterate through the buckets and count the number of nodes
		int count = 0;
		for (int i = 0; i < buckets.length; i++) {
			MapNode current = buckets[i];
			while (current != null) {
				count++;
				current = current.next;
			}
		}
		return count;
	}

	/**
	 * isEmpty() method checks the size of hashMap for any key values.  
	 */
	public boolean isEmpty() {
		
		
		 return size() == 0;
		
	}

	/**
	 * Transverses through every bucket and sets the contents within the bucket to null.
	 * This effectively clears all the elements within the hashMap. 
	 */
	
	public void clear() {
		
		for (int x = 0; x < buckets.length; x++) {
	        buckets[x] = null;
	    }
		
		
	}
	
	/**
	 * Keys() method retrieves the keys stored within the hashMap and then returns them
	 * as an array of strings. Converting from an arrayList to an array of Strings. Moreso, 
	 * this method transverses using a for loop through every bucket and node to then retrieve 
	 * the key at the specific bukcet and return it as an array of Strings. 
	 * @return
	 */
	

	public String[] keys() {
		
		 List<String> keys = new ArrayList<>(); //place keys into an array list to then retrive later. 
		 
		 for (int i = 0; i < buckets.length; i++) {
			    MapNode current = buckets[i];
			    while (current != null) {
			        keys.add(current.key);
			        current = current.next;
			    }
		 
		 
		
			   
		 }
		 return keys.toArray(new String[0]); //store list of keys into an array to then retrive or return back. 
	}

	/**
	 * For this method we place values into an array list, iterating through each bucket and every node, effectively
	 * adding every value to the arrayList. This list is then converted into an array of strings to then be retrived. 
	 * @return an array that was an arrayList of values. 
	 */
	
	public String[] values() {
		
		 List<String> values = new ArrayList<>(); //place values into an array list to then retrieve later. 
		 
		 for (int k = 0; k < buckets.length; k++) {
			    MapNode current = buckets[k];
			    while (current != null) {
			        values.add(current.key);
			        current = current.next;
			    }
		
		
	  }
		 return values.toArray(new String[0]);

	}
}
