import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.next().toCharArray();
		int N = sc.nextInt();
		
		char[] alp = new char[150];
		
		for(char c = 'A'; c <= 'Z'; c++) alp[c] = c;
		for(char c = 'a'; c <= 'z'; c++) alp[c] = c;
		
		StringBuilder sb;
		while(--N >= 0) {
			int order = sc.nextInt();
			
			if(order == 1) {
				char a = sc.next().charAt(0);
				char b = sc.next().charAt(0);
				
				for(int i = 65; i < 123; i++)
					if(alp[i] == a) alp[i] = b;
			}
			else {
				sb = new StringBuilder();
				for(char c : ch) {
					sb.append(alp[c]);
				}
				
				System.out.println(sb.toString());
			}
		}
	}
}