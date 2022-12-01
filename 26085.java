import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	int[][] map = new int[N][M];
    	int one = 0, zero = 0, side = 0;
    	
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < M; j++) {
    			map[i][j] = sc.nextInt();
    			if(map[i][j] == 0) zero += 1;
    			else one += 1;
    			
    			if(j > 0) {
    				if(map[i][j - 1] == map[i][j]) ++side;
    			}
    			if(i > 0) {
    				if(map[i - 1][j] == map[i][j]) ++side;
    			}
    		}
    	
    	if(one % 2 != 0 || zero % 2 != 0 || side == 0) System.out.println(-1);
    	else System.out.println(1);
	}
}