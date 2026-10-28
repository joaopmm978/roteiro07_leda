package adt.stack;

public class StackImpl<T> implements Stack<T> {

	protected T[] array;
	protected int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		T result = null;
		if(!isEmpty()){
			result = array[top];
		}
		return result;
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public boolean isFull() {
		return top == array.length - 1;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(!isFull()){
			array[++top] = element;
		}
		else{
			throw new StackOverflowException();
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		T result;
		if(!isEmpty()){
			result = array[top--];
			return result;
		}
		else{
			throw new StackUnderflowException();
		}
	}

}