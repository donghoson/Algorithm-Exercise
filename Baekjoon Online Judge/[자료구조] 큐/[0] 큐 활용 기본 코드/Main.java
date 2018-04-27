import java.util.Scanner;

class Main
{
	final static int N = 10001;
	public static int[] Queue;
	public static int front,end;
	
	public static void initQueue() {
		front=end=0;
		Queue = new int[N];
	}
	public static boolean isEmpty() {
		if(front == end) return true;
		else return false;
	}
	public static void push(int x){
		Queue[end++] = x;
	}
	
	public static int pop() {
		if(isEmpty()) return -1;
		return Queue[front++];
	}
	
	
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			/*
			 * 1) 때에 따라서는 큐를 초기화할 필요가 있다 ==> initQueue();
			 * 2) 큐에 x값을 PUSH 하고 싶다면 ==> push(x);
			 * 3) 큐에서 POP하고 싶다면 ==> int x = pop();
			 * 4) 큐가 비었는지(empty) 알고 싶다면 ==> isEmpty();
			 * 5) 큐의 사이즈(크기)를 알고 싶다면 ==> int size = end-front;
			 */
			break;
			
		}
	}
}