import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class paizaB091 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<Integer> dx = new ArrayList<Integer>(Arrays.asList(0, 0, 1, -1));
        ArrayList<Integer> dy = new ArrayList<Integer>(Arrays.asList(-1, 1, 0, 0));

        ArrayList<Integer> answer = new ArrayList<Integer>();

        // input 길이
        int n = Integer.parseInt(br.readLine());

        List<ArrayList<Integer>> inputArray = new ArrayList<>();
        ArrayList<Integer> cushionRow = new ArrayList<Integer>(Collections.nCopies(n + 2, 0));
        inputArray.add(cushionRow);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> row = new ArrayList<Integer>();
            row.add(0);
            for (int j = 0; j < n; j++) {
                row.add(Integer.parseInt(st.nextToken()));
            }
            row.add(0);
            inputArray.add(row);
        }

        inputArray.add(cushionRow);

        for (int i = 1; i < n + 2; i++) {
            for (int j = 1; j < n + 2; j++) {
                boolean isHighestFlag = true;
                for (int k = 0; k < 4; k++) {
                    int di = i + dx.get(k);
                    int dj = j + dy.get(k);
                    if (inputArray.get(i).get(j) <= inputArray.get(di).get(dj)) {
                        isHighestFlag = false;
                        break;
                    }
                }
                if (isHighestFlag) {
                    answer.add(inputArray.get(i).get(j));
                }
            }
        }
        Collections.sort(answer , Collections.reverseOrder());
        for (int item : answer) {
            System.out.println(item);
        }
    }
}