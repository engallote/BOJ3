import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] a = sc.next().toCharArray();
		char[] b = sc.next().toCharArray();
		int[] arr = new int[a.length];
		
		int j = 0;
		for(int i = 1; i < b.length; i++) {
			while(j > 0 && b[i] != b[j]) j = arr[j - 1];
			if(b[i] == b[j]) arr[i] = ++j;
		}
		
		j = 0;
		for(int i = 0; i < a.length; i++) {
			while(j > 0 && a[i] != b[j]) j = arr[j - 1];
			if(a[i] == b[j]) {
				if(j == b.length - 1) {
					System.out.println(1);
					return;
				}
				else j += 1;
			}
		}
		
		System.out.println(0);
	}
}