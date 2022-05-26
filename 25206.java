import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double sum = 0, all = 0;
		
		for(int i = 0; i < 20; i++) {
			String name = sc.next();
			double score = sc.nextDouble();
			String g = sc.next();
			
			if(g.equals("P")) continue;
			
			all += score;
			
			if(g.equals("A+")) {
				sum += score * 4.5;
			}
			else if(g.equals("A0")) {
				sum += score * 4.0;
			}
			else if(g.equals("B+")) {
				sum += score * 3.5;
			}
			else if(g.equals("B0")) {
				sum += score * 3.0;
			}
			else if(g.equals("C+")) {
				sum += score * 2.5;
			}
			else if(g.equals("C0")) {
				sum += score * 2.0;
			}
			else if(g.equals("D+")) {
				sum += score * 1.5;
			}
			else if(g.equals("D0")) {
				sum += score * 1.0;
			}
			else {
				continue;
			}
		}
		
		System.out.println(String.format("%.6f", sum / all));
	}
}