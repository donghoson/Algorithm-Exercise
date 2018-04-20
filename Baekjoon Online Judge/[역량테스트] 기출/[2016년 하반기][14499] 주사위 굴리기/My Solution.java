import java.util.Scanner;
import java.io.FileInputStream;

class Main {
	
	public static int Front=0,Back=0,Top=0,Bottom=0,Right=0,Left=0;
	//주사위의 단면은 초기에 모두 0이다.
	public static void EastRotate(){//오른쪽으로 돌릴경우 단면들의 숫자도 조정해준다.
		int tmp=Bottom;
		Bottom=Right;
		Right=Top;
		Top=Left;
		Left=tmp;
	}
	public static void WestRotate(){//왼쪽으로 돌릴경우 단면들의 숫자도 조정해준다.
		int tmp=Bottom;
		Bottom=Left;
		Left=Top;
		Top=Right;
		Right=tmp;
	}
	public static void SouthRotate(){//아래로 돌릴경우 단면들의 숫자도 조정해준다.
		int tmp=Bottom;
		Bottom=Front;
		Front=Top;
		Top=Back;
		Back=tmp;
	}
	public static void NorthRotate(){//위로 돌릴경우 단면들의 숫자도 조정해준다.
		int tmp=Bottom;
		Bottom=Back;
		Back=Top;
		Top=Front;
		Front=tmp;
	}
	public static int[][] Copy(int[][] map,int x,int y){
		if(map[x][y]==0)//게임판 map에서 (x,y)에 해당되는 칸에 0이 적혀있다면 
			map[x][y]=Bottom;//주사위의 바닥에 적혀있는 숫자를 게임판에 복사한다.
		else
		{//게임판 (x,y)에 0이 안 적혀있다면
			Bottom=map[x][y];//게임판 (x,y)에 적혀있는 숫자를 주사위 바닥면에 복사하고
			map[x][y]=0;//게임판 (x,y)는 0으로 변경해준다.
		}
		return map;//변경된 게임판을 리턴한다.
	}
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		
		// 이 부분에서 알고리즘 프로그램을 작성하십시오.
		int N = sc.nextInt();        
		int M = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] map = new int[N][M];
		
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				map[i][j]=sc.nextInt();
		
		for(int i=0;i<K;i++)
		{
			int move = sc.nextInt();//방향을 읽는다.
			if(move==1)
			{
				if(y==M-1) continue;//게임판 가장 오른쪽에 위치하고 있어서 더 이상 오른쪽으로 가지 못 할 경우, 이동명령을 무시한다.
				EastRotate();//오른쪽으로 굴리기
				map = Copy(map,x,y+1);//굴린 후에는 바닥면과 게임판에 적힌 숫자를 비교하고 복사를 한다.
				y=y+1;//오른쪽으로 굴리기는 행렬에서 열이 증가한 것이다.
			}
			else if(move==2)
			{
				if(y==0) continue;//게임판 가장 왼쪽에 위치하고 있어서 더 이상 왼쪽으로 가지 못 할 경우, 이동명령을 무시한다.
				WestRotate();//왼쪽으로 굴리기
				map = Copy(map,x,y-1);//굴린 후에는 바닥면과 게임판에 적힌 숫자를 비교하고 복사를 한다.
				y=y-1;//왼쪽으로 굴리기는 행렬에서 열이 감소한 것이다.
			}
			else if(move==3)
			{
				if(x==0) continue;//게임판 가장 윗쪽에 위치하고 있어서 더 이상 윗쪽으로 가지 못 할 경우, 이동명령을 무시한다.
				NorthRotate();//위로 굴리기
				map = Copy(map,x-1,y);//굴린 후에는 바닥면과 게임판에 적힌 숫자를 비교하고 복사를 한다.
				x=x-1;//위로 굴리기는 행렬에서 행이 감소한 것이다.
			}
			else if(move==4)
			{
				if(x==N-1) continue;//게임판 가장 아래쪽에 위치하고 있어서 더 이상 아래쪽으로 가지 못 할 경우, 이동명령을 무시한다.
				SouthRotate();//아래로로 굴리기
				map = Copy(map,x+1,y);//굴린 후에는 바닥면과 게임판에 적힌 숫자를 비교하고 복사를 한다.
				x=x+1;//아래로 굴리기는 행렬에서 행이 증가한 것이다.
			}
			else
				continue;
			System.out.println(Top);//주사위 윗면에 적힌 숫자를 출력한다.
		}
	}
}