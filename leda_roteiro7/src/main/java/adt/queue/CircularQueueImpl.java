package adt.queue;

@SuppressWarnings("unused")
public class CircularQueueImpl<T> implements Queue<T> {

	protected T[] array;
	protected int tail;
	protected int head;
	protected int elements;

	@SuppressWarnings("unchecked")
	public CircularQueueImpl(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {

		if (!isFull()) {
			tail++;
			if (tail > array.length - 1) {
				tail = tail % array.length;
			}
			array[tail] = element;
			if (isEmpty()) {
				head = tail;
			}
			elements++;
		} else {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (!isEmpty()) {
			T result = head();
			head++;
			elements--;
			if (head > array.length - 1) {
				head = 0;
			}
			return result;
		} else {
			throw new QueueUnderflowException();
		}
	}

	@Override
	public T head() {
		T result = null;
		if (!isEmpty()) {
			result = array[head];
		}
		return result;
	}

	@Override
	public boolean isEmpty() {
		return elements == 0;
	}

	@Override
	public boolean isFull() {
		return elements == array.length;
	}

}
