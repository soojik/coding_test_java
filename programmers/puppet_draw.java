import java.util.ArrayList;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        ArrayList<Integer> stock = new ArrayList<Integer>();
        
        for (int move : moves) {
            for (int[] row : board) {
                if (row[move-1]!=0) {
                    stock.add(row[move-1]);
                    row[move-1] = 0;
                    break;
                }
            }
            if (stock.size() > 1) {
                if (stock.get(stock.size()-1) == stock.get(stock.size()-2)) {
                    stock.remove(stock.size()-1);
                    stock.remove(stock.size()-1);
                    answer += 2;
                }
            }
        }
        
        return answer;
    }
}