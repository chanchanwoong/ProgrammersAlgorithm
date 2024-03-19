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
                    if(arr[i][j] != arr[i][z]){
                        continue;
                    }
                    // 길이 획득
                    length = z - j;

                    // 세로 길이가 벗어나지 않는지 확인
                    // 가로는 for문에 의해서 자연스레 범위안에 있는 것
                    if(!(i+length < n)){
                        continue;
                    }

                    // 범위 안에 것 중 꼭짓점 확인
                    if(arr[i][j] == arr[i+length][j] && arr[i][j] == arr[i+length][j+length]){
                        area = Math.max(area, (length + 1) * (length + 1));
                    }
                }
            }
        }
        System.out.println(area);
    }
}
