import java.io.IOException;
import java.util.Scanner;

public class SquareRoot{

  int sqrt(int n) {
    return sqrtHelper(n, 1, n);
  }

  int sqrtHelper(int n, int min, int max) {
    System.out.println("min = " + min + ", max = " + max);
    if (max < min) return -1;

    int guess = (min + max) / 2;
    if (guess * guess == n) {
      return guess;
    } 
    else if (guess * guess < n) {
      return sqrtHelper(n, guess + 1, max);
    }
    else {
      return sqrtHelper(n, min, guess - 1);
    }
  }

  public static void main (String[] args){
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    System.out.println(new SquareRoot().sqrt(n));
    scanner.close();
  }
}
