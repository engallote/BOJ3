import java.util.*;

public class Main {
	static int N, M, K;
	static int[][] arr, sub;
	static boolean[][] chk;
	static boolean[][][] wall;
	static int[] dx = {0, 0, -1, 1}, dy = {1, -1, 0, 0};
	static ArrayList<Pair> aly, check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N][M];
		sub = new int[N][M];
		chk = new boolean[N][M];
		wall = new boolean[N][M][2];
		aly = new ArrayList<>();
		check = new ArrayList<>();
		
		for(int i = 0; i < N; i++) 
			for(int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
				if(0 < arr[i][j] && arr[i][j] < 5) aly.add(new Pair(arr[i][j], i, j));
				else if(arr[i][j] == 5) check.add(new Pair(i, j));
				arr[i][j] = 0;
			}
		
		int W = sc.nextInt();
		while(--W >= 0) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			int t = sc.nextInt();
			
			wall[x][y][t] = true;
		}
		
		boolean flag = false;
		int res = 0;
		while(!flag) {
			flag = true;
			wind();
			div();//조절
			down();//감소
			
			++res;//냠냠
			
			if(res > 100) {
				res = 101;
				break;
			}
			
			flag = check();//조사
		}
		
		System.out.println(res);
	}
	private static void div() {
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				sub[i][j] = arr[i][j];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				for(int d = 0; d < 4; d++) {
					//벽 확인
					if(d == 0 && wall[i][j][1]) {
//						System.out.println(i + ", " + j + " 와 " + i + ", " + (j + 1) + " X");
						continue;
					}
					if(d == 1 && j - 1 >= 0 && wall[i][j - 1][1]) {
//						System.out.println(i + ", " + (j - 1) + " 와 " + i + ", " + j + " X");
						continue;
					}
					if(d == 2 && wall[i][j][0]) {
//						System.out.println(i + ", " + j + " 와 " + (i - 1) + ", " + j + " X");
						continue;
					}
					if(d == 3 && i + 1 < N && wall[i + 1][j][0]) {
//						System.out.println(i + ", " + j + " 와 " + (i + 1) + ", " + j + " X");
						continue;
					}
					//////////////
					int nx = i + dx[d], ny = j + dy[d];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] >= arr[i][j]) continue;
					
					int tmp = Math.abs(arr[i][j] - arr[nx][ny]);
					sub[i][j] -= tmp / 4;
					sub[nx][ny] += tmp / 4;
				}
		
		//온도 조절
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				arr[i][j] = sub[i][j];
	}
	private static boolean check() {
		for(Pair p : check)
			if(arr[p.x][p.y] < K) return false;
		return true;
	}
	private static void down() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(i == 0 || i == N - 1 || j == 0 || j == M - 1)
					if(arr[i][j] > 0) arr[i][j] -= 1;
			}
		}
	}
	private static void wind() {
		Queue<Pair> q = new LinkedList<>();
		HashSet<String> hs = new HashSet<>();
		int size, time = 0;
		for(Pair con : aly) {
			q.clear();
			time = 5;
			hs.clear();
			
			if(con.idx == 1) {//오른쪽
				q.offer(new Pair(con.x, con.y + 1));
				while(!q.isEmpty()) {
					size = q.size();
					while(--size >= 0) {
						Pair p = q.poll();
						if(!hs.contains(p.x + " " + p.y)) {
							hs.add(p.x + " " + p.y);
							arr[p.x][p.y] += time;
						}
						else continue;
						if(time == 1) continue;
						if(p.y + 1 >= M) continue;//벽 끝까지 다 갔다
						
						//벽 확인
						if(!wall[p.x][p.y][1]) q.offer(new Pair(p.x, p.y + 1));//오른쪽 벽 없음
						if(p.x - 1 >= 0 && p.y + 1 < M && !wall[p.x][p.y][0] && !wall[p.x - 1][p.y][1]) q.offer(new Pair(p.x - 1, p.y + 1));//위쪽 벽 없음
						if(p.x + 1 < N && p.y + 1 < M && !wall[p.x + 1][p.y][0] && !wall[p.x + 1][p.y][1]) q.offer(new Pair(p.x + 1, p.y + 1));//아래쪽 벽 없음
					}
					--time;
					if(time == 0) break;
				}
			}
			else if(con.idx == 2) {//왼쪽
				q.offer(new Pair(con.x, con.y - 1));
				while(!q.isEmpty()) {
					size = q.size();
					while(--size >= 0) {
						Pair p = q.poll();
						
						if(!hs.contains(p.x + " " + p.y)) {
							hs.add(p.x + " " + p.y);
							arr[p.x][p.y] += time;
						}
						if(time == 1) continue;
						if(p.y - 1 < 0) continue;//벽 끝까지 다 갔다
						
						//벽 확인
						if(!wall[p.x][p.y - 1][1]) q.offer(new Pair(p.x, p.y - 1));//왼쪽 벽 없음
						if(p.x - 1 >= 0 && p.y - 1 >= 0 && !wall[p.x][p.y][0] && !wall[p.x - 1][p.y - 1][1]) q.offer(new Pair(p.x - 1, p.y - 1));//위쪽 벽 없음
						if(p.x + 1 < N && p.y - 1 >= 0 && !wall[p.x + 1][p.y][0] && !wall[p.x + 1][p.y - 1][1]) q.offer(new Pair(p.x + 1, p.y - 1));//아래쪽 벽 없음
					}
					--time;
					if(time == 0) break;
				}
			}
			else if(con.idx == 3) {//위쪽
				q.offer(new Pair(con.x - 1, con.y));
				while(!q.isEmpty()) {
					size = q.size();
					while(--size >= 0) {
						Pair p = q.poll();
						if(p.x < 0 || p.y < 0 || p.x >= N || p.y >= M) continue;
						if(!hs.contains(p.x + " " + p.y)) {
							hs.add(p.x + " " + p.y);
							arr[p.x][p.y] += time;
						}
						if(time == 1) continue;
						if(p.x - 1 < 0) continue;//벽 끝까지 다 갔다
						
						//벽 확인
						if(p.y + 1 < M && !wall[p.x][p.y][1] && !wall[p.x][p.y + 1][0]) q.offer(new Pair(p.x - 1, p.y + 1));//오른쪽 벽 없음
						if(p.y - 1 >= 0 && !wall[p.x][p.y - 1][1] && !wall[p.x][p.y - 1][0]) q.offer(new Pair(p.x - 1, p.y - 1));//왼쪽 벽 없음
						if(!wall[p.x][p.y][0]) q.offer(new Pair(p.x - 1, p.y));//위쪽 벽 없음
					}
					--time;
					if(time == 0) break;
				}
			}
			else if(con.idx == 4) {//아래쪽
				q.offer(new Pair(con.x + 1, con.y));
				while(!q.isEmpty()) {
					size = q.size();
					while(--size >= 0) {
						Pair p = q.poll();
						if(p.x < 0 || p.y < 0 || p.x >= N || p.y >= M) continue;
						if(!hs.contains(p.x + " " + p.y)) {
							hs.add(p.x + " " + p.y);
							arr[p.x][p.y] += time;
						}
						else continue;
						if(time == 1) continue;
						if(p.x + 1 >= N) continue;//벽 끝까지 다 갔다
						
						//벽 확인
						if(p.x + 1 < N && p.y + 1 < M && !wall[p.x][p.y][1] && !wall[p.x + 1][p.y + 1][0]) q.offer(new Pair(p.x + 1, p.y + 1));//오른쪽 벽 없음
						if(p.x + 1 < N && p.y - 1 >= 0 && !wall[p.x][p.y - 1][1] && !wall[p.x + 1][p.y - 1][0]) q.offer(new Pair(p.x + 1, p.y - 1));//왼쪽 벽 없음
						if(!wall[p.x + 1][p.y][0]) q.offer(new Pair(p.x + 1, p.y));//아래쪽 벽 없음
					}
					--time;
					if(time == 0) break;
				}
			}
		}// aly
	}
}
class Pair {
	int idx, x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	Pair(int idx, int x, int y) {
		this.idx = idx;
		this.x = x;
		this.y = y;
	}
}