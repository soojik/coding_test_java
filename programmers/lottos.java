import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0, 0};
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        int i;
        int j;
        int cnt = 0;
        // 0 삭제
        for (i=0;i<lottos.length;i++) {
            if (lottos[0] == 0) {
                cnt++;
                for (j=0;j<lottos.length-1;j++) {
                    lottos[j] = lottos[j+1];
                }
            }
        }
        
        // 0 삭제한만큼 배열 뒤에 자르기
        int[] new_lottos = Arrays.copyOf(lottos, lottos.length-cnt);

        // 새로운 lottos 배열과 정렬된 정답 배열 비교
        int win_cnt = 0;
        for (i=0;i<new_lottos.length;i++) {
            for (j=0;j<win_nums.length;j++) {
                if (new_lottos[i] == win_nums[j]) {
                    win_cnt++;
                }
            }
        }
        
        // 정답 숫자 + 알 수 없는 숫자(맞는 경우/틀린 경우) 합해서 순위
        int max_rank;
        int min_rank;

        if (win_cnt+cnt <= 1) {
            max_rank = 6;
            min_rank = 6;
        }
        else if (win_cnt <= 1) {
            max_rank = 7-(win_cnt+cnt);
            min_rank = 6;
        }
        else {
            max_rank = 7-(win_cnt+cnt);
            min_rank = 7-win_cnt;
        }

        answer[0] = max_rank;
        answer[1] = min_rank;

        return answer;
    }
}