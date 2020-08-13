package uk.co.np.data;
@SuppressWarnings("unchecked")
public class Queue<T> {
	private static final int MAX_QUEUE_LENGTH = 4;
	private Object[] queue = new Object[MAX_QUEUE_LENGTH];
	private int head = 0, tail = head;
	private boolean isEmpty = true; 
	
	//Enqueue() -> head++;
	//Dequeue() -> tail++
	//Head == tail -> empty
	//Head >  tail -> not empty
	//Head %= length
	//tail %= length
	
	public void Enqueue(T item) {
		queue[head++] = item;
		WrapHeadAndTail();
	}
	
	public T Dequeue() {
		T output = (T) queue[tail++];
		WrapHeadAndTail();
		return output;
	}
	
	public T Peek() {
		return (T) queue[tail];
	}
	
	public boolean IsEmpty() {
		return isEmpty;
	}
	
	private void WrapHeadAndTail() {
		head %= MAX_QUEUE_LENGTH;
		tail %= MAX_QUEUE_LENGTH;
		isEmpty = (head == tail);
	}
	
	@Override
	public String toString() {
		String out = "{";
		int idx = 0;
		for(Object item : queue) {
			if(idx == head) out += "H";
			if(idx == tail) out += "T";
			if(item != null) out += "["+item+"] ";
			idx++;
		}
		out = out.trim();
		out += "}";
		return out;
		
	}
}
