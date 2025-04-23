import java.util.*;
class Solution {
    class Task implements Comparable<Task> {
        int no;
        int requestTime;
        int duration;

        public Task (int no, int requestTime, int duration) {
            this.no = no;
            this.requestTime = requestTime;
            this.duration = duration;
        }

        @Override
        public int compareTo(Task t) {
            return Comparator
                    .comparingInt((Task task) -> task.duration)
                    .thenComparingInt(task -> task.requestTime)
                    .thenComparingInt(task -> task.no)
                    .compare(this, t);
        }
    }


    public int solution(int[][] jobs) {
        PriorityQueue<Task> pq = new PriorityQueue<>();
        Arrays.sort(jobs, Comparator.comparingInt(j -> j[0]));

        int index = 0;
        int currentMs = 0;
        int totalTaskMs = 0;
        int doneCount = 0;
        while(doneCount < jobs.length) {
            while(index < jobs.length && jobs[index][0] <= currentMs) {
                pq.offer(new Task(index, jobs[index][0], jobs[index][1]));
                index++;
            }

            if (!pq.isEmpty()) {
                Task current = pq.poll();
                currentMs += current.duration;
                totalTaskMs += currentMs - current.requestTime;
                doneCount++;
            }
            else {
                currentMs = jobs[index][0];
            }
        }

        return totalTaskMs / jobs.length;
    }
}