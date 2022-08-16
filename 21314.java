import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.next().toCharArray();
		String max = "", min = "";
		int m = 0;
		StringBuilder sb = new StringBuilder();
		int k = 0;
		
		//최대
		for(int i = 0; i < ch.length; i++) {
			if(ch[i] == 'K') {
				k += 1;
				sb.append(5);
				for(int j = 0; j < m; j++) sb.append(0);
				m = 0;
			}
			else m += 1;
		}
		if(m > 0) {
			for(int j = 0; j < m; j++) sb.append(1);
		}
		
		if(k == 0) {
			sb = new StringBuilder();
			for(int i = 0; i < ch.length; i++) sb.append(1);
		}
		max = sb.toString();
		
		sb = new StringBuilder();
		m = 0;
		//최소
		for(int i = 0; i < ch.length; i++) {
			if(ch[i] == 'K') {
				if(m > 0) {
					sb.append(1);
					for(int j = 1; j < m; j++) sb.append(0);
				}
				sb.append(5);
				m = 0;
			}
			else m += 1;
		}
		if(m > 0) {
			sb.append(1);
			for(int j = 1; j < m; j++) sb.append(0);
		}
		
		min = sb.toString();
		
		System.out.println(max);
		System.out.println(min);
	}
}