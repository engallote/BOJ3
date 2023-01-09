import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[] arr = new int[N], ans = new int[N];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
    	
    	ans[N - 1] = -1;
    	for(int i = N - 2; i >= 0; i--) {
    		if(arr[i] == arr[i + 1]) ans[i] = ans[i + 1];
    		else ans[i] = i + 1;
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < N; i++) sb.append((ans[i] == -1 ? ans[i] : ans[i] + 1) + " ");
    	
    	System.out.println(sb.toString());
	}
}