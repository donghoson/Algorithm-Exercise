import java.util.Arrays;
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
		Scanner sc = new Scanner(new FileInputStream("src/sample.txt"));
		//Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();        
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오. 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.
			int N = sc.nextInt();//N=배열 크기
			int S = sc.nextInt();
			int[] Array = new int[N]; 
			for (int i=0;i<N;i++)
				Array[i]=sc.nextInt();
			
			
			int SUM=0;
			int MIN_SIZE=0;
			int FINAL_MIN=N;
			int WINDOW_SIZE=0;
			for(int i=0;i<N;i++)
			{	
				SUM += Array[i];
				WINDOW_SIZE++;
				if(SUM >= S)
				{
					MIN_SIZE=WINDOW_SIZE;
					for (int j=1;j<MIN_SIZE;j++)
					{
						SUM -= Array[i+1-WINDOW_SIZE];
						WINDOW_SIZE--;
						if (SUM>=S);
						else
						{
							MIN_SIZE= WINDOW_SIZE+1;
							break;
						}	
					}
					if (MIN_SIZE < FINAL_MIN)
						FINAL_MIN = MIN_SIZE;
				}
			}
			if (MIN_SIZE < FINAL_MIN)
				FINAL_MIN = MIN_SIZE;
			
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("#testcase" + test_case);
			System.out.println(FINAL_MIN);
		}
	}
}