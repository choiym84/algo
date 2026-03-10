
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tcase = Integer.parseInt(br.readLine());
		int INF = 1_000_000_000;
		for (int t = 1; t <= tcase; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			List<Edge> edges = new ArrayList<>();

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				
				edges.add(new Edge(S,E,T));
				edges.add(new Edge(E,S,T));
			}
			
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());

				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken())*-1;
				
				edges.add(new Edge(S,E,T));
			}
			
			
			int[] dist = new int[N+1];
			Arrays.fill(dist,0);
			
//			Collections.sort(edges,(a,b)->a.w-b.w);
			
			dist[1] = 0;
			boolean is_cycle = false;
			for(int i = 0;i < N;i++) {
				
				for(Edge edge:edges) {
					
					int e = edge.e;
					int s = edge.s;
					int w = edge.w;
					
					if (i == N-1 && dist[e] > dist[s]+w && dist[s] != INF) {
						is_cycle = true;
						break;
					}
					if(dist[s] == INF) continue;
					dist[e] = Math.min(dist[e], dist[s]+w); 
					
					
				}
				if(is_cycle == true) break;
			}
			
			sb.append(is_cycle?"YES":"NO").append("\n");
			
			

		}
		
		System.out.println(sb);
	}
}


class Edge{
	int s;
	int e;
	int w;
	
	Edge(int s,int e,int w){
		this.s = s;
		this.e = e;
		this.w = w;
	}
}