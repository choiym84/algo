import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[M];
        recur(0, 1);

        System.out.println(sb);

    }

    static void recur(int depth, int prev){

        if (depth == M) {
            for(int i = 0;i < M;i++){
                sb.append(nums[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = prev;i <= N;i++){
            nums[depth] = i;
            recur(depth+1,i);
        }
    }
}