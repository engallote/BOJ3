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
		while(true) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			if(N == 0 && K == 0) break;
			
			int[] order = new int[N + 1], par = new int[N + 1];
			order[0] = -6;
			
			int idx = -1, k = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				int num = Integer.parseInt(st.nextToken());
				
				if(num == K) k = i;
				if(order[i - 1] + 1 != num)//자식으로 넘어감
					idx += 1;
				
				order[i] = num;
				par[i] = idx;
			}
			
			int kp = par[k], res = 0;
			for(int i = 1; i <= N; i++) {
				if(par[i] != 0 && par[i] != kp && par[par[i]] == par[kp])
					++res;
			}
			
			bw.write(res+"\n");
		}
		bw.flush();
	}
}