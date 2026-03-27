

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static class Node{
		
		Node L,R,p;
		int value;
		
	}
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int input[] = new int[10001];
		int size = 0;
		while(true) {
			
			String s = br.readLine();
			
			if(s == null || s.equals("")) break;
			
			input[size++] = Integer.parseInt(s);
				
		}
		
		Node root = new Node();
		root.value = input[0];
		for(int i = 1;i < size;i++) {
			
			Node k = root;
			while(true) {
				
				if(k.value > input[i]) {
					
					if(k.L == null) {
						Node n = new Node();
						n.value = input[i];
						n.p = k;
						k.L = n;
						break;
					}else k = k.L;
					
					
				}else {
					
					if(k.R == null) {
						Node n = new Node();
						n.value = input[i];
						n.p = k;
						k.R = n;
						break;
					}else k = k.R;
					
					
				}
			}
		}
		
		recur(root);
		

	}
	
	
	static void recur(Node n) {
		
		if(n.L == null && n.R == null) {
			System.out.println(n.value);
			return;
		}
		
		if(n.L != null)recur(n.L);
		
		if(n.R != null) recur(n.R);
		System.out.println(n.value);
		
		
		
		
	}
	

}
