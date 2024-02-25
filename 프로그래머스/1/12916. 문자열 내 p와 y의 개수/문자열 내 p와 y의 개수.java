class Solution {
    boolean solution(String s) {
        int cntP = 0;
        int cntY = 0;

        for(int i=0; i<s.length(); i++){
            cntP += (s.charAt(i) == 'P' || s.charAt(i) == 'p') ? 1 : 0;
            cntY += (s.charAt(i) == 'Y' || s.charAt(i) == 'y') ? 1 : 0;
        }

        return cntP == cntY;
    }
}