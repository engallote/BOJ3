import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.next().toCharArray();
		StringBuilder sb = new StringBuilder();
		
		char pre = ch[0];
		sb.append(pre);
		
		for(int i = 1; i < ch.length; i++) {
			char c = ch[i];
			
			if(pre < c) {
				sb.reverse();
				sb.append(c);
				sb.reverse();
			}
			else {
				sb.append(c);
				pre = c;
			}
		}
		
		System.out.println(sb.reverse().toString());
	}
}