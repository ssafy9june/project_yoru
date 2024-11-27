import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class paizaC142 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String wantedMenu = br.readLine();
        Integer cntMenu = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        boolean foundFlag = false;

        while (st.hasMoreTokens()) {
            if (wantedMenu.equals(st.nextToken())) {
                foundFlag = true;
                System.out.println("Yes");
                break;
            }
        }
        if (!foundFlag) {
            System.out.println("No");
        }
    }
}
