

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int INF = 1_000_000_000;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static int[][] map;
	static int visited[][][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0;i < N;i++) {
			char[] arr = br.readLine().toCharArray();
			for(int j = 0;j < M;j++) {
				map[i][j] = arr[j]-'0';
			}
		}
		

		visited = new int[N][M][2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Arrays.fill(visited[i][j], INF);
			}
		}

		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 0, 0 });
		visited[0][0][0] = 1;

		while (!q.isEmpty()) {

			int v[] = q.poll();
			int x = v[0];
			int y = v[1];
			int w = v[2];

			for (int k = 0; k < 4; k++) {

				int nx = x + dx[k];
				int ny = y + dy[k];

				if (nx >= N || nx < 0 || ny >= M || ny < 0)
					continue;

				if (map[nx][ny] == 1 && w == 0) {
					visited[nx][ny][w + 1] = visited[x][y][w] + 1;
					q.add(new int[] { nx, ny, w + 1 });
				}

				if (map[nx][ny] == 0 && visited[nx][ny][w] > visited[x][y][w]+1) {
					visited[nx][ny][w] = visited[x][y][w] + 1;
					q.add(new int[] { nx, ny, w });
				}

			}
			
			

		}
		if(visited[N-1][M-1][0]==INF &&visited[N-1][M-1][1]==INF) System.out.println(-1);
		else System.out.println(Math.min(visited[N-1][M-1][0], visited[N-1][M-1][1]));

	}

}
