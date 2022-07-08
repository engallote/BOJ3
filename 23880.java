import java.util.*;

public class Main {
	static int N;
	static char[][] map;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(--T >= 0) {
			N = sc.nextInt();
			int K = sc.nextInt();
			map = new char[N][N];
			
			for(int i = 0; i < N; i++) map[i] = sc.next().toCharArray();
			
			int res = 0;
			if(K >= 1) {
				boolean flag1 = true, flag2 = true;
				for(int i = 0; i < N; i++) {
					if(map[0][i] == 'H' || map[i][N - 1] == 'H') flag1 = false;
					if(map[i][0] == 'H' || map[N - 1][i] == 'H') flag2 = false;
				}
				
				res += (flag1 ? 1 : 0) + (flag2 ? 1 : 0);
			}
			if(K >= 2) {
				boolean flag = true;
				for(int a = 1; a < N - 1; a++) {
					flag = true;
					for(int i = 0; i <= a; i++)
						if(map[i][0] == 'H') {
							flag = false;
							break;
						}
					
					if(!flag) continue;
					
					for(int i = 0; i < N; i++)
						if(map[a][i] == 'H') {
							flag = false;
							break;
						}
					
					if(!flag) continue;
					
					for(int i = a; i < N; i++)
						if(map[i][N - 1] == 'H') {
							flag = false;
							break;
						}
					
					if(flag) ++res;
				}
				
				for(int a = 1; a < N - 1; a++) {
					flag = true;
					for(int i = 0; i <= a; i++)
						if(map[0][i] == 'H') {
							flag = false;
							break;
						}
					
					if(!flag) continue;
					
					for(int i = 0; i < N; i++)
						if(map[i][a] == 'H') {
							flag = false;
							break;
						}
					
					if(!flag) continue;
					
					for(int i = a; i < N; i++)
						if(map[N - 1][i] == 'H') {
							flag = false;
							break;
						}
					
					if(flag) ++res;
				}
			}
			if(K == 3) {
				boolean flag = true;
				for(int a = 1; a < N - 1; a++)
					for(int b = 1; b < N - 1; b++) {
						flag = true;
						for(int i = 0; i <= a; i++)
							if(map[0][i] == 'H') {
								flag = false;
								break;
							}
						
						if(!flag) continue;
						
						for(int i = 0; i <= b; i++)
							if(map[i][a] == 'H') {
								flag = false;
								break;
							}
						
						if(!flag) continue;
						
						for(int i = a; i < N; i++)
							if(map[b][i] == 'H') {
								flag = false;
								break;
							}
						
						if(!flag) continue;
						
						for(int i = b; i < N; i++)
							if(map[i][N - 1] == 'H') {
								flag = false;
								break;
							}
						
						if(flag) ++res;
					}
				
				for(int a = 1; a < N - 1; a++)
					for(int b = 1; b < N - 1; b++) {
						flag = true;
						for(int i = 0; i <= a; i++)
							if(map[i][0] == 'H') {
								flag = false;
								break;
							}
						
						if(!flag) continue;
						
						for(int i = 0; i <= b; i++)
							if(map[a][i] == 'H') {
								flag = false;
								break;
							}
						
						if(!flag) continue;
						
						for(int i = a; i < N; i++)
							if(map[i][b] == 'H') {
								flag = false;
								break;
							}
						
						if(!flag) continue;
						
						for(int i = b; i < N; i++)
							if(map[N - 1][i] == 'H') {
								flag = false;
								break;
							}
						
						if(flag) ++res;
						
					}
			}
			
			System.out.println(res);
		}
	}	
}