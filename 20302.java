import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int N = Integer.parseInt(br.readLine());
    	int[] arr = new int[100001];
    	
    	char op = '*';
    	boolean zero = false;
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; i++) {
    		int num = Integer.parseInt(st.nextToken());
    		
    		if(num == 0) zero = true;
    		
    		int tmp = Math.abs(num);
    		if(op == '*') {
    			int len = (int)Math.sqrt(tmp);
    			for(int j = 2; j <= len; j++)
    				while(tmp % j == 0) {
    					tmp /= j;
    					++arr[j];
    				}
    			if(tmp > 1) ++arr[tmp];
    		}
    		else {
    			int len = (int)Math.sqrt(tmp);
    			for(int j = 2; j <= len; j++)
    				while(tmp % j == 0) {
    					tmp /= j;
    					--arr[j];
    				}
    			if(tmp > 1) --arr[tmp];
    		}
    		
    		if(i == N - 1) break;
    		op = st.nextToken().charAt(0);
    	}
    	
    	if(zero) bw.write("mint chocolate");
    	else {
    		for(int i = 2; i <= 100000; i++)
    			if(arr[i] < 0) {
    				bw.write("toothpaste");
    				bw.flush();
    				return;
    			}
    		bw.write("mint chocolate");
    	}
    	bw.flush();
    }
}