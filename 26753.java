import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	char[] ch = sc.next().toCharArray();
    	char[] word = {'o', 'i', 'j'};
    	int idx = 0;
    	
    	int res = 0;
    	for(char c : ch) {
    		if(c == word[idx]) ++idx;
    		
    		if(idx == 3) {
    			++res;
    			idx = 0;
    		}
    	}
    	
    	System.out.println(res > 0 ? res : "NIE");
	}
}