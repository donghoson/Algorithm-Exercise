import java.util.Scanner;
import java.io.FileInputStream;

/* 사용하는 클래스명이 Solution 이어야 하며, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해 볼 수 있습니다. */

class Solution {

	public static void main(String args[]) throws Exception	{
		/* 아래 메소드 호출은 앞으로 표준입력(키보드) 대신 input.txt 파일로 부터 읽어오겠다는 의미의 코드입니다.
		   만약 본인의 PC 에서 테스트 할 때는, 입력값을 input.txt에 저장한 후 이 코드를 첫 부분에 사용하면,
		   표준입력 대신 input.txt 파일로 부터 입력값을 읽어 올 수 있습니다.
		   또한, 본인 PC에서 아래 메소드를 사용하지 않고 표준입력을 사용하여 테스트하셔도 무방합니다.
		   단, Codeground 시스템에서 "제출하기" 할 때에는 반드시 이 메소드를 지우거나 주석(//) 처리 하셔야 합니다. */
		Scanner sc = new Scanner(new FileInputStream("src/sample_input.txt"));
		//Scanner sc = new Scanner(System.in);

		int T;
		int test_case;
		int MOD = 1000000009;
		T = sc.nextInt();        
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오. 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.
        
			int N = sc.nextInt();
			int K = sc.nextInt();
			int L = sc.nextInt();
			
			//0번 돌부터 N번 돌까지 담을수 있는 배열을 생성
			int[] bridge = new int[N+1];
			//0번 돌에는 0, 1번돌에는 1, 2번 돌에는 2, ... , N번 돌에는 N을 표시
			for(int i=0;i<N+1;i++)
				bridge[i]=i;
			//지뢰가 있는 돌은 -1을 곱해서 음수로 표시
			for(int i=0;i<L;i++)
				bridge[sc.nextInt()] *= -1;

			int[][] dp = new int[N+1][K+1];
			for(int i=0;i<N+1;i++)
				for(int j=0;j<K+1;j++) dp[i][j]=0;
			
			int[] sigma = new int[N+1];
			for(int i=0;i<N+1;i++) sigma[i]=0;
			
			//1번 돌부터 N번 돌까지, 그 돌까지 도달하는 경우의 수를 구한다.
			for(int i=1;i<=N;i++)
			{
				//i번째 돌에 지뢰가 있으면 그 돌까지 도달하는 경우의 수는 0이다. for문으로 돌아가 다음 돌을 계산한다.
				if(bridge[i]<0) continue;
				
				for(int j=1;j<=K;j++)
				{
					//i==j --> i걸음으로 i번째 돌에 오는 경우의 수 = 1(0번째 돌에서 한방에 옴)
					if(i==j) 
						dp[i][j]=1;
					//i>j --> j걸음하여 i번째 돌에 오는 경우의 수는 j걸음 전인 i-j번째 돌에 도달하는 모든 경우(sigma)에서 i-j번째 돌에 j걸음으로 오는 경우의 수를 빼는 것과 같다
					//i번째 돌에 j걸음으로 오는 경우에, i-j번째 돌에 j걸음으로 오는 경우를 빼주지 않으면 j걸음으로 두번 건너게 되기 때문이다.
					if(i>j)
						//dp[i][j]=sigma[i-j]-dp[i-j][j]; -->이 식 말고, 아래의 MOD를 붙인다.
						//sigma[i-j]는 하단 for문에서 MOD연산을 한번해서 값을 줄여놔서 dp[i-j][j]보다 작아질 수 있으므로 MOD를 더한후 MOD연산을 한다.
						dp[i][j]=(sigma[i-j]-dp[i-j][j]+MOD)%MOD;
						
					//i<j 인 경우는 말이 안되는 경우이고, 이미 dp배열을 0으로 초기화했었기 때문에 굳이 안 건드려도 됨.
				}
				//for문이 종료되면 dp[i][~]가 모두 대입 및 정리 완료된다.
				//그러므로 dp[i][1] + dp[i][2] + dp[i][3] + ... + dp[i][K] 을 sigma[i]에 저장할 수 있다. 
				//그리고 sigma[i]는 i번째 돌까지 오는 모든 경우의 수라고 할 수 있다.
				for(int j=1;j<=K;j++)
					//sigma[i] = sigma[i]+dp[i][j];
					//문제의 하단에 output을 가짓수를 MOD로 나눈 나머지라고 언급함
					sigma[i] = (sigma[i]+dp[i][j])%MOD;
			}

		
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(sigma[N]);
			
		}
	}
	
	
}