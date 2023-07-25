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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		long[] arr = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) arr[i] = Long.parseLong(st.nextToken());
		
		Arrays.sort(arr);
		
		long res = arr[N - 1];
		long l = 0, r = arr[N - 1], mid;
		while(l <= r) {
			mid = (l + r) / 2;
			
			long tmp = 0;
			for(int i = N - 1; i >= 0; i--) {
				if(arr[i] < mid) break;
				tmp += arr[i] - mid;
				if(tmp > K) break;
			}
			
			if(mid <= res && tmp <= K) {
				res = mid;
				r = mid - 1;
			}
			else l = mid + 1;
		}
		
		bw.write(res + "");
		bw.flush();
	}
}