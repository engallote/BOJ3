import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int res = 0;
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int sx = N / 2 - 1, sy = N / 2 - 1, xl = 1, yl = 1;
		while(true) {
			int d = 0, u = 0, r = 0, l = 0;
			if(sx + xl + 1 < N) d = calUD(sx, sy, xl + 1, yl);//D
			if(sx - 1 >= 0) u = calUD(sx, sy, -1, yl);//U
			if(sy + yl + 1 < N) r = calLR(sx, sy, xl, yl + 1);//R
			if(sy - 1 >= 0) l = calLR(sx, sy, xl, - 1);//L
			
			int max = Math.max(d, Math.max(u, Math.max(l, r)));
//			System.out.println(sx + " " + sy + " " + xl + " " + yl);
//			System.out.println(u + " " + d + " " + l + " " + r + " >> " + max);
			if(max <= 0) break;
			
			if(max == u) {
				sb.append('U');
				sx -= 1;
				xl += 1;
			}
			else if(max == d) {
				sb.append('D');
				xl += 1;
			}
			else if(max == l) {
				sb.append('L');
				sy -= 1;
				yl += 1;
			}
			else if(max == r) {
				sb.append('R');
				yl += 1;
			}
			res += max;
		}
		
		bw.write(res + "\n");
		bw.write(sb.toString());
		bw.flush();
	}
	private static int calLR(int sx, int sy, int xl, int yl) {
		int sum = 0;
		for(int i = sx; i <= sx + xl; i++)
			sum += map[i][sy + yl];
		return sum;
	}
	private static int calUD(int sx, int sy, int xl, int yl) {
		int sum = 0;
		for(int i = sy; i <= sy + yl; i++)
			sum += map[sx + xl][i];
		return sum;
	}
}