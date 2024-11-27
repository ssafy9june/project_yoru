import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class paizaC157 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Integer n = Integer.parseInt(br.readLine());

        String input = br.readLine();

        Set<String> uniqueFlowers = new HashSet<>(Arrays.asList(input.split(" ")));
        System.out.println(uniqueFlowers.size());
    }
}