import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] arr = new char[N][];
		
		for(int i = 0; i < N; i++) arr[i] = sc.next().toCharArray();
		
		int res = 0;
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				if(match(arr[i], arr[j])) ++res;
			}
		}
		
		System.out.println(res);
	}

	private static boolean match(char[] a, char[] b) {
		String bStr = new String(b);
		StringBuilder sb = new StringBuilder();
		for(int i = a.length - 1; i >= 0; i--) {
			sb.append(a[i]);
			sb.reverse();
			
			if(bStr.startsWith(sb.toString())) return true;
			
			sb.reverse();
		}
		
		String aStr = new String(a);
		sb = new StringBuilder();
		for(int i = b.length - 1; i >= 0; i--) {
			sb.append(b[i]);
			sb.reverse();
			
			if(aStr.startsWith(sb.toString())) return true;
			
			sb.reverse();
		}
		return false;
	}
}