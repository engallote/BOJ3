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
		int[] arr = new int[N];
		int[] cnt = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			cnt[arr[i]] += 1;
		}
		
		st = new StringTokenizer(br.readLine());
		int u = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		if(cnt[1] > u) {
			bw.write("NO");
			bw.flush();
			return;
		}
		else u -= cnt[1];
		
		if(cnt[2] > d) {
			bw.write("NO");
			bw.flush();
			return;
		}
		else d -= cnt[2];
		
		if(cnt[3] >= d + u) {
			bw.write("YES\n");
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < N; i++) {
				if(arr[i] == 1) {
					sb.append('U');
				}
				else if(arr[i] == 2) {
					sb.append('D');
				}
				else {
					if(u > 0) {
						u -= 1;
						sb.append('U');
					}
					else if(d > 0) {
						d -= 1;
						sb.append('D');
					}
				}
			}
			
			bw.write(sb.toString());
		}
		else bw.write("NO");
		bw.flush();
	}
}