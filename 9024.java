import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		while(--T >= 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			
			int l = 0, r = N - 1, sub = Integer.MAX_VALUE, sum, res = 0;
			while(l < r) {
				sum = arr[l] + arr[r];
				
				if(Math.abs(K - sum) < sub) {
					sub = Math.abs(K - sum);
					res = 1;
				}
				else if(Math.abs(K - sum) == sub) res += 1;
				
				if(sum < K) l += 1;
				else if(sum == K) {
					l += 1;
					r -= 1;
				}
				else r -= 1;
			}
			
			bw.write(res + "\n");
		}
		bw.flush();
	}
}