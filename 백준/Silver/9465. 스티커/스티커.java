

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			int N = Integer.parseInt(br.readLine());
			
			int map[][] = new int[2][N+1];
			int dp[][] = new int[2][N+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 1;i <= N;i++) {
				map[0][i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());			
			for(int i = 1;i <= N;i++) {
				map[1][i] = Integer.parseInt(st.nextToken());
			}
			
			dp[0][1] = map[0][1];
			dp[1][1] = map[1][1];
			
			for(int i = 2;i <= N;i++) {
				
				dp[0][i] = Math.max(dp[1][i-1], Math.max(dp[0][i-2],dp[1][i-2])) + map[0][i];
				dp[1][i] = Math.max(dp[0][i-1], Math.max(dp[0][i-2],dp[1][i-2])) + map[1][i];
		
			}
			
			
			sb.append(Math.max(dp[0][N],dp[1][N])).append("\n");
			
		}
		
		System.out.println(sb);

	}

}
