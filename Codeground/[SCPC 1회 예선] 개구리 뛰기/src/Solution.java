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
		Scanner sc = new Scanner(new FileInputStream("src/input.txt"));
		//Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;

		TC = sc.nextInt();        
		for(test_case = 1; test_case <= TC; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			int N=sc.nextInt();
			int[] stones = new int[N+1];
			stones[0]=0;
			for(int i=1;i<N+1;i++)
			{	
				stones[i]=sc.nextInt();
			}
			int K = sc.nextInt();
			
			boolean possible = true;
			int Now;
			int move=0;
			int start=0;
			int end=0;
			while(true)
			{
				if(start==N) break;//마지막 돌이 시작점일 때는 뛸 필요 없다.
				Now=start;
				int MaxStone = stones[Now]+K;//최대로 갈 수 있는 돌(거리)
				//최대로 뛸 수 있는 돌(Now) 찾기
				while(true)
				{	
					if(Now>N || stones[Now]>MaxStone )
					{
						Now--;
						break;
					}
					else 
						Now++;
				}
				end=Now;//최대로 뛸 수 있는 돌의 위치=end
				
				if(start==end)//시작점과 끝점이 같으면 뛸 수가 없는 상황임
				{	
					possible = false;
					break;
				}
				else{//뛸수 있다면 뛰는 횟수 증가 후, 끝점을 다시 시작점으로 해서 다시 루프.
					move++;
					start=end;
				}
			}
			

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			if(possible == false) System.out.println("-1");
			else System.out.println(move);
		}
	}
}