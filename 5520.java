import java.util.*;

public class Main {
	static PriorityQueue<Integer> ans = new PriorityQueue<>();
	static int[][] ori;
	static int[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ori = new int[3][3];
		chk = new int[10];

		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++) ori[i][j] = sc.nextInt();
		
		ArrayList<Integer> path = new ArrayList<>();
		solve(1);
		
		while(!ans.isEmpty()) System.out.print(ans.poll() + " ");
	}
	private static void solve(int cnt) {
		if(!ans.isEmpty()) return;
		if(cnt == 10) {
			Queue<Integer> q = new LinkedList<>();
			int[][] arr = new int[3][3];
			
			for(int i = 0; i < 3; i++)
				for(int j = 0; j < 3; j++) arr[i][j] = ori[i][j];
			
			for(int i = 1; i <= 9; i++) {
				if(chk[i] == 0) continue;
				for(int k = 0; k < chk[i]; k++) {
					q.offer(i);
					if(i == 1) {
						roate(0, 0, arr);
						roate(0, 1, arr);
						roate(1, 0, arr);
						roate(1, 1, arr);
					}
					else if(i == 2) {
						roate(0, 0, arr);
						roate(0, 1, arr);
						roate(0, 2, arr);
					}
					else if(i == 3) {
						roate(0, 1, arr);
						roate(0, 2, arr);
						roate(1, 1, arr);
						roate(1, 2, arr);
					}
					else if(i == 4) {
						roate(0, 0, arr);
						roate(1, 0, arr);
						roate(2, 0, arr);
					}
					else if(i == 5) {
						roate(0, 1, arr);
						roate(1, 0, arr);
						roate(1, 1, arr);
						roate(1, 2, arr);
						roate(2, 1, arr);
					}
					else if(i == 6) {
						roate(0, 2, arr);
						roate(1, 2, arr);
						roate(2, 2, arr);
					}
					else if(i == 7) {
						roate(1, 0, arr);
						roate(1, 1, arr);
						roate(2, 0, arr);
						roate(2, 1, arr);
					}
					else if(i == 8) {
						roate(2, 0, arr);
						roate(2, 1, arr);
						roate(2, 2, arr);
					}
					else {
						roate(1, 1, arr);
						roate(1, 2, arr);
						roate(2, 1, arr);
						roate(2, 2, arr);
					}
					if(check(arr)) {
						ans.addAll(q);
						return;
					}
				}
			}			
			return;
		}
		
		for(int i = 0; i <= 3; i++) {
			chk[cnt] = i;
			
			solve(cnt + 1);
			
			chk[cnt] = 0;
		}
	}
	private static boolean check(int[][] arr) {
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				if(arr[i][j] != 0) return false;
		
		return true;
	}
	private static void roate(int x, int y, int[][] arr) {
		arr[x][y] += 1;
		arr[x][y] %= 4;
	}
}