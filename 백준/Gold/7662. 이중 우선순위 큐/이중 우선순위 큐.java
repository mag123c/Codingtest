import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i ++) {
            int k = Integer.parseInt(br.readLine());

            Queue<Integer> min = new PriorityQueue<>();
            Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer, Integer> map = new HashMap<>();
            StringTokenizer st;
            String word;
            int num;
            for (int j = 0; j < k; j ++) {
                st = new StringTokenizer(br.readLine());
                word = st.nextToken();
                num = Integer.parseInt(st.nextToken());

                if (word.equals("I")) {
                    offerQueue(min, max, map, num);
                }
                else if (word.equals("D")) {
                    pollQueue(min, max, map, num);
                }
            }

            cleanQueue(min, map);
            cleanQueue(max, map);

            if (min.isEmpty() || max.isEmpty()) {
                System.out.println("EMPTY");
            }
            else {
                System.out.println(max.poll() + " " + min.poll());
            }
        }
    }

    private static void offerQueue(Queue<Integer> min, Queue<Integer> max, Map<Integer, Integer> map, int num) {
        min.offer(num);
        max.offer(num);
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    private static void pollQueue(Queue<Integer> min, Queue<Integer> max, Map<Integer, Integer> map, int num) {
        if (num == 1) {
            cleanQueue(max, map);
            if (!max.isEmpty()) {
                int pollNum = max.poll();
                map.put(pollNum, map.getOrDefault(pollNum, 0) - 1);
            }
        }

        else if(num == -1) {
            cleanQueue(min, map);
            if (!min.isEmpty()) {
                int pollNum = min.poll();
                map.put(pollNum, map.getOrDefault(pollNum, 0) - 1);
            }
        }

    }

    private static void cleanQueue(Queue<Integer> q, Map<Integer, Integer> map) {
        while (!q.isEmpty() && map.get(q.peek()) == 0) {
            q.poll();
        }
    }
}
