import java.util.Scanner;
import java.io.FileInputStream;

/* 사용하는 클래스명이 Solution 이어야 하며, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해 볼 수 있습니다. */

class Solution {
	public static void main(String args[]) throws Exception	{
		/* 아래 메소드 호출은 앞으로 표준입력(키보드) 대신 sample_input.txt 파일로 부터 읽어오겠다는 의미의 코드입니다.
		   만약 본인의 PC 에서 테스트 할 때는, 입력값을 sample_input.txt에 저장한 후 이 코드를 첫 부분에 사용하면,
		   표준입력 대신 sample_input.txt 파일로 부터 입력값을 읽어 올 수 있습니다.
		   또한, 본인 PC에서 아래 메소드를 사용하지 않고 표준입력을 사용하여 테스트하셔도 무방합니다.
		   단, Codeground 시스템에서 "제출하기" 할 때에는 반드시 이 메소드를 지우거나 주석(//) 처리 하셔야 합니다. */
		Scanner sc = new Scanner(new FileInputStream("src/sample_input.txt"));
        
		//Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();        
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오. 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.
			
			int N = sc.nextInt();//정거장 수
			int M = sc.nextInt();//철로
			int K = sc.nextInt();//비용(할인권)
			int RESULT=0;
			
//			System.out.println("정거장 수"+N+"\t철로 수"+M+"\t할인권 비용"+K);
			
			//거리를 저장하는 2차원 배열 생성
			int[][] D = new int[N][N];
			int[][] p = new int[N][N];//Floyd2 알고리즘을 위해 필요
			
			//D배열을 9999로 초기화 및 행과열이 같은경우(출발지와 목적지가 같은경우)에는 0으로 설정
			for (int i=0;i<N;i++)
				for (int j=0;j<N;j++)
				{	
					if(i==j) D[i][j]=0;
					else D[i][j]=9999;
				}
			//p배열도 0으로 초기화
			for (int i=0;i<N;i++)
				for (int j=0;j<N;j++)
					p[i][j]=0;
			
			for (int i=0;i<M;i++)
			{
				int A = sc.nextInt();
				int B = sc.nextInt();
				int C = sc.nextInt();
				D[A-1][B-1] = C;
				D[B-1][A-1] = C;
			}

/*		
			//초기 D배열 확인하기 위해 출력
			System.out.println();
			for (int i=0;i<N;i++)
			{	for (int j=0;j<N;j++)
					System.out.print(D[i][j]+"\t");
				System.out.println();
			}
*/
			
			//Floyd2 알고리즘 적용
			for (int k=0;k<N;k++)
				for (int i=0;i<N;i++)
					for (int j=0;j<N;j++)
						if(D[i][k]+D[k][j] < D[i][j])
						{
							p[i][j]=k;
							D[i][j]=D[i][k]+D[k][j];
						}
/*			
			//Floyd2 알고리즘 적용이 잘 되었는지 출력해서 확인해보는 코드
			System.out.println();
			for (int i=0;i<N;i++)
			{	for (int j=0;j<N;j++)
					System.out.print(D[i][j]+"\t");
				System.out.println();
			}
*/
			
			//여행계획 경로의 갯수=P  배열p와 다름
			int P = sc.nextInt();
			for (int i=0;i<P;i++)
			{
				int From = sc.nextInt();
				int To = sc.nextInt();
				if (D[From-1][To-1] > K)
					RESULT++;
			}

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(RESULT);
			
		}
	}
}