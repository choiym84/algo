import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // Please write your code here.
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	int line[][] = new int[N][2];
    	
    	int check[] = new int[200001];
    	
    	for(int i = 0;i < N;i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		
    		line[i][0] = Integer.parseInt(st.nextToken());
    		line[i][1] = Integer.parseInt(st.nextToken());
    		
    		check[line[i][0]] = 1;
    		check[line[i][1]] = -1;
    		
    	}
    	
    	Arrays.sort(line, (a,b)->a[0]-b[0]);
    	
//    	for(int i = 0;i < N;i++) {
//    		System.out.println(Arrays.toString(line[i]));
//    	}
//    	
    	int cnt = 0;
    	int max = 0;
    	int now = 0;
    	
    	for(int i = 1;i < 200001;i++) {
    		
    		now += check[i];
    		
    		if(now > max) {
    			max = now;
    			cnt = 1;
    		}
    		else if (now == max) {
    			if(check[i] == 1) {
    				cnt++;
    			}
    		}
    		
    	}
    	
    	System.out.println(cnt);
    	
    	
    	
    }
}