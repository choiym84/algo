
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<List<Integer>> partys;
	static int max, N, size;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int trueman[] = new int[N + 1]; // 0이면 아직 이야기 못들음. 1이면 진실을 알고 있음. 2면 거짓을 들음.
		partys = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			trueman[Integer.parseInt(st.nextToken())] = 1;
		}

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine());

			int num = Integer.parseInt(st.nextToken());
			if (num == 0)
				continue;
			size++;
			List<Integer> party = new ArrayList<>();

			for (int j = 0; j < num; j++) {
				party.add(Integer.parseInt(st.nextToken()));
			}

			partys.add(party);
		}

		recur(0, trueman, 0);

		System.out.println(max);
	}

	static void recur(int depth, int trueman[], int cnt) {

		if (depth == size) {
			max = Math.max(max, cnt);
			return;
		}

//		System.out.println( "깊이" + depth + ", " + cnt);
		
		
		int mode = 0; // 0이면 아직 안정해짐. 1이면 진실, 2이면 과장해도 됨.
		boolean first = true;// 다 처음 듣는 애들로만 있나?
		for (int s : partys.get(depth)) {

			if (!first) {//이미 들은 사람이 잇고 내용이 다르다면 안된다. 여기서 끝내야 함.
				if (trueman[s] == 2 && mode == 1 || trueman[s] == 1 && mode == 2)
					return;
			}
			
			if (first && trueman[s] == 1) {// 진실을 알고 있는 친구가 있다면 무조건 진실을 말해야 함.
				mode = 1;
				first = false;
			}

			if (first && trueman[s] == 2) {
				mode = 2;
				first = false;// 누군가 거짓말을 들음
			}


		}

		if (first) {// 다 처음 듣는 애들이면 진실 말하든 거짓 말하든 상과없음.

			for (int s : partys.get(depth)) {
				trueman[s] = 1;
			}
			recur(depth + 1, trueman.clone(), cnt);

			for (int s : partys.get(depth)) {
				trueman[s] = 2;
			}
			recur(depth + 1, trueman.clone(), cnt + 1);

		}

		else {// 누군가 이야기를 들었음.
			if (mode == 2) {// 진실을 아무도 모르면 거짓말 해도 됨.

				for (int s : partys.get(depth)) {
					trueman[s] = 2;
				}
				recur(depth + 1, trueman.clone(), cnt + 1);
			}
			if (mode == 1) {// 진실을 아는 사람과 아직 못 들은 사람만 있을 때.
				for (int s : partys.get(depth)) {
					trueman[s] = 1;
				}
				recur(depth + 1, trueman.clone(), cnt);
			}
		}

	}

}
