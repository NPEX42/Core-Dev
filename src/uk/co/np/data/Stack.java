package uk.co.np.data;
@SuppressWarnings("unchecked")
public class Stack<T> {
	private static final int MAX_STACK = 256;
	private Object[] stack = new Object[MAX_STACK];
	private int stackPointer = 0;
	
	//Push -> ++stackpointer
	//Pop -> --stackpointer
	public void Push(T item) {
		stack[++stackPointer] = item;
	}
	
	public T Pop() {
		return (T) stack[stackPointer--];
	}
	
	public T Peek() {
		if(stackPointer > 0) {
			return (T) stack[stackPointer - 1];
		} else {
			return null;
		}
	}
	
	public T GetItem(int index) {
		int indexAbsolute = stackPointer + index;
		if(indexAbsolute < 0) return null;
		if(indexAbsolute > MAX_STACK) return null;
		
		return (T) stack[indexAbsolute];
	}
	@Override
	public String toString() {
		String out = "{";
		for(Object item : stack) {
			if(item != null) out += "["+item+"] ";
		}
		out = out.trim();
		out += "}";
		return out;
		
	}
} 
