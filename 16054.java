import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		HashMap<String, Integer> hm = new HashMap<>();
		int[][] arr = new int[200][200];
		
		for(int i = 0; i < 200; i++) Arrays.fill(arr[i], 1000000);
		
		int idx = 0;
		for(int i = 0; i < N; i++) {
			String[] str = sc.nextLine().split(" ");
			
			String a = str[0];
			String b = str[4];
			
			if(!hm.containsKey(a)) hm.put(a, idx++);
			if(!hm.containsKey(b)) hm.put(b, idx++);
			
			int aIdx = hm.get(a), bIdx = hm.get(b);
			arr[bIdx][aIdx] = 1;
			arr[aIdx][bIdx] = 500;
		}
		
		for(int k = 0; k < 200; k++)
			for(int i = 0; i < 200; i++)
				for(int j = 0; j < 200; j++)
					if(arr[i][k] + arr[k][j] < arr[i][j])
						arr[i][j] = arr[i][k] + arr[k][j];
		
		for(int i = 0; i < M; i++) {
			String[] str = sc.nextLine().split(" ");
			
			String a = str[0];
			String b = str[4];
			
			if(!hm.containsKey(a) || !hm.containsKey(b)) {
				System.out.println("Pants on Fire");
				continue;
			}
			
			int aIdx = hm.get(a), bIdx = hm.get(b);
			
			if(arr[bIdx][aIdx] != 1000000) {
				if(arr[bIdx][aIdx] < 500) System.out.println("Fact");
				else if(arr[aIdx][bIdx] < 500) System.out.println("Alternative Fact");
				else System.out.println("Pants on Fire");
			}
			else System.out.println("Pants on Fire");
		}
	}
}