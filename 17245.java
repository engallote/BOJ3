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
		int N = Integer.parseInt(br.readLine());
		ArrayList<Long> aly = new ArrayList<>();
		long sum = 0;
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				long num = Long.parseLong(st.nextToken());
				if(num == 0) continue;
				aly.add(num);
				sum += num;
			}
		}
		
		Collections.sort(aly);
		
		double div = (double) sum / 2.0;
		long l = 0, r = 100000000, mid, res = Long.MAX_VALUE;
		while(l <= r) {
			mid = (l + r) / 2;
			
			long cnt = 0;
			for(int i = 0; i < aly.size(); i++) {
				if(aly.get(i) >= mid) {
					cnt += mid * (aly.size() - i);
					break;
				}
				else cnt += aly.get(i);
			}
			
			if(cnt >= div) {
				res = Math.min(res, mid);
				r = mid - 1;
			}
			else l = mid + 1;
		}
		
		bw.write(res + "");
		bw.flush();
	}
}