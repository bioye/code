import java.io.*;
import java.util.*;

public class StringTokens {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        String[] tokens = s.split("[^A-Za-z]+");
        System.out.println(tokens.length);
        for(int i=0;i<tokens.length;i++){
            System.out.println(tokens[i]);
            //System.out.println(tokens[i].length());
        }
        scan.close();
    }
}