import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] num = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		int s = 0;
		int e = N-1;
		int count = 0;
		while(s < e) {
			
			if(num[s] + num[e] == K) {
				count++;
				s++;
				e--;
			}
			else if(num[s] + num[e] > K) {
				e--;
			}else {
				s++;
			}
			
			
			
		}
		
		System.out.println(count);
		
		

	}
}
