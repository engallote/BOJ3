import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 1][N + 1];
		Pair[] xy = new Pair[N + 1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			xy[i] = new Pair(s, a, b);
			Arrays.fill(arr[i], 1000000000);
		}
		
		for(int i = 1; i < N; i++)
			for(int j = i + 1; j <= N; j++) {
				if(xy[i].s == 1 && xy[j].s == 1) {
					arr[i][j] = Math.min(arr[i][j], T);
					arr[j][i] = Math.min(arr[j][i], T);
				}
				arr[i][j] = Math.min(arr[i][j], dist(xy[i], xy[j]));
				arr[j][i] = Math.min(arr[j][i], dist(xy[j], xy[i]));
			}
		
		for(int k = 1; k <= N; k++)
			for(int i = 1; i <= N; i++)
				for(int j = 1; j <= N; j++)
					if(arr[i][k] + arr[k][j] < arr[i][j])
						arr[i][j] = arr[i][k] + arr[k][j];
		
		int M = Integer.parseInt(br.readLine());
		
		while(--M >= 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			bw.write(arr[a][b] + "\n");
		}
		bw.flush();
	}
	private static int dist(Pair a, Pair b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
}
class Pair {
	int s, x, y;
	Pair(int s, int x, int y) {
		this.s = s;
		this.x = x;
		this.y = y;
	}
}