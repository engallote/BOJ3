import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringBuilder sb = new StringBuilder();
		int min = Integer.MAX_VALUE, minIdx = 0, max = -1, maxIdx = 0, ret = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(i == 0) {
				min = num;
				max = num;
				minIdx = i;
				maxIdx = i;
				sb.append("0 ");
				continue;
			}
			
			if(max < num) {
				max = num;
				maxIdx = i;
			}
			
			if(min > num) {
				min = num;
				minIdx = i;
			}
			
			if(maxIdx > minIdx) {
				ret = Math.max(ret, max - min);
				sb.append(ret + " ");
			}
			else {
				sb.append(ret + " ");
				max = -1;
				maxIdx = -1;
			}
		}
		
		System.out.println(sb.toString());
	}
}