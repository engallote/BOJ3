import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int[] arr = new int[L];
		
		for(int i = 0; i < L; i++) arr[i] = sc.nextInt();
		Arrays.sort(arr);
		
		int N = sc.nextInt();
		
		int res = 0;
		
		if(arr[0] > N) {
			for(int k =1; k <= N; k++) {
				for(int j = N; j < arr[0]; j++) {
					if(k == j) continue;
					res += 1;
				}
			}
		}
		else {
			for(int i = 0; i < L - 1; i++) {
				if(arr[i] < N && N < arr[i + 1]) {				
					for(int k = arr[i] + 1; k <= N; k++) {
						for(int j = N; j < arr[i + 1]; j++) {
							if(k == j) continue;
							res += 1;
						}
					}
					break;
				}
			}
		}
		
		
		System.out.println(res);
	}
}