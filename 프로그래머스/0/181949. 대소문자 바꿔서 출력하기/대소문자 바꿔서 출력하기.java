import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		String output = "";

		if (str.length() >= 1 && str.length() <= 20) {
			for (int i = 0; i < str.length(); i++) {
				char tmp = str.charAt(i);
				if (tmp >= 65 && tmp <= 90) {
					tmp += (char) 32;
					output += tmp;
				} else if (tmp >= 97 && tmp <= 122) {
					tmp -= (char) 32;
					output += tmp;
				}

			}
		}
        System.out.print(output);
    }
}