import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int INF = 1000000000;

        int N = Integer.parseInt(br.readLine());
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }


        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());

            adj.get(a).add(new int[]{b, w});

        }
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken())-1;
        int B = Integer.parseInt(st.nextToken())-1;


        int dist[] = new int[N];
        boolean visited[] = new boolean[N];

        Arrays.fill(dist,INF);
        dist[A] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{A, 0});

        while (!pq.isEmpty()) {

            int v[] = pq.poll();
            int x = v[0];
            int w = v[1];
            visited[x] = true;
            dist[x] = w;

            if(x == B) break;

            for(int[] s:adj.get(x)){
                int nx = s[0];
                int e = s[1];
                if(visited[nx]) continue;

                if (dist[nx] > dist[x] + e) {
                    pq.add(new int[]{nx, w + e});
                    dist[nx] = dist[x] + e;
                }
            }
        }

        System.out.println(dist[B]);

    }
}