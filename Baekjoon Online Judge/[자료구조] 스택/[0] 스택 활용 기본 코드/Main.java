import java.util.Scanner;
import java.util.StringTokenizer;

class Main
{
	final static int N = 10001;
	public static int[] Stack = new int[N];
	public static int top = -1;
	
	public static void push(int x){
		Stack[++top] = x;
	}
	
	public static int pop() {
		if(top==-1) return -1;
		return Stack[top--];
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
			 */
			break;
			
		}
	}
}