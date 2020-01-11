package labI;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Walker Ward
 *
 * @param <E> type of data to use in this stack
 */
public class RArrayStack<E> implements Iterable<E>{
	
	private E[] data; //array with elements
	private int N; //current top of this stack

	/**
	 * Constructor
	 * Creates this stack with capacity of 8 to use as the data structure within this stack
	 * Sets top to 0
	 */
	public RArrayStack() {
		data = (E[]) new Object[8];
		N = 0;
	}
	
	/**
	 * Checks to see if this stack has any elements
	 * 
	 * @return boolean state of this stack: Does this stack have elements?
	 */
	public boolean isEmpty() {
		return this.N == 0;
	}
	
	/**
	 * Checks to see if this stack has the same number of elements as its capacity
	 * 
	 * @return boolean state of this stack: Is the number of elements equal to the capacity of this stack?
	 */
	public boolean isFull() {
		return this.N == this.data.length;
	}
	
	/**
	 * Adds an element to the top of this stack
	 * If this stack hits capacity it increases the capacity of this stack
	 * 
	 * @param elem generic element to add to this stack
	 */
	public void push(E elem) {
		if(this.isFull()) {
			this.resize(this.N);
		}
		this.data[this.N++] = elem;
	}
	
	/**
	 * pops/removes an element from the top of this stack
	 * 
	 * @return generic element removed from the top of this stack
	 */
	public E pop() {
		return this.data[--this.N];
	}
	
	/**
	 * Looks at the element under the top element in this stack
	 * 
	 * @return generic element under this stack's top element
	 */
	public E peek() {
		return this.data[this.N-1];
	}
	
	/**
	 * Increases the size of this stack by multiplying the current capacity by 2
	 * 
	 * @param capacity current size of this stack
	 */
	public void resize(int capacity) {
		E[] temp = this.data;
		capacity *= 2;
		data = (E[]) new Object[capacity];
		for(int i = 0; i < N; i++) {
			data[i] = temp[i];
		}
		//System.out.println("New Capacity: " + capacity);
	}
	

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new ReverseArrayIterator<E>();
	}
	
	@Override
	/**
	 * Converts this stack to a string for ease in printing 
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

