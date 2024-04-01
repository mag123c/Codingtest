import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0 ; i < N; i ++) {
            arr[i] = sc.nextInt();
        }

        whenDiagnosis(N, K, arr);

    }

    private static void whenDiagnosis(int N, int K, int[] arr) {

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < arr.length; i ++) {
            queue.add(i);
        }

        Integer[] newArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(newArr, Collections.reverseOrder());

        int cnt = 1;
        while (!queue.isEmpty()) {

            int tmp = arr[queue.peek()];

            if (newArr[cnt - 1] > tmp) {
                queue.offer(queue.poll());
            }

            else if (queue.poll() == K) {
                System.out.println(cnt);
                return;
            }

            else cnt++;

        }

        System.out.println(cnt);

    }

}