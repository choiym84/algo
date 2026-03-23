import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int map[][];
	static int dp[][][];


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		dp = new int[N][N][3];
		boolean visited[][][] = new boolean[N][N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0][0] = 1;
		dp[0][1][0] = 1;
		
		
		for(int i = 0;i < N;i++) {
			for(int j = 2;j < N;j++) {
				
				if (map[i][j] == 1) continue;

                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][1];


                if (i - 1 >= 0) {
                    dp[i][j][2] = dp[i - 1][j][2] + dp[i - 1][j][1];
                }

                if (i - 1 >= 0 && map[i - 1][j] == 0 && map[i][j - 1] == 0) {
                    dp[i][j][1] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }
				
			}
		}
		
		
		int sum = 0;
		for(int i = 0;i < 3;i++) {
			sum += dp[N-1][N-1][i];
		}
		
		System.out.println(sum);



	}
}
