import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int C = sc.nextInt();
		int[] arr = new int[N];
		HashSet<Integer> hs = new HashSet<>();
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			hs.add(arr[i]);
		}
		
		if(hs.contains(C)) {
			System.out.println(1);
			return;
		}
		
		Arrays.sort(arr);
		
		for(int i = N - 1; i >= 1; i--) {
			for(int j = i - 1; j >= 0; j--) {
				if(arr[i] + arr[j] == C) {
					System.out.println(1);
					return;
				}
				if(hs.contains(C - (arr[i] + arr[j])) && C - (arr[i] + arr[j]) != arr[i] && C - (arr[i] + arr[j]) != arr[j]) {
					System.out.println(1);
					return;
				}
			}
		}
		
		System.out.println(0);
	}
}