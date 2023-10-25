import java.util.*;

public class Main {
	static boolean flag = false;
	static int cnt = 0;
	static int[][] dp;
	static StringBuilder res = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		if(A <= B) {
			System.out.println("NO");
			return;
		}
		
		dp = new int[B + 1][B + 1];
		for(int i = 0; i <= B; i++) Arrays.fill(dp[i], -1);
		
		ArrayList<String> path = new ArrayList<>();
		solve(A, B, B, path);
		
		if(flag) {
			System.out.println("YES");
			System.out.println(cnt);
			System.out.println(res.toString());
		}
		else System.out.println("NO");
	}

	private static void solve(int a, int pb, int b, ArrayList<String> path) {
		if(flag) return;
		if(a == 0 && b == 0) {
			flag = true;
			cnt = path.size();
			res = new StringBuilder();
			for(String s : path) res.append(s + "\n");
			return;
		}
		if(dp[pb][b] != -1) return;
		
		dp[pb][b] = 1;
		StringBuilder sb;
		for(int i = 1; i <= b; i++)
			if(i + 1 <= a) {
				sb = new StringBuilder();
				sb.append("a");
				for(int j = 1; j <= i; j++) {
					sb.append("b");
					sb.append("a");
				}
				
				path.add(sb.toString());
				solve(a - (i + 1), b, b - i, path);
				path.remove(path.size() - 1);
			}
	}
}