import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[1000001];
		int res = 0;
		
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			
			if(arr[num] > 0) {
				arr[num] -= 1;
				if(num - 1 > 0) arr[num - 1] += 1;
			}
			else {
				if(num - 1 > 0) arr[num - 1] += 1;
				++res;
			}
		}
		
		System.out.println(res);
	}
}