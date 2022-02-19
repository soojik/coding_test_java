import java.util.*;

class Solution {
    public long solution(String str1, String str2) {
        long answer = 0;
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        ArrayList<String> inter = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
        
        for (int i=0;i<str1.length()-1;i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i+1);
            if ((Character.isLetter(c1)) && (Character.isLetter(c2))) {
                arr1.add(c1+""+c2);
            }
        }
        
        for (int i=0;i<str2.length()-1;i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i+1);
            if ((Character.isLetter(c1)) && (Character.isLetter(c2))) {
                arr2.add(c1+""+c2);
            }
        }
        
        for (String c : arr1) {
            if (arr2.remove(c)) inter.add(c);
            union.add(c);
        }
        
        for (String c : arr2) union.add(c);
        
        double jaccard = (union.size()==0) ? 1 : (double)inter.size()/(double)union.size();
        answer = (long) (jaccard * 65536);
        
        return answer;
    }
}
