package labI;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Walker Ward x42f827
 *
 * @param <E> generic type
 */

public class ArrayStack<E> implements Iterable<E>{
	
	private E[] data; //array with elements
	private int N; //num of element in this stack

	/**
	 * Constructor
	 * Creates an array with a given capacity to use as the data structure within this stack
	 * 
	 * @param capacity size of this stack when initialized
	 */
	public ArrayStack(int capacity) {
		data = (E[]) new Object[capacity];
		N = 0;
	}
	
	/**
	 * Checks to see if there are any elements in this stack
	 * 
	 * @return boolean value expressing current state of this stack
	 */
	public boolean isEmpty() {
		return this.N == 0;
	}
	
	/**
	 * Checks to see if this stack has the maximum number of elements
	 * 
	 * @return boolean value expressing the current state of this stack
	 */
	public boolean isFull() {
		return this.N == this.data.length;
	}
	
	/**
	 * Adds an element onto this stack
	 */
	public void push(E elem) {
		this.data[this.N++] = elem;
	}
	
	/**
	 * pops an element off the top of this stack
	 * 
	 * @return the popped generic element
	 */
	public E pop() {
		return this.data[--this.N];
	}
	
	/**
	 * Checks the element under the top of this stack
	 * 
	 * @return the generic element under the top element in this stack
	 */
	public E peek() {
		return this.data[this.N-1];
	}
	

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new ReverseArrayIterator<E>();
	}

	@Override
	/**
	 * Converts this stack to a string
	 */
	public String toString() {
		String string = "[";
		for (int i = 0; i < data.length; i++) {
			if (data[i] == null) {
				i = data.length;
				// string += null + " to index:" + (i-1);
			} else if ((i + 1) == data.length || data[i + 1] == null) {
				string += data[i];
			} else {
				string += data[i] + ", ";
			}
		}
		string += "]";
		return string;
	}
	
	public class ReverseArrayIterator<E> implements Iterator<E> {
		private int i = N-1;

		@Override
		public boolean hasNext() {
			return i >= 0;
		}

		@Override
		public E next() {
			if(!hasNext()) throw new NoSuchElementException();
			return (E) data[i--];
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

}
