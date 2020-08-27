package Stack;

import java.util.ArrayList;

public class MyStack<T> {
	ArrayList<T> list;

	MyStack() {
		list = new ArrayList<>();
	}

	public void print() {
		System.out.print("[");
		for (int i = list.size() - 1; i > 0; i--) {
			System.out.print(list.get(i) + ",");
		}

		System.out.println(list.get(0) + "]");
	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.size() == 0;
	}

	public T top() {
		if (list.size() == 0) {
			System.err.println("StackIsEmpty");
			return null;
		}

		return list.get(list.size() - 1);
	}

	public void push(T data) {
		list.add(data);
	}

	public T pop() {
		if (list.size() == 0) {
			System.err.println("StackIsEmpty");
			return null;
		}

		T data = list.remove(list.size() - 1);
		return data;
	}
}
