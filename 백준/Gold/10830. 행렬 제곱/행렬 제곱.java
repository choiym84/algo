

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long mat[][];
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		mat = new long[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken())%1000;
			}
		}
		
		long [][] result = pow_mat(B);
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < N;i++) {
			for(int j = 0;j < N;j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	}

	static long[][] pow_mat(long exp) {

		if (exp == 1) {
			return mat;
		}

		long half[][] = pow_mat(exp / 2);
		long result[][] = mul(half,half);
		// 짝수 일 때
		if (exp % 2 == 0) {
			return result;
		}

		else {
			return mul(result,mat);
		}
		// 홀수 일 때

	}

	static long[][] mul(long[][] m1, long[][] m2) {

		long [][] result = new long[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for(int k = 0;k < N;k++) {
					
					result[i][j] = (result[i][j] + m1[i][k]*m2[k][j])%1000;
					
				}
			}

		}
		
		return result;

	}
}
