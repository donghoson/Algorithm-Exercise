import java.util.Scanner;
import java.io.FileInputStream;

/* 사용하는 클래스명이 Solution 이어야 하며, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해 볼 수 있습니다. */

class Solution {
    static int k;
	static int[] d;
	static int[][] rect;
	static int ans;
	public static void main(String args[]) throws Exception	{
		/* 아래 메소드 호출은 앞으로 표준입력(키보드) 대신 sample_input.txt 파일로 부터 읽어오겠다는 의미의 코드입니다.
		   만약 본인의 PC 에서 테스트 할 때는, 입력값을 sample_input.txt에 저장한 후 이 코드를 첫 부분에 사용하면,
		   표준입력 대신 sample_input.txt 파일로 부터 입력값을 읽어 올 수 있습니다.
		   또한, 본인 PC에서 아래 메소드를 사용하지 않고 표준입력을 사용하여 테스트하셔도 무방합니다.
		   단, Codeground 시스템에서 "제출하기" 할 때에는 반드시 이 메소드를 지우거나 주석(//) 처리 하셔야 합니다. */
		//Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));
        
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();        
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오. 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.
        	int n = sc.nextInt();
			int m = sc.nextInt();
			k = sc.nextInt();
			d = new int[k];
			rect = new int[k][4];
			for (int i = 0; i < k; i++) {
				rect[i][0] = sc.nextInt(); // x
				rect[i][1] = sc.nextInt(); // y
				rect[i][2] = sc.nextInt(); // x'
				rect[i][3] = sc.nextInt(); // y'
			}
			ans = 0;
			d = new int[k];
			for (int i = 0; i < k; i++) {
				dfs(i);
			}
        
        

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(ans);
		}
	}
    private static int dfs(int root) {
		if (root >= k)
			return 0;

		if (d[root] > 0)
			return d[root];

		int tmpMax = 1;
		for (int i = 0; i < k; i++) {
			if (root == i)
				continue;
			if (rect[root][0] <= rect[i][0] && rect[i][2] <= rect[root][2] && rect[root][1] <= rect[i][1] && rect[root][3] >= rect[i][3]) {
				int next = dfs(i) + 1;
				tmpMax = Math.max(next, tmpMax);
			}
		}
		d[root] = tmpMax;

		if (ans < d[root])
			ans = d[root];

		return tmpMax;
	}
}