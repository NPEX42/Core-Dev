package uk.co.np.data;

@SuppressWarnings("unchecked")
public class Buffer<T> {
	private Object[] buffer;
	private int pointer;
	public Buffer() {
		buffer = new Object[128];
	}
	public Buffer(int capacity) {
		buffer = new Object[capacity];
	}
	
	public void Put(T item) {
		buffer[pointer++] = item;
	}
	
	public T Get(int relIndex) {
		int absoluteIndex = pointer + relIndex;
		if(absoluteIndex < 0) return null;
		if(absoluteIndex > buffer.length) return null;
		
		return (T) buffer[absoluteIndex];
	}
}
