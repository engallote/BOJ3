import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N][20];
		
		while(--M >= 0) {
			int order = sc.nextInt();
			if(order == 1) {
				int idx = sc.nextInt() - 1;
				int x = sc.nextInt() - 1;
				
				if(arr[idx][x] == 0) arr[idx][x] = 1;
			}
			else if(order == 2) {
				int idx = sc.nextInt() - 1;
				int x = sc.nextInt() - 1;
				
				arr[idx][x] = 0;
			}
			else if(order == 3) {
				int idx = sc.nextInt() - 1;
				
				for(int i = 19; i > 0; i--)
					arr[idx][i] = arr[idx][i - 1];
				arr[idx][0] = 0;
			}
			else {
				int idx = sc.nextInt() - 1;
				
				for(int i = 0; i < 19; i++)
					arr[idx][i] = arr[idx][i + 1];
				arr[idx][19] = 0;
			}
		}
		
		HashSet<String> hs = new HashSet<>();
		StringBuilder sb;
		for(int i = 0; i < N; i++) {
			sb = new StringBuilder();
			for(int j = 0; j < 20; j++) sb.append(arr[i][j]);
			
			hs.add(sb.toString());
		}
		
		System.out.println(hs.size());
	}
}