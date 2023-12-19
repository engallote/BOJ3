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
		long T = Long.parseLong(st.nextToken());
		long[] arr = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) arr[i] = Long.parseLong(st.nextToken());
		
		Arrays.sort(arr);
		
		Stack<Long> s = new Stack<>();
		int idx = 0;
		
		while(idx < N) {
			if(arr[idx] < T) {
				s.push(arr[idx]);
			}
			else {
				while(!s.isEmpty() && T <= arr[idx]) {
					T += s.pop();
					K -= 1;
					
					if(K == 0) break;
				}
				
				if(T <= arr[idx]) break;
				
				s.push(arr[idx]);
			}
			
			if(K == 0) break;
			idx += 1;
		}
		
		while(K > 0 && !s.isEmpty()) {
			T += s.pop();
			K -= 1;
		}
		
		bw.write(T + "");
		bw.flush();
	}
}