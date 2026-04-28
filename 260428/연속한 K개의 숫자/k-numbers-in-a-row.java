import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];

		for (int i = 0; i < B; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			arr[k] = 1;

		}

		int[] prefixsum = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			prefixsum[i] = prefixsum[i - 1] + arr[i];
		}
		
		int min = 1_000_000_000;
		
		for(int i = 1;i <= N - K + 1;i++) {
			
			min = Math.min(min, prefixsum[i + K-1]-prefixsum[i-1]);
			
			
		}
		
		System.out.println(min);

	}
}
