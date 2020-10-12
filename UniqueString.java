import java.util.Scanner;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class UniqueString{

  static boolean isPermutationOfSame(String s0, String s1){
    char[] s0ToChars = s0.toCharArray();
    char[] s1ToChars = s1.toCharArray();
    Arrays.sort(s0ToChars);
    Arrays.sort(s1ToChars);
    return Arrays.equals(s0ToChars,s1ToChars);
  }
    
  static boolean isUniqueOld(String inputString){
    inputString = inputString.toLowerCase();
    int stringLength = inputString.length();
    char[] stringArray = inputString.toCharArray();
    Arrays.sort(stringArray);
    if(stringLength==1) return true;
    for(int i=0; i<stringLength-1; i++){
      if(stringArray[i]==stringArray[i+1]){
        return false;
      }
    }
    return true;
  }

  static boolean isUnique(String s){
    Set<Character> uniqueChars = new HashSet<>();
    for(int i=0; i<s.length(); i++){
      char currentChar = s.charAt(i);
      if(uniqueChars.contains(currentChar)){
        return false;
      }
      else{
        uniqueChars.add(currentChar);
      }
    }
    return true;
  }
  

  static boolean isUniqueSecond(String s){
    //sort
    char[] stringArray = s.toCharArray();
    Arrays.sort(stringArray);
    //loop
    for(int i=0; i<stringArray.length-1; i++){
      if(stringArray[i]==stringArray[i+1]){
        return false;
      }
    }
    return true;
  }
  
  
  public static void main(String[] args){         
    System.out.println("Is String unique?  Answer = " 
      + isUnique("String"));
    System.out.println("Is stool unique?  Answer = " 
      + isUnique("stool"));
    System.out.println("Is S unique?  Answer = " 
      + isUnique("S"));

    Scanner scanner = new Scanner(System.in);
    int count = scanner.nextInt();
    scanner.nextLine();
    String input = "";
    for(int i=0; i<count; i++){
      input = scanner.nextLine();
      String input2 = scanner.nextLine();
      System.out.println("Is " + input +" unique?  Answer = " 
      + isUnique(input));

      System.out.println("Is " + input + " a permutation of "+ input2 +" ? " + isPermutationOfSame(input, input2));
    }
    scanner.close();
  
  }
}
