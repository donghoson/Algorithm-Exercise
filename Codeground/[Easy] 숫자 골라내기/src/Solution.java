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
			int sol = 0;
			/*
			XOR의 특징은 자기자신과 XOR 하면 0이 나온다는 것이고 이것의 의미는 다른 것에 영향을 미치지 않는다는 것이므로
			숫자가 짝수번 나오던 홀수번 나오던 상관없이 XOR을 계속 해주면 된다는 것이다.
			예를들어  3 XOR 5 = 6 , 3 XOR 5 XOR 5 = 3 , 3에다가 5를 짝수번 XOR하면 원래의 값 3이 나온다는 것을 이용한다. 
			*/
			for (int i=0;i<N;i++)
				sol ^= sc.nextInt();
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(sol);
		}
	}
}