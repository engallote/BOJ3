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
		long X = Long.parseLong(st.nextToken());
		long[] a = new long[N], b = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) a[i] = Long.parseLong(st.nextToken());//弥家 个公霸
		
		long cur = 0, res = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			b[i] = Long.parseLong(st.nextToken());//骂绰 公霸
			cur += b[i];
			if(cur < a[i]) res = -1;
		}
		
		if(res == -1) {
			bw.write("-1");
			bw.flush();
			return;
		}
		
		cur = 0;
		res = 0;
		for(int i = 0; i < N; i++) {
			cur += b[i];
			
			if(a[i] > cur) {
				long div = (a[i] - cur) / X, mod = (a[i] - cur) % X;
				if(mod > 0) div += 1;
				res -= div;
				cur += div * X;
				
				if(cur < a[i]) {
					bw.write("-1");
					bw.flush();
					return;
				}
			}
			
			long div = (cur - a[i]) / X;
			cur -= X * div;
			res += div;
		}
		
		bw.write(res + "");
		bw.flush();
	}
}