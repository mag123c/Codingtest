import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] people = new int[N + 1][N + 1];

        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < N; j ++) {
                people[i][j] = 5001;
            }
        }

        for(int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            people[a][b] = people[b][a] = 1;
        }

        for(int i = 0; i < N; i ++) {
            for(int j = 0 ; j < N; j ++) {
                for(int k = 0; k < N; k ++) {
                    people[j][k] = Math.min(people[j][k], people[j][i] + people[i][k]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int answer = 0;
        for(int i = 0; i < N; i ++) {
            int sum = 0;
            for(int j = 0 ; j < N; j ++) {
                sum += people[i][j];
            }

            if(min > sum) {
                min = sum;
                answer = i + 1;
            }
        }

        System.out.println(answer);
    }
}
