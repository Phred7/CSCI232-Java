package extraCredit;

public class ECStack<E> implements ECStackInterface<E> {
	
	private int capacity = 2;
	private E[] data;
	private int n = -1;
	
	public ECStack() {
		data = (E[]) new Object[capacity];
	}
	
	public int size() {
		return n + 1;
	}
	
	public boolean isEmpty() {
		return (n == -1);
	}
	
	/*
	 * public void push(E e) throws IllegalStateException{ if(this.size() ==
	 * data.length) throw new IllegalStateException("Stack is full"); data[++n] = e;
	 * }
	 */
	
	public void push(E e) throws IllegalStateException{
		if(this.size() == data.length) 
			incCapacity();
		data[++n] = e;
	}
	
	public E top() {
		if(this.isEmpty())
			return null;
		return data[n];
	}
	
	public E pop(){
		if(this.isEmpty())
			return null;
		E answer = data[n];
		data[n] = null;
		n--;
		if(this.capacity/2 > this.size()) {
			this.decCapacity();
		}
		return answer;
	}
	
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
	
	public void incCapacity() {
		E[] temp = this.data;
		this.capacity *= 2;
		data = (E[]) new Object[this.capacity];
		for(int i = 0; i <= n; i++) {
			data[i] = temp[i];
		}
		//System.out.println("Capacity increased to " + this.capacity);
	}
	
	public void decCapacity() {
		E[] temp = this.data;
		this.capacity /= 2;
		data = (E[]) new Object[this.capacity];
		for(int i = 0; i <= n; i++) {
			data[i] = temp[i];
		}
		//System.out.println("Capacity decreased to " + this.capacity);
	}
	
	public boolean search(E element) {
		for(int i = 0; i < this.size(); i++) {
			if(this.data[i] == element) {
				return true;
			}
		}
		return false;
	}

}

