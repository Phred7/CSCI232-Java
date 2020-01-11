package extraCredit;

public interface ECStackInterface<E> {
	
	int size();
	boolean isEmpty();
	void push(E e);
	E top();
	E pop();

}
