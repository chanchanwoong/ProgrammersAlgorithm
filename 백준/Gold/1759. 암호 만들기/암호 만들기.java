import java.io.*;
import java.util.*;

public class Main {
    // 전체 모음 알파벳
    static List<String> consonantAlphabet = new ArrayList<>(Arrays.asList("a", "e", "i", "o", "u"));
    static int l, c;
    static String[] pwd, alphabet;

    public static void solution(int len, int start) {
        if (len >= l) {
            if (check(pwd)) {
                for (String p : pwd) {
                    System.out.print(p);
                }
                System.out.println();
            }
            return;
        }
        for (int i = start; i < c; i++) {
            pwd[len] = alphabet[i];
            solution(len + 1, i + 1);
        }
    }

    // 사용 가능한 암호인지 확인
    public static boolean check(String[] pwd) {
        // 자음과 모음 개수
        int c = 0, v = 0;
        for (int i = 0; i < pwd.length; i++) {
            if (consonantAlphabet.contains(pwd[i])) v++;
            else c++;
        }
        if (c >= 2 && v >= 1) return true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        pwd = new String[l];
        alphabet = new String[c];
        alphabet = br.readLine().split(" ");
        // 작은 것 부터 암호 만들기 위해 오름차순 정렬
        Arrays.sort(alphabet);

        solution(0, 0);
    }
}
