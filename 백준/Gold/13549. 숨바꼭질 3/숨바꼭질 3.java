import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int l[] = new int [100001];
        int INF = 1_000_000_000;
        Arrays.fill(l,INF);

        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);
        l[N] = 0;
        while (!q.isEmpty()) {
            int v = q.poll();
            if(v == M) break;
            for (int i = 0; i < 3; i++) {
                int next;
                if(i == 0) next = v + 1;
                else if(i == 1) next = v - 1;
                else next = v *2 ;

                if(next < 0 || next > 100000) continue;

                if(l[next] <= l[v]) continue;

                if(i == 2) l[next] = l[v];
                else l[next] = l[v] + 1;
                q.add(next);

            }
        }

        System.out.println(l[M]==INF?-1:l[M]);



    }
}