import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// ------여기에 솔루션 코드를 작성하세요.------------

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int INF = 1_000_000_000;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken()) - 1;

		int[][] adj = new int[N][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());

			adj[a][b] = w;
		}

		int dist1[] = new int[N];
		boolean[] visited = new boolean[N];
		Arrays.fill(dist1, INF);

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			return a[1] - b[1];
		});

		pq.offer(new int[] { X, 0 });
		dist1[X] = 0;

		while (!pq.isEmpty()) {

			int[] n = pq.poll();
			int to = n[0];
			int w = n[1];

			if (visited[to])
				continue;

			visited[to] = true;

			for (int i = 0; i < N; i++) {

				if (visited[i])
					continue;
				if (adj[to][i] == 0)
					continue;
				if (dist1[i] > dist1[to] + adj[to][i]) {
					dist1[i] = dist1[to] + adj[to][i];
					pq.offer(new int[] { i, dist1[i] });
				}

			}
		}

		int dist2[] = new int[N];
		visited = new boolean[N];
		Arrays.fill(dist2, INF);

		pq.offer(new int[] { X, 0 });
		dist2[X] = 0;

		while (!pq.isEmpty()) {

			int[] n = pq.poll();
			int to = n[0];
			int w = n[1];

			if (visited[to])
				continue;

			visited[to] = true;

			for (int i = 0; i < N; i++) {

				if (visited[i])
					continue;
				if (adj[i][to] == 0)
					continue;
				if (dist2[i] > dist2[to] + adj[i][to]) {
					dist2[i] = dist2[to] + adj[i][to];
					pq.offer(new int[] { i, dist2[i] });
				}

			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {

			max = Math.max(max, dist1[i] + dist2[i]);

		}

		System.out.println(max);

	}

}