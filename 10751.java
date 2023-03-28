import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] ch = sc.next().toCharArray();
		long c = 0, co = 0, cow = 0;
		
		for(int i = 0; i < N; i++) {
			if(ch[i] == 'C') c += 1;
			else if(ch[i] == 'O') co += c;
			else cow += co;
		}
		
		System.out.println(cow);
	}
}