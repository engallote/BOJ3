import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] a = sc.next().toCharArray();
		char[] b = sc.next().toCharArray();
		
		if(a[0] != b[0] || a[N - 1] != b[N - 1]) {
			System.out.println("NO");
			return;
		}
		
		int[] alp = new int[26];
		StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			alp[a[i] - 'a'] += 1;
			alp[b[i] - 'a'] -= 1;
			
			if(a[i] != 'a' && a[i] != 'e' && a[i] != 'i' && a[i] != 'o' && a[i] != 'u') sb1.append(a[i]);
			if(b[i] != 'a' && b[i] != 'e' && b[i] != 'i' && b[i] != 'o' && b[i] != 'u') sb2.append(b[i]);
		}
		
		if(!sb1.toString().equals(sb2.toString())) {
			System.out.println("NO");
			return;
		}
		
		for(int i = 0; i < 26; i++)
			if(alp[i] != 0) {
				System.out.println("NO");
				return;
			}
		
		System.out.println("YES");
	}
}