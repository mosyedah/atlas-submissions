package fromTreesDay16;

public class StackWithArrays {
	public static void main(String[] args) {

		MyStack stack = new MyStack(5);

		stack.push(20);
		stack.push(10);
		stack.push(30);

		System.out.println(stack);

		System.out.println("Top element: " + stack.peek());
		System.out.println("Size: " + stack.size());

		System.out.println("Popped: " + stack.pop());
		System.out.println("New top: " + stack.peek());
		
		System.out.println(stack);

	}

	// Stack with primitive array
	static class MyStack {
		private int maxSize;
		private int size;
		private int array[];

		MyStack() {
			this(20);
		}

		MyStack(int maxSize) {
			this.maxSize = maxSize;
		}

		void push(int data) {
			if (array == null) {
				array = new int[maxSize];
				array[0] = data;
				size++;
				return;
			} else {
				if (size == maxSize) {
					throw new RuntimeException("Stack is full");
				}
				array[size] = data;
				size++;
			}
		}

		int peek() {
			if (isEmpty()) {
				throw new RuntimeException("Stack is Empty");
			}
			return array[size - 1];
		}

		int size() {
			return size;
		}

		boolean isEmpty() {
			return size == 0;
		}

		int pop() {
			if (isEmpty()) {
				throw new RuntimeException("Stack is Empty");
			}
			int data = array[--size];
			return data;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[ ");
			for (int i = size - 1; i >= 0; i--) {
				builder.append(array[i]);

				if (i != 0) {
					builder.append(", ");
				}
			}
			builder.append(" ]");
			return new String(builder);
		}
	}

}
