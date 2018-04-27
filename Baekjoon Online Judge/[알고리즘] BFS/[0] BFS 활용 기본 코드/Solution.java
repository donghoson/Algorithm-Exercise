import java.util.Scanner;

class Main
{
	final static int N = 10001;
	public static int[] Queue;					//BFS는 큐가 기본적으로 필요함.
	public static boolean isVisited[];
	public static int hasRoad[][];
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
			//큐 초기화
			initQueue();
			 
			//isVisited 배열 초기화
			isVisited = new boolean[N];
			for(int i=0; i<N; i++)
				isVisited[i]=false;
			
			//hasRoad[x][y] 을 초기화하는 처리가 필요. x 에서 y로 가는 길이 있다면 hasRoad[x][y] = 1로 표시한다.
			
			//BFS호출
			BFS();
			break;
		}
	}
	
    private static void BFS() {				//BFS는 DFS와 다르게 재귀로 하지 않아도 됨.
        int start = 0;						//출발지 노드를 선택
        push(start);						//출발지 노드를 큐에 push  #큐에 넣을때는 isVisited도 true로!
        isVisited[start] = true;			//출발노드를 방문.
        while(!isEmpty())					//큐가 빌때까지 반복한다.
        {
        	int current =pop();				//큐의 앞부분을 뽑아서
            for(int next=0; next<N; next++)	//해당 노드와 연결되고, 아직 방문(탐색)하지 않은 노드들을 방문하고 큐에 push					
            {
            	if(hasRoad[current][next] == 1 && isVisited[next] == false) 
                {
                    isVisited[next] = true; //#큐에 넣을때는 isVisited도 true로!
                    push(next);
                }
            }
        }
    }
	
	
}