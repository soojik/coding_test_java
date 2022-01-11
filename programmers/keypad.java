class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int now_left = 10;
        int now_right = 12;

        for (int number : numbers) {
            number = (number==0) ? 11 : number;
            
            // left
            if (number%3==1) {
                answer += "L";
                now_left = number;
            }
            // right
            else if (number%3==0) {
                answer += "R";
                now_right = number;
            }
            // middle
            else {
                int cnt_left = getLength(now_left, number);
                int cnt_right = getLength(now_right, number);
                
                if (cnt_left < cnt_right) {
                    answer += "L";
                    now_left = number;
                }
                else if (cnt_left > cnt_right) {
                    answer += "R";
                    now_right = number;
                }
                else {
                    if (hand.equals("left")) {
                        answer += "L";
                        now_left = number;
                    }
                    else {
                        answer += "R";
                        now_right = number;
                    }
                }
            }
        }
        return answer;
    }
    
    public static int getLength(int now, int number) {
            now = (now==0) ? 11 : now;
            
            int now_row = (now-1) / 3;
            int num_row = number / 3;
            
            int now_col = (now-1) % 3;
            int num_col = 1;
            
            return Math.abs(num_row-now_row) + Math.abs(num_col-now_col);
        }
}

// 참고 - https://zzang9ha.tistory.com/292

/*
처음 제출한 코드

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int i;
        String used_hand = "";
        int now_left = 10;
        int now_right = 12;
        
        for (i=0;i<numbers.length;i++) {
            //left
            if (numbers[i]%3==1) {
                used_hand = "L";
                now_left = numbers[i];
            }
            // middle
            else if ((numbers[i]%3==2) || (numbers[i]==0)) {
                int num = numbers[i];
                if (numbers[i]==0) {
                    num = 11;
                }
                int num_line = num/3;
                int cnt_left = 0;
                if ((num_line - (now_left-1)/3) == 0) {
                    cnt_left = 1;
                }
                else {
                    if (now_left%3==0) {
                        cnt_left += Math.abs(num_line - (now_left-1)/3) + Math.abs(num%3 - 3);
                    }
                    else {
                        cnt_left += Math.abs(num_line - (now_left-1)/3) + Math.abs(num%3 - now_left%3);
                    }
                }
                int cnt_right = 0;
                if ((num_line - (now_right-1)/3) == 0) {
                    cnt_right = 1;
                }
                else {
                    if (now_right%3==0) {
                        cnt_right += Math.abs(num_line - (now_right-1)/3) + Math.abs(num%3 - 3);
                    }
                    else {
                        cnt_right += Math.abs(num_line - (now_right-1)/3) + Math.abs(num%3 - now_right%3);
                    }
                }
                
                if (cnt_left < cnt_right) {
                    used_hand = "L";
                    now_left = num;
                }
                else if (cnt_left > cnt_right) {
                    used_hand = "R";
                    now_right = num;
                }
                else {
                    if (hand.equals("right")) {
                        used_hand = "R";
                        now_right = num;
                    }
                    else {
                        used_hand = "L";
                        now_left = num;
                    }
                }
            }
            //right
            else {
                used_hand = "R";
                now_right = numbers[i];
            }
            answer += used_hand;
        }
        
        return answer;
    }
}
*/