

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Edge {
		int no, weight;

		public Edge(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}

	}

	static int max_cost, start;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<List<Edge>> adj = new ArrayList<>();
		for (int i = 0; i < N; i++)
			adj.add(new ArrayList<>());

		for (int i = 0; i < N; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int v = Integer.parseInt(st.nextToken()) - 1;

			while (true) {

				int a = Integer.parseInt(st.nextToken()) - 1;
				if (a == -2)
					break;

				int w = Integer.parseInt(st.nextToken());

				adj.get(v).add(new Edge(a, w));

			}

		}

		boolean visited[] = new boolean[N];

		visited[0] = true;
		DFS(visited, 0, 0, adj);
		
		visited = new boolean[N];
		max_cost = 0;
		visited[start] = true;
		DFS(visited,start,0,adj);
		
		System.out.println(max_cost);
	}

	static void DFS(boolean[] visited, int v, int cost, List<List<Edge>> adj) {

		boolean end = true;
		for (Edge e : adj.get(v)) {

			if (visited[e.no])
				continue;

			end = false;
			visited[e.no] = true;
			DFS(visited, e.no, cost + e.weight, adj);
			visited[e.no] = false;
		}

		if (end) {

			if (max_cost < cost) {
				max_cost = cost;
				start = v;
			}
			return;
		}

	}

}
