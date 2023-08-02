import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.next().toCharArray();
		
		int sum1 = 0, sum2 = 0, len = 0;
		for(int i = 0; i < ch.length; i++) {
			for(int j = 1; i + j < ch.length; j+=2) {
				char[] a = new String(ch).substring(i, i + j / 2 + 1).toCharArray();
				char[] b = new String(ch).substring(i + j / 2 + 1, i + j + 1).toCharArray();
				
				sum1 = 0;
				sum2 = 0;
				for(char c : a) sum1 += c - '0';
				for(char c : b) sum2 += c - '0';
				
				if(sum1 == sum2) len = Math.max(len, a.length + b.length);
			}
		}
		
		System.out.println(len);
	}
}