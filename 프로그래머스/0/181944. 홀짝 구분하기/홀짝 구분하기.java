import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String output;

		System.out.printf("%d is %s", n, output = (n % 2 > 0) ? "odd" : "even");
    }
}