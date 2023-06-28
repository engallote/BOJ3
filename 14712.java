import java.util.*;

public class Main {
	static int N, M;
	static long res;
	static boolean[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new boolean[N + 1][M + 1];
		res = 0l;
		
		dfs(0);
		
		System.out.println(res);
	}
	private static void dfs(int num) {
		if(num == N * M) {
			res += 1l;
			return;
		}
		
		int x = num / M + 1;
		int y = num % M + 1;
		
		if (map[x - 1][y] && map[x][y - 1] && map[x - 1][y - 1]) dfs(num + 1);
		else {
			dfs(num + 1); // ���þ��ϰ� ������ �� ���
	        map[x][y] = true;
	        dfs(num + 1);// �����ϰ� ������ �� ���
	        map[x][y] = false;
		}
	}
}