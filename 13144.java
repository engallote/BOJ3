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
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int l = 0, r = 0;
		long res = 0;
		boolean flag = true;
		while(l <= r && r < N) {
			flag = true;
			
			for(int i = l; i < r; i++)
				if(arr[i] == arr[r]) {
					flag = false;
					break;
				}
			
			if(flag) ++r;
			else {
				res += (long)(r - l);
				++l;
			}
		}
		
		for(int i = l; i < N; i++) res += (long)(r - i);
		
		System.out.println(res);
	}
}