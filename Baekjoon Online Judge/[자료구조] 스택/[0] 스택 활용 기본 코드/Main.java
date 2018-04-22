import java.util.Scanner;
import java.util.StringTokenizer;

class Main
{
	final static int N = 10001;
	public static int[] stack = new int[N];
	public static int top = -1;
	
	public static void push(int x){
		stack[++top] = x;
	}
	
	public static int pop() {
		if(top==-1) return -1;
		return stack[top--];
	}
	public static void initStack() {
		stack = new int [N];
		top = -1;
	}
	
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			/*
			 * 1) 스택의 사이즈(크기)를 알고 싶다면 ==> int size = top+1;
			 * 2) 스택에 x값을 PUSH 하고 싶다면 ==> push(x);
			 * 3) 스택에서 POP하고 싶다면 ==> int x = pop();
			 * 4) 스택의 TOP이 어떤 값이 알고 싶다면 ==> System.out.println(top == -1 ? -1 : Stack[top]);
			 * 5) 스택이 비었는지(empty) 알고 싶다면 ==> System.out.println(top == -1 ? 1 : 0);
			 * 6) 때에 따라서는 스택을 초기화할 필요가 있다 ==> initStack();
			 */
			break;
			
		}
	}
}