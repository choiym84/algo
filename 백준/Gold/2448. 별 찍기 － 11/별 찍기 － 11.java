

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		map = new char[N][N*2-1];
		for(int i = 0;i < N;i++) {
			Arrays.fill(map[i],' ');
		}
		
		recur(0,N-1,N);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < N;i++) {
			for(int j = 0;j < N*2-1;j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}	
	
	
	public static void recur(int r,int c, int n) {
		
		if(n == 3) {
			
			map[r][c] = '*';
			map[r+1][c-1] = map[r+1][c+1] = '*';
			map[r + 2][c - 2] = map[r + 2][c - 1] = map[r + 2][c] = map[r + 2][c + 1] = map[r + 2][c + 2] = '*';
			
		}else {
			
			int k = n/2;
			
			recur(r,c,k);
			recur(r+k,c-k,k);
			recur(r+k,c+k,k);
			
		}
		
	}
	

}
