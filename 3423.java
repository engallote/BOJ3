import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		while(true) {
			int N = sc.nextInt();
			
			if(N == 0) break;
			
			char[][] map = new char[N][N];
			char[][] alp = new char[N][N];
			
			for(int i = 0; i < N; i++) map[i] = sc.next().toCharArray();
			for(int i = 0; i < N; i++) alp[i] = sc.next().toCharArray();
			
			StringBuilder sb = new StringBuilder();
			for(int k = 0; k < 4; k++) {
				for(int i = 0; i < N; i++)
					for(int j = 0; j < N; j++)
						if(map[i][j] == 'O') sb.append(alp[i][j]);
				
				//rotation
				char[][] tmp = new char[N][N];
				int r = N - 1, c = 0;
				for(int i = 0; i < N; i++) {
					r = N - 1;
					for(int j = 0; j < N; j++) {
						tmp[i][j] = map[r][c];
						--r;
					}
					++c;
				}
				
				for(int i = 0; i < N; i++) map[i] = new String(tmp[i]).toCharArray();
			}
			
			System.out.println(sb.toString());
		}
	}
}