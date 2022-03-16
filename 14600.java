import java.util.*;

public class Main {
	static boolean flag;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int y = sc.nextInt() - 1;
		int x = 2 * K - sc.nextInt();
		map = new int[K * 2][K * 2];
		
		map[x][y] = -1;
		flag = false;
		
		if(K == 1) {
			for(int i = 0; i < 2; i++) {
				for(int j = 0; j < 2; j++) {
					if(map[i][j] == 0) System.out.print("1 ");
					else System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
		else solve(1);
	}

	private static void solve(int idx) {
		if(flag) return;
		if(idx > 5) {
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++)
					System.out.print(map[i][j] + " ");
				System.out.println();
			}
			flag = true;
			return;
		}
		
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++) {
				if(map[i][j] != 0) continue;
				if(i + 1 < 4 && j + 1 < 4) {
					if(map[i][j + 1] == 0 && map[i + 1][j + 1] == 0) {//ㄱ
						map[i][j] = map[i][j + 1] = map[i + 1][j + 1] = idx;
						solve(idx + 1);
						map[i][j] = map[i][j + 1] = map[i + 1][j + 1] = 0;
					}
					if(map[i][j + 1] == 0 && map[i + 1][j] == 0) {//ㄱ 반대
						map[i][j] = map[i][j + 1] = map[i + 1][j] = idx;
						solve(idx + 1);
						map[i][j] = map[i][j + 1] = map[i + 1][j] = 0;
					}
					if(map[i + 1][j] == 0 && map[i + 1][j + 1] == 0) {//ㄴ
						map[i][j] = map[i + 1][j] = map[i + 1][j + 1] = idx;
						solve(idx + 1);
						map[i][j] = map[i + 1][j] = map[i + 1][j + 1] = 0;
					}
				}
				if(i + 1 < 4 && j - 1 >= 0) {
					if(map[i + 1][j] == 0 && map[i + 1][j - 1] == 0) {//ㄴ 반대
						map[i][j] = map[i + 1][j] = map[i + 1][j - 1] = idx;
						solve(idx + 1);
						map[i][j] = map[i + 1][j] = map[i + 1][j - 1] = 0;
					}
				}
			}
	}
}