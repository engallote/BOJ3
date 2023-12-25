import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt() * 3;
		int M = sc.nextInt() * 8;
		char[][] map = new char[N][M];
		
		for(int i = 0; i < N; i++) map[i] = sc.next().toCharArray();
		
		for(int i = 0; i < N; i += 3) {
			int idx = 0;
			while(idx < M) {
				int r = i + 1, c = idx + 1;
				int sum = 0, w = 0;
				
				while(true) {
					if(map[r][c] == '=') break;
					if(map[r][c] == '+') {
						c += 1;
						continue;
					}
					sum += (map[r][c] - '0');
					c += 1;
				}
				
				c += 1;
				if(map[r][c + 1] == '.') w = map[r][c] - '0';
				else {
					w = (map[r][c] - '0') * 10 + (map[r][c + 1] - '0');
					c += 1;
				}
				
				if(sum == w) {
					map[r][idx] = map[r][c + 1] = '*';
					for(int j = idx + 1; j <= c; j++) map[r - 1][j] = map[r + 1][j] = '*';
				}
				else {
					map[r - 1][idx + 3] = '/';
					map[r][idx + 2] = '/';
					map[r + 1][idx + 1] = '/';
				}
				idx += 8;
			}
		}
		
		for(int i = 0; i < N; i++) System.out.println(new String(map[i]));
	}
}