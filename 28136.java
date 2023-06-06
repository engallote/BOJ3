import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int min = 100000000, idx = 0;
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] < min) {
				min = arr[i];
				idx = i;
			}
		}
		
		int pre = 0, end = idx, res = 1;
		while(true) {
			int num = arr[idx];
			
			if(pre >= num)
				res += 1;
			
			pre = num;
			idx += 1;
			idx %= N;
			
			if(idx == end) break;
		}
		
		System.out.println(res);
	}
}