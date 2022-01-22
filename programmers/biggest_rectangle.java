class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int tmp = 0;
        
        // 가로길이가 더 길도록 정렬
        for(int i=0;i<sizes.length;i++) {
            if (sizes[i][0] < sizes[i][1]) {
                tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }
        
        //가로, 세로 길이 중 가장 큰 수
        int max_1 = sizes[0][0];
        int max_2 = sizes[0][1];
        for (int i=0;i<sizes.length;i++) {
            if (max_1 < sizes[i][0]) max_1 = sizes[i][0];
            if (max_2 < sizes[i][1]) max_2 = sizes[i][1];
        }
        
        answer = max_1*max_2;
        
        return answer;
    }
}