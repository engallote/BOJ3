import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N;
	static boolean flag;
	static int[][] arr, dp;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		while(--T >= 0) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][4];
			dp = new int[N][7];
			flag = false;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				String op1 = st.nextToken();
				int num1 = Integer.parseInt(st.nextToken());
				
				String op2 = st.nextToken();
				int num2 = Integer.parseInt(st.nextToken());
				
				if(op1.equals("+")) arr[i][0] = 0;
				else arr[i][0] = 1;
				
				if(op2.equals("+")) arr[i][2] = 0;
				else arr[i][2] = 1;
				
				arr[i][1] = num1;
				arr[i][3] = num2;
				
				Arrays.fill(dp[i], -1);
			}
			
			solve(0, 1);
			
			if(flag) bw.write("LUCKY");
			else bw.write("UNLUCKY");
			
			bw.newLine();
		}
		bw.flush();
	}
	private static void solve(int idx, int num) {
		if(idx == N) {
			if(num == 0) flag = true;
			return;
		}
		if(dp[idx][num] != -1 || flag) return;
		
		dp[idx][num] = 0;
		solve(idx + 1, arr[idx][0] == 0 ? (num + arr[idx][1]) % 7 : (num * arr[idx][1]) % 7);
		solve(idx + 1, arr[idx][2] == 0 ? (num + arr[idx][3]) % 7 : (num * arr[idx][3]) % 7);
	}
}