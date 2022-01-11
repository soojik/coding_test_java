class Solution {
    String[] dict = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public int solution(String s) {
        int answer = 0;
        String tmp = "";
        
        int i;
        int j;
        
        for (i=0;i<s.length();i++) {
            if (Character.isLetter(s.charAt(i))) {
                for (j=0;j<dict.length;j++) {
                    if (dict[j].length() <= s.length() - i) {
                        if (dict[j].equals(s.substring(i, i+dict[j].length()))) {
                            tmp += Integer.toString(j);
                        }
                    }
                }
            }
            else {
                tmp += s.charAt(i);
            }
        }
        
        answer = Integer.parseInt(tmp);
        return answer;
    }
}