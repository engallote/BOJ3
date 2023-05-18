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
		long K = Long.parseLong(st.nextToken());
		long res = 0;
		int idx = -1;
		
		for(int k = 1; k <= M; k++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			long r = Long.parseLong(st.nextToken());
			
			res += r;
			
			if(idx == -1 && res > K) idx = k;
		}
		
		if(idx == -1) bw.write("-1");
		else bw.write(idx + " 1");
		bw.flush();
	}
}