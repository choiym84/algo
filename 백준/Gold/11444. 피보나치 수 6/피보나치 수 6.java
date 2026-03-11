

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long[][] mat = { { 1, 1 }, { 1, 0 } };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());

		long[][] result = exp(n - 1);

		System.out.println(result[0][0]);

	}

	static long[][] exp(long e) {

		if (e <= 1L)
			return mat;

		long half[][] = exp(e / 2);

		long result[][] = mul(half, half);

		if (e % 2 == 0)
			return result;
		else
			return mul(result, mat);

	}

	static long[][] mul(long[][] m1, long[][] m2) {

		long[][] result = new long[2][2];

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					result[i][j] = (result[i][j] + (m1[i][k] * m2[k][j]) % 1_000_000_007) % 1_000_000_007;
				}
			}
		}

		return result;

	}

}
