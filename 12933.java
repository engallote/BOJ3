import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	char[] ch = sc.next().toCharArray();
    	char[] chr = {'q', 'u', 'a', 'c', 'k'};
    	int[] arr = new int[1000];
    	Arrays.fill(arr, -1);
    	
    	int idx = 0, cnt = 0;
    	for(char c : ch) {
    		boolean flag = false;
			for(int j = 0; j <= idx; j++) {
				if(chr[arr[j] + 1] == c) {
					flag = true;
					arr[j] += 1;
					
					if(arr[j] == 4) {
						arr[j] = -1;
						cnt += 5;
					}
					break;
				}
			}
			
			if(!flag && c == 'q') {
				arr[idx + 1] = 0;
				++idx;
			}
    	}
    	
    	if(cnt != ch.length) System.out.println(-1);
    	else System.out.println(idx + 1);
	}
}