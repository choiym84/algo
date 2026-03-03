import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// ---------솔루션 코드를 작성하세요.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int led[] = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			led[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());

		int student[][] = new int[M][2];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			if (s == 1) {

				int idx = 2;
				for (int j = num; j <= N; j++) {
                    if(j % num == 0){
					led[j] = (led[j] == 1) ? 0 : 1;
                    }
				}

			} else {
				led[num] = (led[num] == 1) ? 0 : 1;
				int end = num + 1;
				int start = num - 1;

				while (end <= N && start > 0) {

					if (led[end] != led[start])
						break;

					led[end] = (led[end] == 1) ? 0 : 1;
					led[start] = (led[start] == 1) ? 0 : 1;

					end++;
					start--;

				}

			}

		}
		
		for(int i = 1;i <= N;i++) {
			sb.append(led[i]).append(" ");
			if(i % 20 == 0)sb.append("\n");
			
		}
		System.out.println(sb);

	}

}
