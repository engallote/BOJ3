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
		int D = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[300001];
		int max = -1;
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[num] += 1;
			
			max = Math.max(max, num);
		}
		
		long res = 0l;
		for(int i = max; i > 0 && D > 0; i--) {
			if(arr[i] == 0) continue;
			res += (long)arr[i];
			arr[i - 1] += arr[i];
			arr[i] = 0;
			D -= 1;
		}
		
		bw.write(res+"");
		bw.flush();
	}
}