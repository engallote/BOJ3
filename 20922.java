import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N], sum = new int[100001];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int l = 0, r = 0, res = 0;
		while(r < N) {
			if(sum[arr[r]] + 1 <= K) {
				sum[arr[r]] += 1;
				r += 1;
			}
			else {
				sum[arr[l]] -= 1;
				l++;
			}
			res = Math.max(res, r - l);
		}
		
		bw.write(res+"");
		bw.flush();
	}
}