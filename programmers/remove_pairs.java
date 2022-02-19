import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        
        Stack<Character> st = new Stack<>();
        
        st.push(s.charAt(0));
        char last_c = st.peek();
        
        for (int i=1;i<s.length();i++) {
            if (st.isEmpty()){
                st.push(s.charAt(i));
                continue;
            }
            if (st.peek() == s.charAt(i)){
                st.pop();
            }else {
                st.push(s.charAt(i));
            }
        }

        if (st.isEmpty()) answer = 1;
        
        return answer;
    }
}
