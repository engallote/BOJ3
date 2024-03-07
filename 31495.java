import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		if(str.charAt(0) != '"' || str.charAt(str.length() - 1) != '"') {
			System.out.println("CE");
			return;
		}
		
		int idx1 = -1, idx2 = -1;
		if(str.contains("\"")) idx1 = str.indexOf('"');
		
		if(idx1 == -1) {
			System.out.println("CE");
			return;
		}
		
		String str2 = str.substring(idx1 + 1);
		if(str2.contains("\"")) idx2 = str2.indexOf('"');
		
		if(idx2 == -1) {
			System.out.println("CE");
			return;
		}
		
		String res = str2.substring(0, idx2);
		
		int cnt = 0;
		for(int i = 0; i < res.length(); i++)
			if(res.charAt(i) != ' ') {
				cnt += 1;
				break;
			}
		
		System.out.println(cnt == 0 ? "CE" : res);
	}
}