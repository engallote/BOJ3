import java.util.*;

public class Main {
	static int[][] arr;
	static boolean[] chk;
	static ArrayList<Integer>[] aly;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	arr = new int[12][12];
    	chk = new boolean[12];
    	aly = new ArrayList[6];
    	
    	int idx = 0;
    	for(int i = 0; i < 6; i++) {
    		aly[i] = new ArrayList<>();
    		aly[i].add(idx++);
    		aly[i].add(idx++);
    	}
    	
    	for(int i = 0; i < 12; i++)
    		for(int j = 0; j < 12; j++) arr[i][j] = sc.nextInt();
    	
    	chk[0] = true;
    	int res = solve(0, 0, 1, 1, 0);
    	chk[0] = false;
    	chk[1] = true;
    	res = Math.min(res, solve(1, 0, 1, 1, 0));
    	System.out.println(res);
	}
	private static int solve(int idx, int group, int gNum, int cnt, int sum) {
		if(cnt == 12) {
			return sum;
		}
		int ret = 100000000;
		
		if(gNum < 2) {
			for(int next : aly[group]) {
				if(chk[next])continue;
				chk[next] = true;
				ret = Math.min(ret, solve(next, group, gNum + 1, cnt + 1, sum + arr[idx][next]));
				chk[next] = false;
			}
		}
		else ret = solve(idx, group + 1, 0, cnt, sum);
		
		return ret;
	}
}