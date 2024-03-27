import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int T = sc.nextInt();
		int W = sc.nextInt();
		int[] arr = {0, 1, 0, 1, 0, 1};
		int cnt = 2, cur = 0, idx = 0, count = 0;
		
		while(true) {
			if(idx >= 4) {
				count += 1;
				if(arr[idx] == W) T -= 1;
				
				if(count == cnt) {
					count = 0;
					idx += 1;
				}
				
				if(idx == arr.length) {
					idx = 0;
					cnt += 1;
				}
			}
			else {
				if(arr[idx] == W) T -= 1;
				
				idx += 1;
				
				if(idx == arr.length) {
					idx = 0;
					cnt += 1;
				}
			}
			
			if(T == 0) break;
			
			cur += 1;
			cur %= N;
		}
		
		System.out.println(cur);
	}
}