package labV;


/**
 * This class was copied directly from: "Data Structure and Algorithms in Java"
 * @author Java Book 
 *
 * This class creates a stack built into an array
 * @param <E> type of object this stack will utilize
 */
public class ArrayStack<E> implements Stack<E> {
	public static final int CAPACITY = 12000;
	private E[] data;
	private int t = -1;

	/**
	 * Constructor
	 * Defaults the capacity of this Stack
	 */
	public ArrayStack() {
		this(CAPACITY);
	}

	@SuppressWarnings("unchecked")
	/**
	 * Constructor
	 * @param capacity size of this Stack
	 */
	public ArrayStack(int capacity) {
		data = (E[]) new Object[capacity];
	}

	/**
	 * Gets the size of this Stack
	 * @return size/length/number of elements on this Stack
	 */
	public int size() {
		return (t + 1);
	}

	/**
	 * Checks to see if there are any elements on this Stack
	 * @return true if this Stack is empty and false if this Stack has elements on it
	 */
	public boolean isEmpty() {
		return (t == -1);
	}

	/**
	 * Adds element e to (the top of) this Stack
	 */
	public void push(E e) throws IllegalStateException {
		if (this.size() == data.length)
			throw new IllegalStateException("Stack is full");
		data[++t] = e;
	}

	/**
	 * Gets the top/first element on this Stack
	 * @return the top/first element on this Stack
	 */
	public E top() {
		if (this.isEmpty())
			return null;
		return data[t];
	}

	/**
	 * Removes the top/first element on this Stack
	 * @return the popped/top/first element on this Stack
	 */
	public E pop() {
		if (this.isEmpty())
			return null;
		E answer = data[t];
		data[t] = null;
		t--;
		return answer;
	}

	@Override
	/**
	 * Converts this Stack to a String for easy printing
	 * @returns String version of this Stack
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

}
