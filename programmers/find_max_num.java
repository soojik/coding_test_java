import java.util.ArrayList;
import java.util.LinkedList;


class Solution {
    static char[] prior = {'+', '-', '*'};
    static boolean[] check = new boolean[3];
    static ArrayList<Long> num = new ArrayList<>();
    static ArrayList<Character> op = new ArrayList<>();
    static long answer;
    
    public long solution(String expression) {
        answer = 0;
        
        int idx = 0;
        
        String tmp = "";
        
        for (int i=0;i<expression.length();i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c))
                tmp += c;
            else {
                num.add((tmp=="") ? 0 : (long) Integer.parseInt(tmp));
                tmp = "";
                op.add(c);
            }
        }
        num.add((long) Integer.parseInt(tmp));
        dfs(0, new char[3]);
        
        return answer;
    }
    
    public static Long calc(Long num1, Long num2, char op){
        long num = 0;
        switch (op){
            case '+' : {
                return num1 + num2;
            }
            case '-' : {
                return num1 - num2;
            }
            case '*' : {
                return num1 * num2;
            }
        }
        return num;
    }
    
    public static void dfs(int count, char[] p){
        if(count == 3){
            ArrayList<Long> cNums = new ArrayList<>(num);
            ArrayList<Character> cOps = new ArrayList<Character>(op);

            for(int i=0;i<p.length;i++){
                for(int j=0; j< cOps.size(); j++){
                    if(p[i] == cOps.get(j)){
                        Long res = calc(cNums.remove(j), cNums.remove(j), p[i]);
                        cNums.add(j, res);
                        cOps.remove(j);
                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(cNums.get(0)));
            return;

        }

        for(int i=0; i< 3; i++){
            if(!check[i]){
                check[i] = true;
                p[count] = prior[i];
                dfs(count+1,p);
                check[i] = false;
            }
        }
    }
}
