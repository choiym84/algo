import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int p[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());

			int islands[][] = new int[N][2];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {


				islands[i][0] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {


				islands[i][1] = Integer.parseInt(st.nextToken());
			}

			long edges[][] = new long[N * (N - 1) / 2][3];
			double e = Double.parseDouble(br.readLine());

			int size = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {

					long x = Math.abs(islands[i][0] - islands[j][0]);
					long y = Math.abs(islands[i][1] - islands[j][1]);

					edges[size++] = new long[] { i, j, (x*x)+(y*y) };
				}
			}

			long cost = 0;
			p = new int[N];
			int cnt = 0;
			for (int i = 0; i < N; i++)
				p[i] = i;
			Arrays.sort(edges, (a, b) -> Long.compare(a[2], b[2]));

			for (int i = 0; i < size; i++) {

				int u = (int) edges[i][0];
				int v = (int) edges[i][1];

				if (union(u, v)) {
					cost += edges[i][2];
					if (++cnt == N - 1)
						break;
				}

				

			}
			
			sb.append("#").append(t).append(" ").append(Math.round(cost*e)).append("\n");

		}
		System.out.println(sb);

	}

	static int findSet(int a) {
		if (a == p[a])
			return a;

		return p[a] = findSet(p[a]);
	}

	static boolean union(int a, int b) {
		int pa = findSet(a);
	    int pb = findSet(b);

	    if (pa == pb) return false;
	    p[pb] = pa;
	    return true;
	}

}
