import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	char X = sc.next().charAt(0);
    	
    	HashSet<String> hs = new HashSet<>();
    	for(int i = 0; i < N; i++) hs.add(sc.next());
    	
    	if(X == 'Y') System.out.println(hs.size());
    	else if(X == 'F') System.out.println(hs.size() / 2);
    	else System.out.println(hs.size() / 3);
	}
}