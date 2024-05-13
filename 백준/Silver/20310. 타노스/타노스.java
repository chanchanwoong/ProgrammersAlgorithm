import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder(br.readLine());
        br.close();

        // "0"의 개수 x, "1"의 개수 y
        int x = 0, y = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') x++;
            else y++;
        }


        // 절반만큼 제거해야 함
        // 사전 순이므로 "0"은 뒤에서 삭제하고 "1"은 앞에서 삭제
        x /= 2; y /= 2;

        // 1은 앞에서 없애기
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i)=='1') {
                str.setCharAt(i,'2');
                y--;
            }
            if(y == 0) break;
        }

        // 0은 뒤에서부터 없애기
        for(int i = str.length()-1; i > -1; i--){
            if(str.charAt(i)=='0') {
                str.setCharAt(i,'2');
                x--;
            }
            if(x == 0) break;
        }

        for (int i=0;i<str.length();i++) {
            if (str.charAt(i)!='2') System.out.print(str.charAt(i));
        }
    }
}
