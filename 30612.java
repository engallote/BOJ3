import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static long[] arr, left, right;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new long[N];
		left = new long[N];
		right = new long[N];
		long res = 0;
		
		int s = 0, e = 0;
		long pre = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			
			if(arr[i] == 0) {
				if(pre != 0) {
					res += makeArr(s, e);
				}
				s = i + 1;	
			}
			
			pre = arr[i];
			e = i;
		}
		
		if(s < e) res += makeArr(s, e);
		
		System.out.println(res);
	}
	private static long makeArr(int s, int e) {
		left[s] = arr[s];
		right[e] = arr[e];
		
		for(int i = s + 1, idx = e - 1; i < e; i++, idx--) {
			left[i] = Math.max(left[i - 1], arr[i]);
			right[idx] = Math.max(right[idx + 1], arr[idx]);
		}
		
		long sum = 0;
		for(int i = s + 1; i < e; i++) {
			if(arr[i] < Math.min(left[i], right[i])) sum += Math.min(left[i], right[i]) - arr[i];
		}
		
		return sum;
	}
}