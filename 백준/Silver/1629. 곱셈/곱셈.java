import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long C;

    public static long pow(long A, long exponent) {

        // 지수가 1일 경우 A^1 이므로 A를 그대로 리턴
        if(exponent == 1) {
            return A % C;
        }

        // 지수의 절반에 해당하는 A^(exponent / 2) 을 구한다.
        long temp = pow(A, exponent / 2);
        
        if(exponent % 2 == 1) {
            return (temp * temp % C) * A % C;
        }
        return temp * temp % C;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.print(pow(A, B));
    }
}
