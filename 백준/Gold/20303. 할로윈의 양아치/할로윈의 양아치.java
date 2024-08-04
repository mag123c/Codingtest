import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Group {
        int people;
        int candies;

        public Group(int people, int candies) {
            this.people = people;
            this.candies = candies;
        }
    }

    public static List<Group> group = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] candyArr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            candyArr[i] = Integer.parseInt(st.nextToken());
        }

        List<List<Integer>> lis = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            lis.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lis.get(a).add(b);
            lis.get(b).add(a);
        }

        bfs(lis, candyArr, N);
        dp(K);
    }

    private static void dp(int K) {
        int[] dp = new int[K];
        for (Group g : group) {
            for (int j = K - 1; j >= g.people; j--) {
                dp[j] = Math.max(dp[j], dp[j - g.people] + g.candies);
            }
        }

        int maxCandies = 0;
        for (int i = 0; i < K; i++) {
            maxCandies = Math.max(maxCandies, dp[i]);
        }
        System.out.println(maxCandies);

    }

    private static void bfs(List<List<Integer>> lis, int[] candyArr, int N) {
        boolean[] isVisit = new boolean[N + 1];

        for (int i = 1; i <= N; i ++) {
            if (isVisit[i]) continue;
            int people = 0;
            int candies = 0;

            Queue<Integer> que = new LinkedList<>();
            que.offer(i);
            isVisit[i] = true;

            while (!que.isEmpty()) {
                int curr = que.poll();
                people++;
                candies += candyArr[curr];
                                
                for (int neighbor: lis.get(curr)) {
                    if (!isVisit[neighbor]) {
                        isVisit[neighbor] = true;
                        que.offer(neighbor);
                    }
                }
            }

            group.add(new Group(people, candies));
        }

    }
}
