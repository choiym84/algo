

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int INF = 1_000_000_000;

		int map[][] = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(map[i], INF);
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			map[a][b] = w;

		}

		int vertex1[] = new int[N + 1];
		Arrays.fill(vertex1, INF);
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.add(new int[] { X, 0 });
		vertex1[X] = 0;
		while (!pq.isEmpty()) {

			int out[] = pq.poll();
			int v = out[0];
			int w = out[1];

			for (int i = 1; i <= N; i++) {

				if (vertex1[i] <= vertex1[v] + map[v][i])
					continue;
				pq.add(new int[] { i, map[v][i] });
				vertex1[i] = vertex1[v] + map[v][i];

			}
		}
		
		
		int vertex2[] = new int[N + 1];
		Arrays.fill(vertex2, INF);
		pq.add(new int[] { X, 0 });
		vertex2[X] = 0;
		while (!pq.isEmpty()) {

			int out[] = pq.poll();
			int v = out[0];
			int w = out[1];

			for (int i = 1; i <= N; i++) {

				if (vertex2[i] <= vertex2[v] + map[i][v])
					continue;
				pq.add(new int[] { i, map[i][v] });
				vertex2[i] = vertex2[v] + map[i][v];

			}
		}

		int max = 0;
		for(int i = 1;i <= N;i++) {
			max = Math.max(max,vertex1[i]+vertex2[i]);
		}
		
		System.out.println(max);

	}

}
