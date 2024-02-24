import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
		String a, b;
		
		// 입력받기
		Scanner sc = new Scanner(System.in);
//		a = parseInt(sc.nextLine().split(" ")[0]);
//		b = sc.nextLine().split(" ")[1];
		a = sc.nextLine();
		b = a;
		a = a.substring(0, a.indexOf(" "));
		b = b.substring(b.indexOf(" ") + 1);
		System.out.println("a = " + a);
		System.out.println("b = " + b);
    }
}