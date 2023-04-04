import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.nextLine().trim().toCharArray();
		int space = sc.nextInt();
		int[] alp = new int[26];
		
		for(int i = 0; i < 26; i++) alp[i] = sc.nextInt();
		
		char pre = '.';
		StringBuilder sb = new StringBuilder();
		boolean first = true, flag = true;
		for(char c : ch) {
			if(c == pre) continue;
			if('a' <= c && c <= 'z') {
				if(alp[c - 'a'] > 0) {
					alp[c - 'a'] -= 1;
					if(first) {
						sb.append(c);
						first = false;
					}
				}
				else {
					flag = false;
					break;
				}
			}
			else if('A' <= c && c <= 'Z') {
				if(alp[c - 'A'] > 0) {
					alp[c - 'A'] -= 1;
					if(first) {
						sb.append(c);
						first = false;
					}
				}
				else {
					flag = false;
					break;
				}
			}
			else {//space bar
				first = true;
				if(space > 0) space -= 1;
				else {
					flag = false;
					break;
				}
			}
			pre = c;
		}
		
		if(flag) {
			ch = sb.toString().toUpperCase().toCharArray();
			for(char c : ch) {
				if(alp[c - 'A'] > 0) alp[c - 'A'] -= 1;
				else {
					System.out.println(-1);
					return;
				}
			}			
			
			System.out.println(sb.toString().toUpperCase());
		}
		else System.out.println(-1);
	}
}