/* 아래 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.
   단, 사용하는 클래스명이 Solution 이어야 하며, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해 볼 수 있습니다. */
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception	{
		/* 아래 메소드 호출은 앞으로 표준입력(키보드) 대신 input.txt 파일로 부터 읽어오겠다는 의미의 코드입니다.
		   만약 본인의 PC 에서 테스트 할 때는, 입력값을 input.txt에 저장한 후 이 코드를 첫 부분에 사용하면,
		   표준입력 대신 input.txt 파일로 부터 입력값을 읽어 올 수 있습니다.
		   또한, 본인 PC에서 아래 메소드를 사용하지 않고 표준입력을 사용하여 테스트하셔도 무방합니다.
		   단, Codeground 시스템에서 "제출하기" 할 때에는 반드시 이 메소드를 지우거나 주석(//) 처리 하셔야 합니다. */
		Scanner sc = new Scanner(new FileInputStream("src/sample_input.txt"));
        
		//Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;

		TC = sc.nextInt();        
		for(test_case = 1; test_case <= TC; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			int N = sc.nextInt();
			int K = sc.nextInt();
			sc.nextLine();
			String Line =sc.nextLine();
			int x=1;
			int y=1;
			//N이 큰 수이면,SUM이 int의 범위를 넘어갈 정도의 크기가 될 수 있으므로 long 타입을 사용한다.
			long SUM=1;
			for(int i=0; i<K;i++)
			{
				char DIRECTION =Line.charAt(i);
				if (DIRECTION == 'D') x++;
				else if (DIRECTION == 'U') x--;
				else if (DIRECTION == 'R') y++;
				else if (DIRECTION == 'L') y--;
				else System.out.println("ERROR");
				
				/*6행 6열 배열을 기준으로 시작점을 (1,1) 끝점을 (6,6)으로 생각하고 풀었다.
				오른쪽 맨위와 왼쪽 맨아래를 잇는 대각선을 기준으로,대각선 포함한 왼쪽의 배열(좌표)은 일종의 규칙이 있다.
				좌표 (x,y)의 x+y값과 x+y-1값의 평균에서 1을 더하고 x 또는 y를 빼면 해당 좌표의 수가 해당된다.
				대각선의 오른쪽에 해당되는 배열(좌표)은 해당하는 수를 찾기가 어려웠는데, 쉽게 생각하면 이미 구한 좌표들의 규칙을 역이용하면 된다.
				제일 작은 좌표(1,1)의 1과 (6,6)의 36을 더한 37에서, 그 좌표의 대각선 대칭점 값을 빼주면 구할 수 있다.
				*/
				if (x+y<=N+1)//대각선을 포함하여 대각선 왼쪽의 경우
				{
					if ((x+y)%2 == 0) 
					{
						int V = ((x+y)*(x+y-1))/2-x+1; 
						SUM += V;
					}
					else 
					{
						int W = ((x+y)*(x+y-1))/2-y+1; 
						SUM += W;
					}
				}
				else//대각선 오른쪽의 경우 
				{
					//대각선을 기준선으로 대칭되는 좌표를 구한다.
					int X=N+1-x;
					int Y=N+1-y;
					//대칭좌표를 구해서 그 값을 1+N^2에서 빼주면 원하는 좌표값을 구할 수 있다.
					if ((X+Y)%2 == 0) 
					{
						int V = ((X+Y)*(X+Y-1))/2-X+1;
						SUM += ((1+N*N)-V);
					}
					else 
					{
						int W = ((X+Y)*(X+Y-1))/2-Y+1;
						SUM += ((1+N*N)-W);
					}
				}
			}
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(SUM);
			
		}
	}
}