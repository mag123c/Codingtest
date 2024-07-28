import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> prime = primenum(N);

        bw.write(twoPointer(prime, N) + "\n");

        bw.flush();
        bw.close();
    }

    private static int twoPointer(ArrayList<Integer> prime, int N) {
        int cnt = 0;
        int start = 0;
        int end = 0;
        int sum = 0;
        int size = prime.size();

        while(start < size) {
            if (sum < N && end < size) {
                sum += prime.get(end++);
            } 
            else if (sum >= N) {
                if (sum == N) cnt++;
                sum -= prime.get(start++);
            } 
            else {
                break;
            }
        }


        return cnt;
    }

    private static ArrayList<Integer> primenum(int N) {
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= N; i ++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        ArrayList<Integer> prime = new ArrayList<>();
        for (int i = 0; i <= N; i ++) {
            if (isPrime[i]) {
                prime.add(i);
            }
        }

        return prime;
    }
}
