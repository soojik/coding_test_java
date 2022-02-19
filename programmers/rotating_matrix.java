class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] matrix = new int[rows][columns];
        
        int idx = 1;
        for (int r=0;r<rows;r++) for (int c=0;c<columns;c++) matrix[r][c] = idx++;
        
        for (idx=0;idx<queries.length;idx++) {
            int r1 = queries[idx][0]-1;
            int c1 = queries[idx][1]-1;
            int r2 = queries[idx][2]-1;
            int c2 = queries[idx][3]-1;
            
            int tmp = matrix[r1][c1];
            int min = tmp;
            
            for (int i=r1;i<r2;i++) {
                matrix[i][c1] = matrix[i+1][c1];
                min = (min > matrix[i][c1]) ? matrix[i][c1] : min;
            }
            for (int i=c1;i<c2;i++) {
                matrix[r2][i] = matrix[r2][i+1];
                min = (min > matrix[r2][i]) ? matrix[r2][i] : min;
            }
            for (int i=r2;i>r1;i--) {
                matrix[i][c2] = matrix[i-1][c2];
                min = (min > matrix[i][c2]) ? matrix[i][c2] : min;
            }
            for (int i=c2;i>c1;i--) {
                matrix[r1][i] = matrix[r1][i-1];
                min = (min > matrix[r1][i]) ? matrix[r1][i] : min;
            }
            
            matrix[r1][c1+1] = tmp;
            answer[idx] = min;
        }
        
        return answer;
    }
}
