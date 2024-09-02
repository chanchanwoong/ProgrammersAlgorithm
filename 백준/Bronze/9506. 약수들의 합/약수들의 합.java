import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static List<Integer> divisorList = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            int input = Integer.parseInt(br.readLine());

            if(input == -1) break;

            // 약수 저장
            getDivisor(input);

            // 완전수 검사
            if(checkPerfectNumber(input)) {
                bw.write(String.valueOf(input) + " = ");
                for(Integer i : divisorList) {
                    if(i == 1) bw.write(String.valueOf(i));
                    else if(i == input) continue;
                    else bw.write(" + " + String.valueOf(i));
                }
            } else bw.write(String.valueOf(input) + " is NOT perfect.");
            
            bw.flush();
            bw.newLine();
            
            divisorList.clear();
        }
        br.close();
        bw.close();
    }

    // 약수 구하는 메서드
    private static void getDivisor(int input) {
        for(int i = 1; i <= Math.sqrt(input); i++) {
            // 나누어 떨어질 때, divisorList 저장
            if(input % i == 0) {
                divisorList.add(i);
                if(i != input / i) {
                    divisorList.add(input / i);   
                }
            }
        }
        // 오름차순 정렬
        Collections.sort(divisorList);
    }

    // 완전수 검사 메서드
    private static boolean checkPerfectNumber(int input) {
        int sumOfOthers = 0;

        for(Integer temp : divisorList) {
            if(temp != input) sumOfOthers += temp;
        }

        return input == sumOfOthers;
    }
}