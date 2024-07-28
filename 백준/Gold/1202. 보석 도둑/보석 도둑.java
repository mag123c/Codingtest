import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

    static class Jewel {
        int weight;
        int price;

        Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(M, V);
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels, (j1, j2) -> j1.weight - j2.weight);
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>((p1, p2) -> p2 - p1);
        int j = 0;
        long maxValue = 0;

        for (int i = 0; i < K; i++) {
            while (j < N && jewels[j].weight <= bags[i]) {
                pq.offer(jewels[j].price);
                j++;
            }
            if (!pq.isEmpty()) {
                maxValue += pq.poll();
            }
        }

        bw.write(maxValue + "\n");
        bw.flush();
        bw.close();
    }
}
