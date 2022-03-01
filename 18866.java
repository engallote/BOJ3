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
		int[][] arr = new int[N + 1][2];
		int[][] y = new int[N + 1][2], o = new int[N + 1][2];
		int maxH = 0, maxS = 0, minH = 1000000000, minS = 1000000000;
		
		StringTokenizer st;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			if(arr[i][0] > 0 && arr[i][0] < minH) minH = arr[i][0];
			if(arr[i][1] > 0 && arr[i][1] > maxS) maxS = arr[i][1];
			y[i][0] = minH;
			y[i][1] = maxS;
		}
		
		for(int i = N; i >= 1; i--) {
			if(arr[i][0] > 0 && arr[i][0] > maxH) maxH = arr[i][0];
			if(arr[i][1] > 0 && arr[i][1] < minS) minS = arr[i][1];
			o[i][0] = maxH;
			o[i][1] = minS;
		}
		
		int res = -1;
		for(int i = N - 1; i >= 0; i--)
			if(y[i][0] > o[i + 1][0] && y[i][1] < o[i + 1][1]) {
				res = i;
				break;
			}
		
		bw.write(res+"");
		bw.flush();
	}
}