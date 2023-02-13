import java.util.*;

public class Main {
	static int N, K;
	static ArrayList<Pair>[] aly;
	static int[][][] dp;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	K = sc.nextInt();
    	aly = new ArrayList[6];
    	dp = new int[6][N + 1][200];
    	
    	for(int i = 1; i <= 5; i++) aly[i] = new ArrayList<>();
    	
    	for(int i = 0; i < N; i++) {
    		int d = sc.nextInt();
    		int s = sc.nextInt();
    		int e = sc.nextInt();
    		aly[d].add(new Pair(s, e));
    	}
    	
    	for(int i = 1; i <= 5; i++) {
    		Collections.sort(aly[i]);
    		for(int j = 0; j <= N; j++) Arrays.fill(dp[i][j], -1);
    	}
    	
    	int res = solve(1, 0, 0, 0);
    	System.out.println(res);
	}
	private static int solve(int day, int idx, int e, int sum) {
		if(day >= 5 || sum > K) return 0;
		if(sum == K) return 1;
		if(dp[day][idx][sum] != -1) return dp[day][idx][sum];
		
		int ret = 0;
		
		dp[day][idx][sum] = 0;
//		System.out.println(day + " " + idx + " " + e + " " + sum);
		ret += solve(day + 1, 0, 0, sum);
		for(int i = 0; i < aly[day].size(); i++) {
			Pair p = aly[day].get(i);
			if(p.s > e) ret += solve(day, i + 1, p.e, sum + (p.e - p.s + 1));
		}
		
		return dp[day][idx][sum] = ret;
	}
}
class Pair implements Comparable<Pair>{
	int s, e;
	Pair(int s, int e) {
		this.s = s;
		this.e = e;
	}
	@Override
	public int compareTo(Pair o) {
		if(this.s < o.s) return -1;
		else if(this.s == o.s) return Integer.compare(this.e, o.e);
		else return 1;
	}
}