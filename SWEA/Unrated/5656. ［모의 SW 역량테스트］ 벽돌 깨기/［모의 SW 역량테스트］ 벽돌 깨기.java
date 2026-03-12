import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N, W, H;
    static int[][] O_map;
    static int[] ball;
    static int min;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            min = 1_000_000_000;
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            ball = new int[N];
            O_map = new int[H][W];


            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    O_map[i][j] = Integer.parseInt(st.nextToken());
                }
            }





            DFS(0);
            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }

    static void DFS(int depth) {

        if (depth == N) {
            // 구슬 쏘는 로직.
            int[][] copy = new int[H][];
            for (int i = 0; i < H; i++) {
                copy[i] = O_map[i].clone();
            }
            int cnt = simul(copy);
            min = Math.min(cnt, min);
            return;
        }

        for (int i = 0; i < W; i++) {
            ball[depth] = i;
            DFS(depth + 1);
        }


    }

    static int simul(int[][] map) {

        for (int i = 0; i < N; i++) {

            int y = ball[i];
            int x = findFirst(y, map);
            if (x == -1) continue;
            map = crush(y, x, map);
            map = afterwork(map);


        }

        return count_brick(map);
    }

    static int findFirst(int y, int[][] map) {// 해당 열에 가장 위의 벽돌의 높이 알려줌.
        for (int x = 0; x < H; x++) {
            if (map[x][y] != 0) return x;
        }
        return -1;
    }

    static int[][] crush(int y, int x, int[][] map) {

        int m = map[x][y];
        map[x][y] = 0;
        for (int k = 1; k < m; k++) {
            for (int d = 0; d < 4; d++) {
                int nx = x + k*dx[d];
                int ny = y + k*dy[d];
                if(nx >= H || nx < 0 || ny >= W || ny < 0) continue;
                if (map[nx][ny] == 1) map[nx][ny] = 0;
                else if (map[nx][ny] == 0) continue;
                else {
                    map = crush(ny, nx, map);
                }
            }
        }

        return map;
    }

    static int[][] afterwork(int map[][]) {
        int[][] tmp = new int[H][W];

        for (int i = 0; i < W; i++) {
            int cnt = 0;
            for (int j = H - 1; j >= 0; j--) {

                if (map[j][i] != 0) {
                    tmp[H - 1 - cnt][i] = map[j][i];
                    cnt++;
                }
            }
        }
        return tmp;
    }

    static int count_brick(int map[][]){
        int cnt = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(map[i][j] != 0) cnt++;
            }
        }

        return cnt;
    }
}