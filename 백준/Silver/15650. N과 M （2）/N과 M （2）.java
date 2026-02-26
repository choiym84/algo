import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static boolean visited[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N+1];
        recur(0,1);

        System.out.println(sb);
    }

    static void recur(int depth,int prev){

        if(depth == M){
            for(int i = 0;i < M;i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for(int i = prev;i <= N;i++){
            if(visited[i] == true) continue;

            visited[i] = true;
            arr[depth] = i;
            recur(depth+1,i);
            visited[i] = false;
        }

    }
}