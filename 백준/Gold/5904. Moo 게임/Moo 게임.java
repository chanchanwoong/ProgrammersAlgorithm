import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // S(k)의 길이. 계속해서 길어짐
        int curS = 3;
        // S(k-1)의 길이
        // S(k) = S(k-1) + ( 1(m의 길이) + (2 + k) (o의 길이) ) + S(k-1)
        int preS = 3;
        // S(k)에서 인덱스 k 의미
        int k = 0;

        // N의 범위 구하기
        // N번 째 문자를 찾기 위한 최소한의 수열만 만들기 위함
        while (curS < N) {
            k++;
            // S(k) 길이 구하기
            curS = preS + (1 + 2 + k) + preS;
            // S(k) 갱신
            preS = curS;
        }
        // 최종적으로 구한 curS를 기반으로 preS를 구함
        preS = (curS - (1 + 2 + k)) / 2;

        char c;

        // 기저 조건
        // 입력된 숫자가 3 이하일 경우
        if (k == 0) {
            if (N == 1) {
                c = 'm';
            } else {
                c = 'o';
            }
        }
        // 입력 숫자가 3 이상인 경우
        // 분할 정복이 들어간다.
        else {
            if (preS + 1 <= N && N < preS + (1 + 2 + k)) {
                if (preS + 1 == N) {
                    c = 'm';
                } else c = 'o';
            } else {
                c = moo(preS + 1 + (1 + 2 + k), k - 1, curS);
            }
        }
        System.out.println(c);
    }

    public static char moo(int si, int k, int se) {
        // 중간 범위의 크기 구하기
        int index = ((se - si + 1 - (k + 3)) / 2);

        // 기저 조건
        if (k == 0) {
            if (N == si) {
                return 'm';
            } else {
                return 'o';
            }
        } else {

            // 왼쪽 범위
            if (si <= N && N < si + index) {
                if (si == N) {
                    return 'm';
                }
                return moo(si, k - 1, si + index - 1);
            }
            // 오른쪽 범위
            else if (si + index + (k + 3) <= N && N <= se) {
                if (si + index + (k + 3) == N) {
                    return 'm';
                } else {
                    return moo(si + index + (k + 3), k - 1, se);
                }
            } else {
                if (si + index == N) {
                    return 'm';
                } else {
                    return 'o';
                }
            }
        }
    }
}