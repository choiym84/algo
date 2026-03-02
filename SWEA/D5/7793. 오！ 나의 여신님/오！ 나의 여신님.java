import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char map[][];
    static int visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int sx = 0;
            int sy = 0;
            int goal_x = 0;
            int goal_y = 0;

            map = new char[N][M];
            visited = new int[N][M];
            for (int i = 0; i < N; i++) {

                Arrays.fill(visited[i], 100_000_000);
            }
            Queue<int[]> asQ = new ArrayDeque<>();

            for (int i = 0; i < N; i++) {

                String input = br.readLine();

                for (int j = 0; j < M; j++) {
                    map[i][j] = input.toCharArray()[j];

                    if (map[i][j] == '*') {
                        asQ.add(new int[]{i, j});
                    }

                    if (map[i][j] == 'D') {
                        goal_x = i;
                        goal_y = j;
                    }

                    if (map[i][j] == 'S') {
                        sx = i;
                        sy = j;
                    }
                }
            }

            Queue<int[]> q = new ArrayDeque<>();
            q.add(new int[]{sx, sy});
            visited[sx][sy] = 0;
            int cnt = 0;

            outer:
            while (!q.isEmpty()) {
                cnt++;
                Queue<int[]> q2 = new ArrayDeque<>();

                while (!q.isEmpty()) {


                    int v[] = q.poll();
                    int ex = v[0];
                    int ey = v[1];
                    if (map[ex][ey] == '*') continue;
                    for (int k = 0; k < 4; k++) {
                        int nx = ex + dx[k];
                        int ny = ey + dy[k];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] != 100_000_000) continue;


                        if (map[nx][ny] == '.') {
                            q2.add(new int[]{nx, ny});
                            visited[nx][ny] = visited[ex][ey] + 1;
                        }

                        if(map[nx][ny] == 'D'){
                            visited[nx][ny] = visited[ex][ey] + 1;
                            break outer;
                        }
                    }
                }
                q = q2;

                Queue<int[]> tmp = new ArrayDeque<>();

                while (!asQ.isEmpty()) {

                    int a[] = asQ.poll();
                    int a_x = a[0];
                    int a_y = a[1];

                    for (int k = 0; k < 4; k++) {
                        int a_nx = a_x + dx[k];
                        int a_ny = a_y + dy[k];

                        if (a_nx < 0 || a_nx >= N || a_ny < 0 || a_ny >= M || map[a_nx][a_ny] == '*' || map[a_nx][a_ny] == 'D' || map[a_nx][a_ny] == 'X')
                            continue;

                        tmp.add(new int[]{a_nx, a_ny});
                        map[a_nx][a_ny] = '*';
                    }

                }

                asQ = tmp;

            }
            sb.append("#").append(t).append(" ");
            if (visited[goal_x][goal_y] == 100_000_000) {
                sb.append("GAME OVER");
            } else sb.append(visited[goal_x][goal_y]);
            sb.append("\n");


        }
        System.out.println(sb);

    }
}