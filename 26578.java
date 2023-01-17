import java.util.*;

public class Main {
	static int N, M;
	static char[][] map;
	static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1}, dy = {0, 1, 0, -1, 1, -1, 1, -1};
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	char[] word = {'w', 'o', 'r', 'd'};
    	int T = sc.nextInt();
    	while(--T >= 0) {
    		N = sc.nextInt();
    		M = sc.nextInt();
    		map = new char[N][M];
    		
    		for(int i = 0; i < N; i++) map[i] = sc.next().toCharArray();
    		
    		int res = 0, idx = 0;
    		for(int i = 0; i < N; i++)
    			for(int j = 0; j < M; j++)
    				if(map[i][j] == 'w') {
    					for(int d = 0; d < 8; d++) {
    						idx = 0;
    						for(int k = 0; k < 4; k++) {
    							int nx = i + dx[d] * k, ny = j + dy[d] * k;
    							if(nx < 0 || ny < 0 || nx >= N || ny >= M) break;
    							if(map[nx][ny] == word[idx]) idx += 1;
    						}
    						
    						if(idx == 4) ++res;
    					}
    				}
    		
    		System.out.println(res);
    	}
	}
}