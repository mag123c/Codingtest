import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] trueMan;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int inputLen = input.length;

        if(inputLen == 1) {
            System.out.println(M);
            return;
        }

        List<String> trueMan = new ArrayList<>();
        for(int i = 1; i < inputLen; i ++) {
            trueMan.add(input[i]);
        }

        List<int[]> tmp = new ArrayList<>();
        for(int i = 0; i < M; i ++) {
            input = br.readLine().split(" ");
            inputLen = input.length;

            int[] arr = new int[N + 1];
            for (int j = 1; j < inputLen; j ++) {
                arr[Integer.parseInt(input[j])]++;
            }
            tmp.add(arr);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(String s : trueMan) {
            queue.add(Integer.parseInt(s));
        }

        int answer = M;
        boolean[] visited = new boolean[N + 1];
        boolean[] visitedM = new boolean[M];

        while(!queue.isEmpty()) {
            int now = queue.poll();
            visited[now] = true;

            for(int i = 0; i < M; i ++) {
                int[] tmpArr = tmp.get(i);
                if(tmpArr[now] > 0 && !visitedM[i]) {
                    for(int j = 1; j < tmpArr.length; j ++) {
                        if(tmpArr[j] == 1 && !visited[j]) {
                            queue.add(j);
                            visited[j] = true;
                        }
                    }
                    answer--;
                    visitedM[i] = true;
                    if(answer == 0) {
                        System.out.println(answer);
                        return;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
