class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int max = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[0]);
        for(int i=0; i<arr.length; i++){
            int num = Integer.parseInt(arr[i]);
            max = max < num ? num : max;
            min = min > num ? num : min;
        }
        answer = "" + min + " " + max;
        return answer;
    }
}