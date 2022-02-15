import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        
        HashMap<String,String> users = new HashMap<>();
        
        String[] arr = {};
        int cnt = 0;
        for(String r : record) {
            arr = r.split(" ");
            if (arr.length == 3) users.put(arr[1], arr[2]);
            if (arr[0].equals("Change")) cnt++;
        }
        
        answer = new String[record.length-cnt];
        
        int idx = 0;
        for (String r : record) {
            arr = r.split(" ");
            if (arr[0].equals("Enter")) {
                answer[idx++] = users.get(arr[1]) + "님이 들어왔습니다.";
            }
            else if (arr[0].equals("Leave")) {
                answer[idx++] = users.get(arr[1]) + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}