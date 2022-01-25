import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        
        List<String> list = new ArrayList<String>();
        
        for (int i=0;i<strings.length;i++) {
            list.add(strings[i].charAt(n) + strings[i]);
        }
        
        Collections.sort(list);
        
        for (int i=0;i<list.size();i++) answer[i] = list.get(i).substring(1, list.get(i).length());
        
        return answer;
    }
}

/*
import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        
        List<String> list = new ArrayList<String>();
        
        for (int i=0;i<strings.length;i++) {
            list.add(strings[i].substring(n, strings[i].length()) + strings[i].substring(0, n));
        }
        
        Collections.sort(list);
        
        for (int i=0;i<list.size();i++) answer[i] = list.get(i).substring(list.get(i).length()-n,list.get(i).length()) + list.get(i).substring(0, list.get(i).length()-n);
        
        return answer;
    }
}
*/