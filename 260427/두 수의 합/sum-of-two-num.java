import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Map<Integer, Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int key = Integer.parseInt(st.nextToken());
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		int count = 0;
		for (Integer k : map.keySet()) {

			if (map.keySet().contains(K - k)) {

				int v1 = map.get(k);
				int v2 = map.get(K - k);
				if (K - k == k) {
					count += v1 * (v2 - 1);
				} else {

					count += map.get(k) * map.get(K - k);
				}
			}

		}

		System.out.println(count / 2);

	}
}
