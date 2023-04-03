import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] arr = new int[N + 1][2];
		HashSet<Integer> hs = new HashSet<>();
		for(int i = 1; i <= N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		int M = sc.nextInt();
		for(int i = 0; i < M; i++) hs.add(sc.nextInt());
		
		int res = 0;
		for(int i = 1; i <= N; i++) {
			if(hs.contains(i) || hs.contains(arr[i][0]) || hs.contains(arr[i][1])) continue;
			if(arr[i][0] == 0 || arr[i][1] == 0) continue;
			++res;
		}
		
		System.out.println(res);
	}
}