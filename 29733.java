import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int H = sc.nextInt();
		char[][][] map = new char[H][R][C];
		int[][][] arr = new int[H][R][C];
		
		int[] dr = {0, 1, 0, -1, 0, 1, 1, -1, -1}, dc = {0, 0, 1, 0, -1, 1, -1, 1, -1};
		ArrayList<Pair> aly = new ArrayList<>();
		
		for(int i = 0; i < H; i++)
			for(int j = 0; j < R; j++) {
				map[i][j] = sc.next().toCharArray();
				for(int k = 0; k < C; k++)
					if(map[i][j][k] == '*') aly.add(new Pair(i, j, k));
			}
		
		for(Pair p : aly) {
			int h = p.h, r = p.r, c = p.c;
			
			for(int dh = -1; dh <= 1; dh++) {
				for(int i = 0; i < 9; i++) {
					int nh = h + dh, nr = r + dr[i], nc = c + dc[i];
					if(nh < 0 || nr < 0 || nc < 0 || nh >= H || nr >= R || nc >= C) continue;
					arr[nh][nr][nc] += 1;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int h = 0; h < H; h++)
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					if(map[h][r][c] == '*') sb.append("*");
					else sb.append(arr[h][r][c] % 10);
				}
				sb.append("\n");
			}
		
		System.out.println(sb);
	}
}
class Pair {
	int h, r, c;
	Pair(int h, int r, int c) {
		this.h = h;
		this.r = r;
		this.c = c;
	}
}