import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> originQueue = new LinkedList<>();

        for(int i : priorities) {
            queue.offer(i);
        }
        for(int i = 0; i < priorities.length; i++) {
            originQueue.offer(i);
        }

        int result = 1;
        while(!originQueue.isEmpty()) {
            int originIndex = originQueue.poll();
            int originValue = priorities[originIndex];
            int maxValue = queue.peek();
            if(originValue < maxValue) {
                originQueue.offer(originIndex);
            } else if (originValue == maxValue) {
                if(originIndex == location) {
                    return result;
                } else {
                    queue.remove();
                    result++;
                }
            }
        }
        return result;
    }
}
