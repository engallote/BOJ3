import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) arr[i] = Long.parseLong(st.nextToken());
		
		Arrays.sort(arr);
		
		long l = 0, r = arr[0] * M, mid, sum, res = arr[0] * M;
		while(l <= r) {
			mid = (l + r) / 2;
			
			sum = 0l;
			for(int i = 0; i < N; i++) sum += mid / arr[i];
			
			if(sum >= M) {
				if(res > mid) res = mid;
				r = mid - 1;
			}
			else l = mid + 1;
		}
		
		System.out.println(res);
	}
}