import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A,B,C;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(div_conq(B));

    }

    static long div_conq(int n) {

        if(n == 1) return A%C;

        if (n % 2 == 0) {
            long tmp = div_conq(n/2);
            return (tmp*tmp)%C;
        }else{
            long tmp = div_conq(n/2);
            return ((tmp*tmp)%C)*(A%C)%C;
        }

    }
}