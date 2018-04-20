/* 아래 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.
   단, 사용하는 클래스명이 Solution 이어야 하며, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해 볼 수 있습니다. */
import java.util.Arrays;
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
			int N = sc.nextInt();
			int[] list = new int[N];
			//내림차순으로 정렬하기
			for(int i=0;i<N;i++) list[i] = sc.nextInt();
			Arrays.sort(list);

			/*
			 * 점수를 정렬해서 오름차순으로 정렬.(꼴지가 맨앞,1등이 맨뒤)
			 * 우승 가능성을 단 1%라도 있는 경우는 해당학생이 N점을 받고
			 * 다른 학생들 최종점수들 중의 MAX보다 크거나 같으면 된다.
			 * 경우의 수가 1이라도 있으면 되므로, 최대한 MAX를 작게 만드는게 핵심.
			 */
			
			int people=0;
			int max=0;
			for(int i=0;i<N;i++)
			{
				/*
				 * 1등에게는 최하점을 꼴등에게는 최고점을 주는 시나리오를 가정하고, MAX를 찾는다.
				 * 이 시나리오가 MAX가 가장 낮게 나오는 시나리오이다.
				 * 설사 최하위 학생이 최고점(N)을 받아서 1등(MAX점수)이 되는 난잡한 경우에도,
				 * 어차피 i번째 학생(최하위학생보다 점수가 높거나 같다)이 최고점(N)을 가져갈 거라서 그렇게 되면 자연스럽게
				 * 최하위학생은 단독 1등(MAX점수) 아니게 되므로 i번째 학생이 1등이 될것. 
				*/
				int tmp=list[i]+N-i;
				if(tmp>max) max = tmp;
			}
			
			for(int i=0;i<N;i++)
			{//i번재 학생이 N점을 받고 위 시나리오에서의 max보다 크거나 같으면 공동우승 또는 단독우승 가능성이 있다.
				if(list[i]+N>=max)
					people++;
			}
			
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(people);
		}
	}
}