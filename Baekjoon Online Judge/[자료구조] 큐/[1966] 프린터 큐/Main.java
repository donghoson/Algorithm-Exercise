import java.util.Scanner;

class Main
{
	final static int N = 6000;
	static int[] queue = new int[N];
	public static int end = 0;		//입구(들어갈 자리임, 빈 공간)
	public static int front = 0;	//출구
	
	public static void push(int x) {
		queue[end++] = x;
	}
	public static int pop() {
		if(front==end) return -100;
		return queue[front++];
	}
	public static int size() {
		return end-front;
	}
	public static boolean isEmpty() {
		return front == end ? true:false;
	}
	public static void initQueue() {
		queue = new int[N];
		end = front = 0;
	}

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{		
			initQueue();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int cnt = 0;
			for(int i=0; i<N; i++) {					//입력받는 수들을 일단 큐에 저장한다.
				int x =sc.nextInt();
				push(x);
			}
		
			for(int p=0;p<N;p++) {						//원하는 수가 출력되는 과정은 최대 N번 반복하도록 설정한다.
				int maxValue = 0;
				int maxIndex = 0;
				for(int i=front; i<end; i++) {			//큐에서 가장 큰 수가 가장 먼저 출력되므로 가장 큰수와 그 인덱스를 알아낸다.
					if(maxValue < queue[i]) {
						maxValue = queue[i];
						maxIndex = i;
					}
				}

				for(int i=front; i<maxIndex; i++) {		//중요도가 가장 큰 수보다 앞쪽에 있는 숫자들은 차례차례 뒤로 push한다. 
					if(i == M) M=end;					//이 때 우리가 출력하고 싶은 문서도 push 해야 한다면, 새로운 위치를 기억한다.
					int x = pop();
					push(x);
				}
				if(front == M) {						//정렬이 완료된 상태이다. == 가장 큰수가 맨 앞에 있다.
					++cnt;								//보통 front에서 pop이 일어나는데, front가 우리가 출력하길 원하는 숫자의 위치라면
					break;								//출력횟수를 증가시키고 프로그램 종료한다.
				}
				
				pop();								//front가 우리가 출력하길 원하는 숫자의 위치와 다르다면, pop을 해버리고
				cnt++;								//출력회수를 증가시킨 후 다시 맨 위 for문으로 돌아가서 maxValue부터 다시 찾는 작업을 수행한다.
				
				
				
			}
			System.out.println(cnt);
			
		}
		
	}
}