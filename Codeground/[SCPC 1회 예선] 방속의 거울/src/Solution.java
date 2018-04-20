/* 아래 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.
   단, 사용하는 클래스명이 Solution 이어야 하며, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해 볼 수 있습니다. */
import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	
	static char In_Direction;
	static int x;
	static int y;
	
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
			char[][] Room = new char[N][N];//거울의 종류를 저장한다.
			boolean[][] Pass = new boolean[N][N];//이미 지나간 방은 true, 안지나간 방은 false로 저장한다.
			boolean END = false;
			sc.nextLine();//int형 읽어오다가 Line읽어올 때 '\n'은 버려야 하므로.
			for (int i=0;i<N;i++)
			{	//초기에 Room 배열에는 거울의 방향을 저장하고, Pass에는 이 거울을 지났느지 여부를 저장한다.
				String s = sc.nextLine();
				for(int j=0; j<s.length();j++)
					{
						Room[i][j]=s.charAt(j);
						Pass[i][j]=false;
					}
			}
			x=0;
			y=0;
			In_Direction='L';//첫 시작은 왼쪽 가장 윗방(x,y)=(0,0)에서 시작하고 빛은 왼쪽에서 들어온다.
			
			while(END!=true)
			{
				if(Room[x][y]=='0')
				{
					move(0);
				}
				else if(Room[x][y]=='1')
				{
					//거울이 있는 방을 지났으므로 true로 바꿔준다.
					Pass[x][y]=true;
					move(1);
				}
				else if(Room[x][y]=='2')
				{
					//거울이 있는 방을 지났으므로 true로 바꿔준다.
					Pass[x][y]=true;
					move(2);
				}
				if (x<0 || x>=N || y<0 || y>=N) //빛이 방의 범위를 벗어나면 더이상 loop를 돌지 않아도 된다.
					END=true;
			}

			int sol=0;
			for (int i=0;i<N;i++)
				for (int j=0;j<N;j++)
					if (Pass[i][j]==true) sol++;

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(sol);
			
		}
	}
	
	public static void move(int mirror){
		/*빛이 왼쪽에서 들어왔으면 오른쪽으로 빛을 보내고,
		빛이 오른쪽에서 들어왔으면 왼쪽으로 빛을 보내고,
		빛이 위에서 들어왔으면 아래로 빛을 보내고,
		빛이 아래에서 들어왔으면 위로 빛을 보낸다.*/
		if (mirror == 0)
		{	//거울이 없는 방은 빛을 그대로 통과시킨다. 그러므로 그 다음방에서도 빛이 들어오는 방향이 동일하다.
			if (In_Direction == 'L') y++;
			else if (In_Direction == 'R') y--;
			else if (In_Direction == 'U') x++;
			else if (In_Direction == 'D') x--;
		}
		else if (mirror == 1)
		{	//1번 거울이 들어있는 방은 빛을 굴절시킨다. 그리고 그 빛이 다음방에 들어갈때 어느 방향으로 들어오는지를 계산한다.
			if (In_Direction == 'L') {In_Direction = 'D';x--;}
			else if (In_Direction == 'R') {In_Direction = 'U';x++;}
			else if (In_Direction == 'U') {In_Direction = 'R';y--;}
			else if (In_Direction == 'D') {In_Direction = 'L';y++;}
		}
		else if (mirror ==2)
		{	//2번 거울이 들어있는 방은 빛을 굴절시킨다. 그리고 그 빛이 다음방에 들어갈때 어느 방향으로 들어오는지를 계산한다.
			if (In_Direction == 'L') {In_Direction = 'U';x++;}
			else if (In_Direction == 'R') {In_Direction = 'D';x--;}
			else if (In_Direction == 'U') {In_Direction = 'L';y++;}
			else if (In_Direction == 'D') {In_Direction = 'R';y--;}
		}
	}

}