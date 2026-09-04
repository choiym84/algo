import java.util.*;

public class Main {

    static int N;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int max_score = 0;

    // DFS 깊이별 맵
    static int[][][] board;

    // DFS 깊이별 방문 체크
    static boolean[][][] visited;

    // BFS 큐 재사용
    static int[][] queue;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        board = new int[4][3 * N][N];
        visited = new boolean[4][N][N];
        queue = new int[4][N * N];

        for (int i = 0; i < 3 * N; i++) {
            for (int j = 0; j < N; j++) {
                board[0][i][j] = sc.nextInt();
            }
        }

        DFS(0, 0);

        System.out.println(max_score);
    }

    static void DFS(int step, int score) {

        // 3번 제거하면 종료
        if (step == 3) {
            max_score = Math.max(max_score, score);
            return;
        }

        int[][] map = board[step];

        // 방문 배열 초기화
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[step][i], false);
        }

        // 아래쪽 N x N 영역 탐색
        for (int y = 2 * N; y < 3 * N; y++) {
            for (int x = 0; x < N; x++) {

                // 빈칸 제외
                if (map[y][x] == 0) {
                    continue;
                }

                int vy = y - 2 * N;

                // 이미 확인한 그룹 제외
                if (visited[step][vy][x]) {
                    continue;
                }

                // 같은 자동차 그룹 탐색
                int count = BFS(step, x, y);

                // 점수 계산
                int current_score = cal_score(step, count);

                // 다음 깊이 맵에 복사
                copy_map(board[step], board[step + 1]);

                // 자동차 제거
                remove_car(step, count, board[step + 1]);

                // 중력 적용
                move_car(board[step + 1]);

                // 다음 단계
                DFS(step + 1, score + current_score);
            }
        }
    }

    static int BFS(int step, int start_x, int start_y) {

        int[][] map = board[step];

        int car_type = map[start_y][start_x];

        int front = 0;
        int rear = 0;

        int start_vy = start_y - 2 * N;

        queue[step][rear++] = start_vy * N + start_x;

        visited[step][start_vy][start_x] = true;

        while (front < rear) {

            int code = queue[step][front++];

            int vy = code / N;
            int x = code % N;

            int y = vy + 2 * N;

            for (int d = 0; d < 4; d++) {

                int nx = x + dx[d];
                int ny = y + dy[d];

                // 선택 영역 밖이면 제외
                if (nx < 0 || nx >= N ||
                    ny < 2 * N || ny >= 3 * N) {
                    continue;
                }

                int nvy = ny - 2 * N;

                if (visited[step][nvy][nx]) {
                    continue;
                }

                if (map[ny][nx] == car_type) {

                    visited[step][nvy][nx] = true;

                    queue[step][rear++] = nvy * N + nx;
                }
            }
        }

        return rear;
    }

    static int cal_score(int step, int count) {

        int min_x = N;
        int min_y = N;

        int max_x = -1;
        int max_y = -1;

        for (int i = 0; i < count; i++) {

            int code = queue[step][i];

            int y = code / N;
            int x = code % N;

            min_x = Math.min(min_x, x);
            max_x = Math.max(max_x, x);

            min_y = Math.min(min_y, y);
            max_y = Math.max(max_y, y);
        }

        if (count == 0) {
            return 0;
        }

        int width = max_x - min_x + 1;
        int height = max_y - min_y + 1;

        return width * height + count;
    }

    static void remove_car(
            int step,
            int count,
            int[][] map
    ) {

        for (int i = 0; i < count; i++) {

            int code = queue[step][i];

            int vy = code / N;
            int x = code % N;

            int y = vy + 2 * N;

            // 자동차 제거
            map[y][x] = 0;
        }
    }

    static void move_car(int[][] map) {

        // 열마다 중력 적용
        for (int x = 0; x < N; x++) {

            int bottom = 3 * N - 1;

            for (int y = 3 * N - 1; y >= 0; y--) {

                if (map[y][x] != 0) {

                    map[bottom][x] = map[y][x];

                    if (bottom != y) {
                        map[y][x] = 0;
                    }

                    bottom--;
                }
            }

            // 위쪽 빈칸 처리
            while (bottom >= 0) {
                map[bottom][x] = 0;
                bottom--;
            }
        }
    }

    static void copy_map(
            int[][] source,
            int[][] target
    ) {

        for (int y = 0; y < 3 * N; y++) {
            System.arraycopy(
                    source[y],
                    0,
                    target[y],
                    0,
                    N
            );
        }
    }
}