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
		
		double sin0 = 0;
		double sin9 = Math.sin(Math.PI*9/180);
		double sin27 = Math.sin(Math.PI*27/180);
		double sin45 = Math.sin(Math.PI*45/180);
		double sin63 = Math.sin(Math.PI*63/180);
		double sin81 = Math.sin(Math.PI*81/180);
		double sin90 = Math.sin(Math.PI/2);

		TC = sc.nextInt();        
		for(test_case = 1; test_case <= TC; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			int D = sc.nextInt();
			int E = sc.nextInt();
			int N = sc.nextInt();

			int total=0;
			for (int i=0;i<N;i++)
			{
				int score=0;

				double x = sc.nextDouble();
				double y = sc.nextDouble();
				double r = Math.sqrt(x*x+y*y);
				
				//여기서 먼저 배점이 몇점짜리 다트인지 확인하고 score에 저장.
				if (x==0 && y>0) score=20;
				else if (x==0 && y<0) score = 3;
				else if (y==0 && x<0) score = 11;
				else if (y==0 && x>0) score = 6;
				
				else if (x>0 && y>0)
				{	
					double sin_theta = y/r;
					if (sin0<sin_theta && sin_theta<sin9) score = 6;
					else if(sin9<sin_theta && sin_theta<sin27) score = 13;
					else if(sin27<sin_theta && sin_theta<sin45) score = 4;
					else if(sin45<sin_theta && sin_theta<sin63) score = 18;
					else if(sin63<sin_theta && sin_theta<sin81) score = 1;
					else score = 20;
				}
				else if(x<0 && y>0)
				{	
					double sin_theta = y/r;
					if (sin0<sin_theta && sin_theta<sin9) score = 11;
					else if(sin9<sin_theta && sin_theta<sin27) score = 14;
					else if(sin27<sin_theta && sin_theta<sin45) score = 9;
					else if(sin45<sin_theta && sin_theta<sin63) score = 12;
					else if(sin63<sin_theta && sin_theta<sin81) score = 5;
					else score = 20;
				}
				else if(x>0 && y<0)
				{
					double sin_theta = -y/r;
					if (sin0<sin_theta && sin_theta<sin9) score = 6;
					else if(sin9<sin_theta && sin_theta<sin27) score = 10;
					else if(sin27<sin_theta && sin_theta<sin45) score = 15;
					else if(sin45<sin_theta && sin_theta<sin63) score = 2;
					else if(sin63<sin_theta && sin_theta<sin81) score = 17;
					else score = 3;
				}
				else if(x<0 && y<0)
				{
					double sin_theta = -y/r;
					if (sin0<sin_theta && sin_theta<sin9) score = 11;
					else if(sin9<sin_theta && sin_theta<sin27) score = 8;
					else if(sin27<sin_theta && sin_theta<sin45) score = 16;
					else if(sin45<sin_theta && sin_theta<sin63) score = 7;
					else if(sin63<sin_theta && sin_theta<sin81) score = 19;
					else score = 3;
				}
				//score를 몇배할지 정한다.
				if (0<=r && r<A) score = 50;//가운데 BULL배점 범위
				else if (B<r && r<C) score = score*3;//트리플 배점 범위
				else if (D<r && r<E) score = score*2;//더블 배점 범위
				else if (E<r) score = 0;//범위를 벗어나면 배점이 0점.
				else ;//single의 경우는 배점을 그대로
				
				total= total+score;
			}

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(total);	
		}
	}
}