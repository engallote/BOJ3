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
		Pair[] arr = new Pair[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(arr);
		
		long time = 0, crazy = 0;
		for(Pair p : arr) {
			if(crazy + (long)p.k * (long)p.t > K) {
				long sub = (crazy + (long)p.k * (long)p.t) - K;
				time += sub;
				crazy -= sub;
			}
			
			crazy += (long)p.k * (long)p.t - Math.min((long)p.k * (long)p.t, 5l * (long)p.k);
			time += p.t;
			if(crazy < 0) crazy = 0;
		}
		
		bw.write(time+"");
		bw.flush();
	}
}
class Pair implements Comparable<Pair>{
	int k, t;
	Pair(int k, int t) {
		this.k = k;
		this.t = t;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.k < this.k) return -1;
		else if(o.k == this.k) return Integer.compare(this.t, o.t);
		else return 1;
	}
}