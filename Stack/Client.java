package Stack;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyStack<Integer> st = new MyStack<Integer>();
		
		st.push(1);
		st.push(6);
		st.push(0);
		
		System.out.println(st.top());
		st.push(9);
		System.out.println(st.top());
		
		System.out.println(st.pop());
		System.out.println(st.pop());

		System.out.println(st.top());		
		System.out.println(st.size());
		
	}

}
