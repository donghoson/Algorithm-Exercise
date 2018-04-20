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
		Scanner sc = new Scanner(new FileInputStream("src/input_sample.txt"));
		//Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();        
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오. 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.
			int answer=1;
			
			int N = sc.nextInt();
			char[] Manager = new char[N+1];//도시별로 어떤 관리자가 있는지 저장할 배열.1번 index부터 N번 index까지 사용.
			
			//Manager배열은 초기화로 모든 City를 A관리자가 관리한다고 가정.
			for(int i=0;i<N+1;i++)
				Manager[i]='A';
			
			int I = sc.nextInt();//인접한 도시들 명단이 I개 들어옴.
			int[] City1 = new int[I+1];//인접하는 도시의 명단이 I개 input으로 들어오므로 이것들을 City1과 City2 배열에 저
			int[] City2 = new int[I+1];//1번 index부터 I번 index까지 사용.
			
			for(int i=1;i<=I;i++)
			{
				City1[i]=sc.nextInt();
				City2[i]=sc.nextInt();
			}
			
			/* 
			 * I개 명단 중 i번째 명단(첫번째 도시, 두번째 도)에서, 첫번째 도시 City1[i]의 관리자인 Manager[City1[i]]가 A이면,
			 * 두번째 도시 City2[i]의 관리자인 Manager[City2[i]] 는 B가 되어야 한다.
			 * 반대의 경우는 관리자를 반대로 지정해주면 된다.
			 */
			for(int i=1;i<=I;i++)
			{
				if( Manager[City1[i]]=='A' ) Manager[City2[i]]='B';
				else Manager[City2[i]]='A';
			}

			/*
			 * 이제 도시들마다 어떤 관리자가 관리하고 있는지 모두 저장했으므로, 다시 I개의 input들을 보면서,
			 * 첫번째 도시 City1[i]의 관리자인 Manager[City1[i]]와 두번째 도시 City2[i]의 관리자인 Manager[City2[i]]와
			 * 동일한지 확인한다. 동일하면 반란이 일어날 수 있으므로 answer=0을 출력한다.
			 */
			for(int i=1;i<=I;i++)
			{	
				if(Manager[City1[i]]==Manager[City2[i]])
				{
					answer=0;
					break;
				}
			}		
			
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(answer);
		}
	}
}