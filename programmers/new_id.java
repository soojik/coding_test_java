class Solution {
    public String solution(String new_id) {
        // 1
        new_id = new_id.toLowerCase();
        
        //2
        int i;

        String id_clone = "";
        
        for (i=0;i<new_id.length();i++) {
            char c = new_id.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                id_clone = id_clone + c;
            }
            else if ((c == '-') || (c == '_') || (c == '.')) {
                id_clone = id_clone + c;
            }
        }
        
        new_id = "";
        int cnt_dot = 0;

        // 3
        for (i=0;i<id_clone.length();i++) {
            if (id_clone.charAt(i) == '.') {
                if (cnt_dot < 1) {
                    new_id += '.';
                    cnt_dot++;
                }
            }
            else {
                cnt_dot = 0;
                new_id += id_clone.charAt(i);
            }
        }
        
        // 4
        if (new_id.length() > 1) {
            if (new_id.charAt(0) == '.') {
                new_id = new_id.substring(1);
            }
        }
        else if (new_id.charAt(0) == '.') {
            new_id = "";
        }

        if (new_id.length() > 0) {
            if (new_id.charAt(new_id.length()-1) == '.') {
                new_id = new_id.substring(0, new_id.length()-1);
            }
        }
        
        // 5
        if (new_id.isEmpty()) {
            new_id += 'a';
        }
        
        // 6
        if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15);
        }
        if (new_id.length() > 0) {
            if (new_id.charAt(new_id.length()-1) == '.') {
                new_id = new_id.substring(0, new_id.length()-1);
            }
        }
        
        // 7
        char c = new_id.charAt(new_id.length()-1);
        while (new_id.length() < 3) {
            new_id += c;
        }
        
        return new_id;
    }
}