
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] nums;
	static int[] selected_nums;
	static int[] n;
	static int N;
	static int M;
	static int K;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nums = new int[10001];
		selected_nums = new int[M];
		st = new StringTokenizer(br.readLine());
		n = new int[8];
		K = 0;
		for (int i = 0; i < N; i++) {
			int idx = Integer.parseInt(st.nextToken());
			if (nums[idx] == 0)
				n[K++] = idx;
			nums[idx]++;
		}
		
		n = Arrays.copyOf(n, K);
		
		Arrays.sort(n);
		
		
		
		recur(0);
		
		System.out.println(sb);

	}

	static void recur(int depth) {
		if (depth == M) {
			for(int i = 0;i < M;i++) {
				sb.append(selected_nums[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int k = 0; k < K; k++) {

			if (nums[n[k]] <= 0)
				continue;

			selected_nums[depth] = n[k];
			nums[n[k]]--;
			recur(depth + 1);
			nums[n[k]]++;

		}

	}

}
