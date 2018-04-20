import java.util.Scanner;
import java.util.StringTokenizer;

class Main
{
	public static int[] Stack = new int[10001];
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
		sc.nextLine();	//nextInt() 다음에 오는 nextline()은  '\n'을 의미 
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			

			String str=sc.nextLine();
		    StringTokenizer tokenizer=new StringTokenizer(str," ");
		    
//		    while(tokenizer.hasMoreTokens()){
//		      System.out.print(tokenizer.nextToken());
//		    }		    
//		    System.out.println();
		    
		    
		   String tmp = tokenizer.nextToken();

           if(tmp.equals("push")){
        	   tmp=tokenizer.nextToken();
        	   int num = Integer.parseInt(tmp);
        	   push(num);
			}
			else if(tmp.equals("pop")) {
				System.out.println(pop()); 
			}
			else if(tmp.equals("size")) {
				System.out.println(top+1);
			}
			else if(tmp.equals("empty")) {
				System.out.println(top == -1 ? 1 : 0);
			}
			else if(tmp.equals("top")) {
				System.out.println(top == -1 ? -1 : Stack[top]);
			}
			else System.out.println("error");

		}
	}
}