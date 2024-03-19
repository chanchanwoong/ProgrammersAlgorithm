import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] arr;
    static int area = 1;
    static int length;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i=0; i<n; i++){
            String input = br.readLine();
            for(int j=0; j<m; j++){
                // 아스키코드 만큼 빼줌(char -> int)
                arr[i][j] = input.charAt(j) - 48;
            }
        }
        solution();
    }
    public static void solution(){
        for (int i=0; i<n; i++){
            for (int j=0; j<m-1; j++){
                // arr[i][j] 대상으로 나머지 값들과 일치하는게 있는지 찾는다.
                for (int z=j+1; z<m; z++){
               
                    // 범위 안에 것 중 꼭짓점 확인
                    if((arr[i][j] == arr[i][z]) && (i+z-j < n) && arr[i][j] == arr[i+z-j][j] && arr[i][j] == arr[i+z-j][z]){
                        area = Math.max(area, (z-j + 1) * (z-j + 1));
                    }
                }
            }
        }
        System.out.println(area);
    }
}
