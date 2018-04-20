import java.math.BigInteger;
import java.util.Scanner;

/* 사용하는 클래스명이 Solution 이어야 하며, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해 볼 수 있습니다. */

class Solution {
	public static void main(String args[]) throws Exception	{
		/* 아래 메소드 호출은 앞으로 표준입력(키보드) 대신 input.txt 파일로 부터 읽어오겠다는 의미의 코드입니다.
		   만약 본인의 PC 에서 테스트 할 때는, 입력값을 input.txt에 저장한 후 이 코드를 첫 부분에 사용하면,
		   표준입력 대신 input.txt 파일로 부터 입력값을 읽어 올 수 있습니다.
		   또한, 본인 PC에서 아래 메소드를 사용하지 않고 표준입력을 사용하여 테스트하셔도 무방합니다.
		   단, Codeground 시스템에서 "제출하기" 할 때에는 반드시 이 메소드를 지우거나 주석(//) 처리 하셔야 합니다. */
		//Scanner sc = new Scanner(new FileInputStream("src/sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		int test_case;

		T = sc.nextInt();         
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오. 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.
			int k = sc.nextInt();
			
			//2의63제곱은 long타입으로 표현이 불가능함.
			//long타입의 범위는 -2의 63제곱부터 2의 63제곱-1 까지이다.
			//그러므로 2의 63제곱까지 저장하려면 BigInteger를 사용해야한다.
			BigInteger max = new BigInteger("1");
			for(int i=1;i<=k;i++)
				max = max.multiply(BigInteger.valueOf(2));
			
			long min=1;
			long x=1;
			while(true){
				if(getStep(x)==k) 
				{
					min = x;
					break;
				}
				x++;
			}

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(min+" "+max);
		}
	}
	 //미지의 수 x를 input 받으면 x를 1로 만드는데 걸리는 스텝의 수를 반환
	static int getStep(long x){
		int count=0;
		while(x!=1)
		{
			if(x%2 == 0) x = x/2;
			else x= 3*x+1;
			count++;
		}
		return count;
	}
}