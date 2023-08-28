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
		int M = Integer.parseInt(st.nextToken());
		
		int[] hi = new int[N], arc = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) hi[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) arc[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(hi);
		Arrays.sort(arc);
		
		long h = 0, a = 0, d = 0;
		for(int i = 0; i < N; i++) {
			int l = 0, r = M - 1, mid;
			while(l <= r) {
				mid = (l + r) / 2;
				
				if(arc[mid] > hi[i]) {
					r = mid - 1;
				}
				else l = mid + 1;
			}
			
			if(r >= 0) h += (long)r + 1l;
			if(l < M) a += (long)M - (long)l;
			
			for(int j = r; j >= 0; j--) {
				if(hi[i] == arc[j]) {
					h -= 1l;
					d += 1l;
				}
				else break;
			}
		}
		
		bw.write(h + " " + a + " " + d + "\n");
		bw.flush();
	}
}