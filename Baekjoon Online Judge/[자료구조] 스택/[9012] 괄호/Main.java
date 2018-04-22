import java.util.Scanner;
import java.io.FileInputStream;

class Main
{
	static char[] stack = new char[50];
	static int top = -1;
	
	public static void push(char x) {
		stack[++top]=x;
	}
	public static char pop() {
		if(top==-1) return 'N';
		return stack[top--];
	}
//	public static void printStack() {
//		for(int i=0; i<=top; i++)
//			System.out.print(stack[i]);
//		System.out.println();
//	}
	public static void initStack() {
		stack = new char[50];
		top = -1;
	}

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		sc.nextLine(); //nextInt 다음에 문자열 받을 때는 '\n'하나를 날려야 함.
		for(int test_case = 1; test_case <= T; test_case++)
		{		
			initStack();
			
			String str = sc.nextLine();
			char[] tmp = str.toCharArray();
			for(int i=0; i<tmp.length; i++){
				if(tmp[i]=='(')					//'('가 들어오면 그냥 push
					push('(');
				else						//')'가 들어온 경우
					if(top==-1) {				//스택이 empty이면 ')'를 push할 수 없음
						top++;				//top을 -1이 아니게 만든다. 
						break;
					}
					else if(stack[top]=='(')		//스택의 top이 '('인 경우
						pop();				//top을 pop시킨다.
			}
			System.out.println(top==-1 ? "YES" : "NO");	
		}
		
	}
}
