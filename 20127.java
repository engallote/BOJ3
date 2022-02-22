import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		//증가
		int idx = 0, cnt = 0, res = N;
		for(int i = 1; i < N; i++) {
			if(arr[i] >= arr[i - 1]) continue;
			else {
				++cnt;
				idx = i;
			}
		}
		
		if(cnt == 1 && arr[0] >= arr[N - 1]) res = Math.min(res, idx);
		else if(cnt == 0) res = 0;
		
		//감소
		cnt = 0;
		idx = 0;
		for(int i = 1; i < N; i++) {
			if(arr[i] <= arr[i - 1]) continue;
			else {
				++cnt;
				idx = i;
			}
		}
		
		if(cnt == 1 && arr[0] <= arr[N - 1]) res = Math.min(res, idx);
		else if(cnt == 0) res = 0;
		
		System.out.println(res == N ? -1 : res);
	}
}