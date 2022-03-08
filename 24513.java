import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] map, time;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static Queue<Pair> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		time = new int[N][M];
		q = new LinkedList<>();
		int res1 = 0, res2 = 0, res3 = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) q.offer(new Pair(i, j, 1, 0));
				else if(map[i][j] == 2)  q.offer(new Pair(i, j, 2, 0));
			}
		}
		
		while(!q.isEmpty())
			spread();
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) ++res1;
				else if(map[i][j] == 2) ++res2;
				else if(map[i][j] == 3) ++res3;
			}
		
		bw.write(res1 + " " + res2 + " " + res3);
		bw.flush();
	}
	private static void spread() {
		int size = q.size();
		while(--size >= 0) {
			Pair p = q.poll();
			
			if(map[p.x][p.y] > 3){
				if(map[p.x][p.y] == p.num * 10) map[p.x][p.y] = p.num;
				else continue;
			}
			if(map[p.x][p.y] == 3) continue;
			
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == -1) continue;
				
				if(map[nx][ny] == 0) {
					map[nx][ny] = p.num * 10;
					time[nx][ny] = p.time + 1;
					q.offer(new Pair(nx, ny, p.num, p.time + 1));
				}
				else if(map[nx][ny] < 4) continue;
				else if(map[nx][ny] == 10) {
					if(p.num == 2 && time[nx][ny] == p.time + 1) //3으로 변화
						map[nx][ny] = 3;
					continue;
				}
				else if(map[nx][ny] == 20) {
					if(p.num == 1 && time[nx][ny] == p.time + 1) //3으로
						map[nx][ny] = 3;
					continue;
				}
			}
		}
	}
}
class Pair {
	int x, y, num, time;
	Pair(int x, int y, int num, int time) {
		this.x = x;
		this.y = y;
		this.num = num;
		this.time = time;
	}
}