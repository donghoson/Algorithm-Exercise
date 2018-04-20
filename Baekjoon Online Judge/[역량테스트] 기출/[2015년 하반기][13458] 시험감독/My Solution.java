import java.util.Scanner;
import java.io.FileInputStream;

class Main {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		
		// 이 부분에서 알고리즘 프로그램을 작성하십시오.
		int N= sc.nextInt();        
		int[] A = new int[N+1];
		for(int i=1;i<=N;i++)
		{
			A[i] = sc.nextInt();
		}
		int B = sc.nextInt();//총 감독관이 감시할 수 있는 학생수
		int C = sc.nextInt();//부 감독관이 감시할 수 있는 학생수
		long cnt=N;//아래 for문에서 x를 N번만큼 더하는 경우가 있을수 있음(x,N 모두 100만까지 가능. 100만x100만 = int범위 벗어남)
		for(int i=1;i<=N;i++)
		{//각 방마다 아래의 과정이 반복됨
			int u = A[i]-B;//각 방마다 총감독관이 감시할 수 없는 학생의 수
			if (u < 0) u=0;//음수는 말이 안되므로 0명으로 처리
			int x = u/C;//몫:총감독관이 감시할 수 없는 학생의 수를 부감독관이 감시할 수 있는 학생수로 나누면 부감독관이 몇명정도 커버할 수 있는지 알 수 있음
			int y = u%C;//나머지
			if (y==0) cnt+=x;//나누어 떨어지면 몫 x가 필요한 부감독관의 수
			else cnt += x+1;//나누어 떨어지지 않는다면 x+1이 필요한 부감독관의 수
		}

		// 이 부분에서 정답을 출력하십시오.
		System.out.println(cnt);
		
	}
}