import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int min = Integer.MAX_VALUE;
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] members = new int[N][N];
        boolean[] isVisit = new boolean[N];

        StringTokenizer st;
        for (int i = 0; i < N; i ++) {
             st = new StringTokenizer(br.readLine(), " ");

             for(int j = 0; j < N; j ++) {
                 members[i][j] = Integer.parseInt(st.nextToken());
             }
        }

        backtracking(members, isVisit, 0, 0);

        print(String.valueOf(min));


        bw.flush();
        bw.close();
    }

    private static void backtracking(int[][] members, boolean[] isVisit, int index,  int selected) {
        if (min == 0) return;

        if (selected * 2 == members.length) {
            String state = Arrays.toString(isVisit);
            if (set.contains(state)) return;

            int compareStatus = calculateStatus(members, isVisit);
            min = Math.min(compareStatus, min);
            set.add(state);
            return;
        }

        for (int i = index; i < members.length; i ++) {
            if (!isVisit[i]) {
                isVisit[i] = true;
                backtracking(members, isVisit, i + 1, selected + 1);
                isVisit[i] = false;
            }
        }
    }


    private static int calculateStatus(int[][] members, boolean[] isVisit) {
        int start = 0;
        int link = 0;

        ArrayList<Integer> startList = new ArrayList<>();
        ArrayList<Integer> linkList = new ArrayList<>();

        for (int i = 0; i < isVisit.length; i ++) {
            if (isVisit[i]) startList.add(i);
            else linkList.add(i);
        }

        for (int i = 0; i < startList.size(); i ++) {
            for (int j = 0; j < startList.size(); j ++) {
                if (i != j) {
                    start += members[startList.get(i)][startList.get(j)];
                    link += members[linkList.get(i)][linkList.get(j)];
                }
            }
        }

        return Math.abs(start - link);
    }


    private static void print(String value) throws IOException {
        bw.write(value);
    }
}
