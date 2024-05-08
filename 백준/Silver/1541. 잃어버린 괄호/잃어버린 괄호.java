import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {  
    public static void main(String[] args) throws IOException {  
  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
  
        String[] subtraction = br.readLine().split("-");  
  
        int sum = 0;  
        String first = subtraction[0];  
        String[] firstAdd = first.split("\\+");  
        // 덧셈으로 나뉜 토큰들을 모두 더한다.  
        for(int j = 0; j < firstAdd.length; j++) {  
            sum += Integer.parseInt(firstAdd[j]);  
        }  
  
        for(int i = 1; i < subtraction.length; i++) {  
            int temp = 0;  
  
            // 뺄셈으로 나뉜 토큰을 덧셈으로 분리하여 해당 토큰들을 더한다.  
            String[] addition = subtraction[i].split("\\+");  
  
            // 덧셈으로 나뉜 토큰들을 모두 더한다.  
            for(int j = 0; j < addition.length; j++) {  
                temp += Integer.parseInt(addition[j]);  
            }  
            sum -= temp;  
        }  
        System.out.println(sum);  
    }  
}