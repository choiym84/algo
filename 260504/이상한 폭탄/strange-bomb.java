import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] pre = new int[1_000_001];
        for(int i = 0;i < N;i++){
            arr[i] = Integer.parseInt(br.readLine());
            pre[arr[i]] = i;
        }

        int max = -1;
        for(int i = 0;i < N;i++){
            
            if(pre[arr[i]]-i == 0 || pre[arr[i]]-i > K){

            }else{
                max = Math.max(max,arr[i]);
            }


        }

        System.out.println(max);




    }
}