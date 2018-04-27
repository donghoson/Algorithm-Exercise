import java.util.Scanner;
class Node{
    int x,y;
    Node(int x_, int y_){
        x = x_;
        y = y_;
    } 
}
 
class Solution {
    public static Node[] Queue;                     //BFS에 쓰이는 큐		
    public static int front,end;                    //큐에 쓰임
    public static int N;
    public static int[][] map;
    public static int[][] distance;					
    public static final int INF = 100000;
    public static int[] dx = {0,0,1,-1};            //동서남북 좌표 변경 용 배열
    public static int[] dy = {1,-1,0,0};            //dx는 행, dy는 열을 의미
     
    public static void push(Node xy){
        Queue[end++]=xy;
    }
    public static Node pop(){
        if(front == end) return null;
        return Queue[front++];
    }
    public static boolean isEmpty(){
        if(front == end) return true;
        else return false;
    }
    public static void initQ(){                     //각 테스트케이스마다 초기에 큐를 초기화 함
        Queue = new Node[INF];
        front=0;
        end=0;
    }
    //특정노드까지의 최단경로 거리정보를 저장하는 배열을 초기화
    public static void initDistance(){
        for(int i=0; i<distance.length; i++)
            for(int j=0; j<distance.length; j++)
                distance[i][j]=INF;
    }
     
     
    public static void main(String args[]) throws Exception {
       
        Scanner sc = new Scanner(System.in);
 
        int T;
        int test_case;
 
        T = sc.nextInt();        
        for(test_case = 1; test_case <= T; test_case++) {
            // 이 부분에서 알고리즘 프로그램을 작성하십시오. 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.
 
            N = sc.nextInt();
            //맵 정보 저장
            map = new int[N][N];
            //출발 노드부터 특정노드까지의 최단거리 정보 저장
            distance = new int[N][N];						
             
             
            sc.nextLine();
            for(int i=0; i<N; i++)
            {
                String str = sc.nextLine();
                char[] temp = str.toCharArray();
                for(int j=0; j<N; j++){
                    //char형 문자로 표현된 숫자들을 int형으로 바꾸는 테크닉
                    map[i][j]=temp[j]-'0';                  
                }
            }
            //BFS 탐색 시작
            BFS();											
 
            // 이 부분에서 정답을 출력하십시오.
            System.out.println("#"+test_case + " "+distance[N-1][N-1]);//도착점에서의 최단거리 정보 출력
        }
    }
    private static void BFS() {
        // TODO Auto-generated method stub
        initDistance();		//최단경로 거리저장하는 배열 초기화
        initQ();			//큐 초기화
        Node startNode = new Node(0,0);	//출발점의 x,y좌표를 노드로 만들어서
        push(startNode);				//큐에 push
        distance[0][0]=0;				//출발노드에서 출발노드까지의 최단거리는 0.
        while(!isEmpty()){				//큐가 빌때까지 반복한다.
            Node current =pop();		//큐의 앞부분을 뽑아서
            for(int i=0; i<4; i++){					//4방향에 대해
                int nextRow = current.x + dx[i];	//새로운 좌표를 설정한다.
                int nextCol = current.y + dy[i];
                if(nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N)  //새로운 좌표의 범위체크
                    continue;                                                   //범위를 벗어나는 좌표는 가지 않는다.
                     
                //새로운(방문예정인) 좌표까지의 최단경로보다, 현재위치까지의 최단경로의 거리 + 현재위치에서 방문예정 그 노드까지의 거리를 더한 값이 더 작다면
                //방문예정인 좌표까지의 최단경로를 갱신한다. 이전까지 새로운 좌표로 오는 경로가 무엇이 되었든간에 현재 위치하는 노드를 거쳐서 새로운 노드까지 가는것이 더 최단경로이기 때문
                if( distance[nextRow][nextCol] > distance[current.x][current.y] + map[nextRow][nextCol]){
                    distance[nextRow][nextCol] = distance[current.x][current.y] + map[nextRow][nextCol];
                    Node node = new Node(nextRow,nextCol);	//업데이트 되는 방문예정 좌표를 노드화해서
                    push(node);								//큐에 넣어준다. 이유는 업데이트되는 노드의 예전정보를 기준으로 다른 노드들이 거리정보를 가지고 있었으므로
                }											//그 노드로부터 영향받는 다른 노드들의 거리정보도 업데이트 해야하기 때문이다.
                 
            }
        }
    }
}
