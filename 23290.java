import java.util.*;

public class Main {
	static int M, S, max;
	static boolean[] chk;
	static int[][] arr, cnt;
	static Queue<Pair> q = new LinkedList<>();
	static boolean[][] visit;
	static ArrayList<Pair> fish;
	static Pair shark;
	static PriorityQueue<String> pq = new PriorityQueue<>();
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1}, dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		S = sc.nextInt();
		chk = new boolean[1000001];
		arr = new int[5][5];
		cnt = new int[5][5];
		visit = new boolean[5][5];
		fish = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt() - 1;
			fish.add(new Pair(x, y, d));
		}
		
		int sx = sc.nextInt();
		int sy = sc.nextInt();
		shark = new Pair(sx, sy);
		
		Queue<Pair> copyFish = new LinkedList<>();
		while(--S >= 0) {
			//복사
			for(Pair p : fish) copyFish.offer(new Pair(p.x, p.y, p.d));
			
			//물고기 이동
			moveFish();
//			int size = q.size();
//			while(--size >= 0) {
//				Pair p = q.poll();
//				System.out.println(p.x + " " + p.y + " " + p.d);
//				q.offer(p);
//			}
			
			//상어 이동
			ArrayList<Integer> path = new ArrayList<>();
			ArrayList<Pair> path2 = new ArrayList<>();
			max = -1;
			pq.clear();
			moveShark(0, shark.x, shark.y, path, path2);
			
			//물고기 냠냠
			eatFish();
			
			//두 번 전 연습에서 생긴 물고기 냄새 제거
			removeSmell();
			
			//복사 완료
			fish.clear();
			while(!q.isEmpty()) {
				Pair p = q.poll();
				fish.add(p);
			}
			while(!copyFish.isEmpty()) fish.add(copyFish.poll());
		}
		
		System.out.println(fish.size());
	}
	private static void removeSmell() {
		for(int i = 1; i <= 4; i++)
			for(int j = 1; j <= 4; j++)
				if(arr[i][j] > 0) arr[i][j] -= 1;
	}
	private static void eatFish() {
		char[] ch = pq.poll().toCharArray();
//		System.out.println(new String(ch));
		
		pq.clear();
		int x = shark.x, y = shark.y, d = 0, size = 0;
		
		for(int i = 1; i < ch.length; i += 3) {
			int num = ch[i] - '0';
			if(num == 1) d = 2;//상
			else if(num == 2) d = 0;//좌
			else if(num == 3) d = 6;//하
			else d = 4;//우
			
			x += dx[d];
			y += dy[d];
			
//			System.out.println(x + ", " + y + "에 있는 " + cnt[x][y] + "마리 물고기 꽥!!ㅠㅠ");
			cnt[x][y] = 0;
			size = q.size();
			while(--size >= 0) {//물고기 제거
				Pair p = q.poll();
				
				if(p.x == x && p.y == y) {
					arr[p.x][p.y] = 3;
					continue;
				}
				q.offer(p);
			}
		}
		
		shark.x = x;
		shark.y = y;
		
//		System.out.println("현재 상어 위치 " + x + " " + y);
	}
	private static void moveShark(int time, int x, int y, ArrayList<Integer> path, ArrayList<Pair> path2) {
		if(time == 3) {//세 번 이동
			int cut = 0;
			HashSet<String> hs = new HashSet<>();
			for(Pair p : path2)
				if(!hs.contains(p.x + " " + p.y)) {
					hs.add(p.x + " " + p.y);
					cut += cnt[p.x][p.y];
				}
			
			if(max < cut) {
				max = cut;
				pq.clear();
				pq.offer(path.toString());
			}
			else if(max == cut) pq.offer(path.toString());
			return;
		}
		
		for(int i = 0; i < 8; i++)
			if(i == 0 || i == 2 || i == 4 || i == 6) {
				int nx = x + dx[i], ny = y + dy[i];
				if(nx <= 0 || ny <= 0 || nx > 4 || ny > 4) continue;
				
				if(i == 0) path.add(2);
				else if(i == 2) path.add(1);
				else if(i == 4) path.add(4);
				else path.add(3);
				path2.add(new Pair(nx, ny));
				
				moveShark(time + 1, nx, ny, path, path2);
				
				path2.remove(path2.size() - 1);
				path.remove(path.size() - 1);
			}
	}
	private static void moveFish() {
		for(int i = 1; i <= 4; i++) Arrays.fill(cnt[i], 0);
		
		boolean flag = true;
		for(int i = 0; i < fish.size(); i++) {
			Pair p = fish.get(i);
			flag = false;
			
			int d = p.d;
			for(int t = 0; t < 8; t++) {
				int nx = p.x + dx[d], ny = p.y + dy[d];
				if(nx <= 0 || ny <= 0 || nx > 4 || ny > 4) {
					d -= 1;
					if(d < 0) d = 7;
					continue;
				}
				if(shark.x == nx && shark.y == ny) {//상어가 있는 칸
					d -= 1;
					if(d < 0) d = 7;
					continue;
				}
				if(arr[nx][ny] != 0) {//물고기 냄새가 있는 칸
					d -= 1;
					if(d < 0) d = 7;
					continue;
				}
				
				flag = true;
				q.offer(new Pair(nx, ny, d));
				cnt[nx][ny] += 1;
				break;
			}
			
			if(!flag) {
				q.offer(new Pair(p.x, p.y, p.d));
				cnt[p.x][p.y] += 1;
			}
		}
		
//		for(int i = 1; i <= 4; i++) {
//			for(int j = 1; j <= 4; j++)
//				System.out.print(cnt[i][j] + " ");
//			System.out.println();
//		}
	}
}
class Pair {
	int x, y, d;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	Pair(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}