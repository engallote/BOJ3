import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] alp = new int[26][26];
		sc.nextLine();
		for(int i = 0; i < 26; i++) Arrays.fill(alp[i], 1000);
		
		for(int i = 0; i < N; i++) {
			String[] arr = sc.nextLine().split(" ");
			char a = arr[0].charAt(0);
			char b = arr[2].charAt(0);
			
			alp[a - 'a'][b - 'a'] = 1;
		}
		
		for(int k = 0; k < 26; k++)
			for(int i = 0; i < 26; i++)
				for(int j = 0; j < 26; j++)
					if(alp[i][k] + alp[k][j] < alp[i][j])
						alp[i][j] = alp[i][k] + alp[k][j];
		
		int M = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < M; i++) {
			String[] arr = sc.nextLine().split(" ");
			char a = arr[0].charAt(0);
			char b = arr[2].charAt(0);
			
			if(alp[a - 'a'][b - 'a'] == 1000) System.out.println("F");
			else System.out.println("T");
		}
	}
}