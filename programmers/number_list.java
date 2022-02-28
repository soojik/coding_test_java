import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        int len = 0;
        for (int i=0;i<phone_book.length-1;i++) {
            len = phone_book[i].length();
            if (phone_book[i+1].length()>=len) {
                if (phone_book[i].equals(phone_book[i+1].substring(0,len)))
                    return false;
            }
            else {
                len = phone_book[i+1].length();
                if (phone_book[i+1].equals(phone_book[i].substring(0,len)))
                    return false;
            }
        }
        
        return answer;
    }
}
