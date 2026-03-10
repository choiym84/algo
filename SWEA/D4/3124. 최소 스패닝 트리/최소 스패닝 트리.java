
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			p = new int[V + 1];
			for (int i = 1; i <= V; i++) {
				p[i] = i;
			}
			int edges[][] = new int[E][3];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());

				edges[i][0] = Integer.parseInt(st.nextToken());
				edges[i][1] = Integer.parseInt(st.nextToken());
				edges[i][2] = Integer.parseInt(st.nextToken());

			}

			Arrays.sort(edges, (a, b) -> a[2] - b[2]);

			long cost = 0;
			int cnt = 0;
			for (int i = 0; i < E; i++) {
				if (union(edges[i][0], edges[i][1])) {
					cost += edges[i][2];

					if (++cnt == V - 1)
						break;
				}
			}

			sb.append("#").append(t).append(" ").append(cost).append("\n");
		}

		System.out.print(sb);

	}

	static int findSet(int a) {
		if (a == p[a])
			return a;

		return p[a] = findSet(p[a]);
	}

	static boolean union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);

		if (rootA == rootB)
			return false;

		p[rootA] = rootB;
		return true;
	}

}
