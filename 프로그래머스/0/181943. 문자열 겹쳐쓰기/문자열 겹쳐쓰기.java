class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        char[] myArr = my_string.toCharArray();
		for (int i = 0; i < overwrite_string.length(); i++, s++) {
			myArr[s] = overwrite_string.charAt(i);
		}
        for (int i=0;i<myArr.length;i++) {
			answer += myArr[i];
		}
        return answer;
    }
}