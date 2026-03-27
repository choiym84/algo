
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		String bomb = br.readLine();

		int str_size = input.length();
		int bomb_size = bomb.length();

		Stack<Character> st = new Stack<>();

		for (int i = 0; i < str_size; i++) {

			st.add(input.charAt(i));

			if (st.size() >= bomb_size) {
				boolean is_bomb = true;
				for (int j = 0; j < bomb_size; j++) {
					if (st.get(st.size() - bomb_size + j) != bomb.charAt(j)) {
						is_bomb = false;
						break;

					}

				}
				
				if(is_bomb) {
					
					for(int j = 0;j < bomb_size;j++)st.pop();
					
				}
				
			}
		}
		
		if(st.size() == 0) System.out.println("FRULA");
		else {
			
			for(char c:st) {
				sb.append(c);
			}
			System.out.println(sb);
		}
		
		

	}
}
