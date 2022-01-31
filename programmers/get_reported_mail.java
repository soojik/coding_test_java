import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 신고당한 유저 + 신고한 유저
        Map<String,HashSet<String>> reportList = new HashMap<>();
        // 신고한 유저 + 메일 횟수
        Map<String,Integer> getMailCnt = new HashMap<>();
        
        // 유저 설정
        for (String id : id_list) {
            getMailCnt.put(id, 0);
            reportList.put(id, new HashSet<>());
        }
        
        // 신고당한 유저, 신고한 유저
        for (int i=0;i<report.length;i++) {
            String[] user = report[i].split(" ");
            reportList.get(user[1]).add(user[0]);
        }
        
        // 신고한 유저의 목록을 가져와 메일받을 개수 세줌
        for (String key : reportList.keySet()) {
            HashSet<String> reporters = reportList.get(key);
            if (reporters.size() >= k) {
                for (String reporter : reporters) {
                    int cnt = getMailCnt.get(reporter);
                    getMailCnt.put(reporter, cnt+1);
                }
            }
        }
        
        for (int i=0;i<answer.length;i++)
            answer[i] = getMailCnt.get(id_list[i]);
            
        
        return answer;
    }
}

/* 시간 초과 3, 21
import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 신고 중복 제거
        HashSet<String> set = new HashSet<>(Arrays.asList(report));
        List<String> report_set =new ArrayList<String>(set);
        
        int[] ids = new int[id_list.length]; // id_list와 같은 순서로 신고당한 횟수 배열
        String reported_id = "";
        
        // 배열 돌면서 신고당한(report_set.get(i).split(" ")[1]) 유저 값에 +1
        for (int i=0;i<report_set.size();i++) {
            reported_id = report_set.get(i).split(" ")[1];
            ids[Arrays.asList(id_list).indexOf(reported_id)] += 1;
        }
        
        // k번 이상 신고당했으면
        for (int i=0;i<ids.length;i++) {
            if (ids[i] >= k) {

                //report 리스트 돌면서 신고당한 유저 이름과 같은 신고항목을 참고해 신고한 유저를 가져와, id_list 배열 상 같은 유저 값에 +1
                for (int j=0;j<report_set.size();j++) {
                    if (report_set.get(j).split(" ")[1].equals(id_list[i]))
                        answer[Arrays.asList(id_list).indexOf(report_set.get(j).split(" ")[0])] += 1;
                }
            }
        }
        
        return answer;
    }
}
*/