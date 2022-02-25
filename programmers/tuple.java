import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        List<String> arr = new ArrayList<>();
        
        // 앞 괄호 삭제
        StringBuilder sb = new StringBuilder(s.substring(1));
        
        int idx = 0;
        while (idx < sb.length()) {
            if ((sb.charAt(idx) == '}') && ((sb.charAt(idx+1) == ',') || (sb.charAt(idx+1) == '}'))) {
                arr.add(sb.substring(1,idx));
                sb.delete(0, idx+2);
                idx = 0;
                continue;
            }
            idx++;
        }
        arr.add(sb.toString());
        
        Collections.sort(arr, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        
        for (int i=0;i<arr.size();i++) {
            String[] tmp = arr.get(i).split(",");
            for (int n=0;n<tmp.length;n++) {
                int a = (tmp[n].equals("")) ? 0 : Integer.parseInt(tmp[n]);
                if (!answer.contains(a)) answer.add(a);
            }
        }
        if (answer.contains(0)) answer.remove(0);
        
        return answer;
    }
}
