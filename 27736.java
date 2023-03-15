import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int ap = 0, re = 0, in = 0;
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			
			if(num == 1) ap += 1;
			else if(num == -1) re += 1;
			else in += 1;
		}
		
		if(in >= (N + 1) / 2) System.out.println("INVALID");
		else if(ap > re) System.out.println("APPROVED");
		else System.out.println("REJECTED");
	}
}