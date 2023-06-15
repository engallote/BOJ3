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
		int Q = Integer.parseInt(st.nextToken());
		char[] ch = br.readLine().trim().toCharArray();
		int[] red = new int[N], blue = new int[N];
		
		int bIdx = 0, rIdx = 0;
		for(int i = 0, j = N - 1; i < N; i++, j--) {
			red[j] = rIdx;
			blue[i] = bIdx;
			if(ch[i] == 'B') bIdx = i;
			if(ch[j] == 'R') rIdx = j;
		}
		
		int a = 0, b = 0, c = 0, d = 0;
		while(--Q >= 0) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			a = -1;
			b = -1;
			c = -1;
			d = -1;
			
			int idx = l;
			while(idx <= r) {
				if(ch[idx] == 'R') {
					a = idx;
					if(red[idx] != 0) b = red[idx];
					break;
				}
				else {
					if(red[idx] != 0) idx = red[idx];
					else break;
				}
			}
			
			idx = r;
			while(idx >= l) {
				if(ch[idx] == 'B') {
					d = idx;
					if(blue[idx] != 0) c = blue[idx];
					break;
				}
				else {
					if(blue[idx] != 0) idx = blue[idx];
					else break;
				}
			}
			
			if(a < b && b < c && c < d) bw.write(a + " " + b + " " + c + " " + d + "\n");
			else bw.write("-1\n");
		}
		bw.flush();
	}
}