import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	String str = sc.next();
    	int s = 0, b = 0;
    	
    	for(char c : str.toCharArray()) {
    		if(c == 's') ++s;
    		else if(c == 'b') ++b;
    	}
    	
    	if(s > b) System.out.println("security!");
    	else if(s < b) System.out.println("bigdata?");
    	else System.out.println("bigdata? security!");
	}
}