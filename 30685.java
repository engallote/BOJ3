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
		int N = Integer.parseInt(br.readLine());
		
		Pair[] arr = new Pair[N];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			arr[i] = new Pair(x, h);
		}
		
		Arrays.sort(arr);
		
		int l = 0, r = 500000000, mid, time = -1;
		boolean flag = false;
		while(l <= r) {
			mid = (l + r) / 2;
			
			int pr = Integer.MIN_VALUE;
			int calc = ((arr[0].h - 1) / 2 <= mid ? (arr[0].h - 1) / 2 : mid);
			int xl = arr[0].x - calc;
			int xr = arr[0].x + calc;
			pr = xr;
			flag = true;
			for(int i = 1; i < N; i++) {
				calc = ((arr[i].h - 1) / 2 <= mid ? (arr[i].h - 1) / 2 : mid);
				xl = arr[i].x - calc;
				xr = arr[i].x + calc;
				
				if(pr >= xl) {
					flag = false;
					break;
				}
				
				pr = xr;
			}
			
			if(flag) {
				l = mid + 1;
				if(time < mid) time = mid;
			}
			else r = mid - 1;
		}
		
		if(time != 500000000) bw.write(time + "");
		else bw.write("forever");
		bw.flush();
	}
}
class Pair implements Comparable<Pair>{
	int x, h;
	Pair(int x, int h) {
		this.x = x;
		this.h = h;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.x, o.x);
	}
}