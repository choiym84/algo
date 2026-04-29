import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		char[] str = br.readLine().toCharArray();

		int L[] = new int[N];
		int R[] = new int[N];

		L[0] = str[0] == 'C' ? 1 : 0;
		for (int i = 1; i < N; i++) {
			L[i] = L[i - 1] + (str[i] == 'C' ? 1 : 0);
		}
		
		
		R[N-1] = str[N - 1] == 'W' ? 1 : 0;
		
		for (int i = N - 2; i >= 0; i--) {
			R[i] = R[i + 1] + (str[i] == 'W' ? 1 : 0);
		}

		long ans = 0;
		for (int i = 0; i < N; i++) {

			if (str[i] == 'O') {

				ans += (L[i-1] * R[i+1]);

			}

		}
		System.out.println(ans);

	}
}
