import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class NewPalindrome {

  public static void main(String[] args) {
    System.out.println(isPalindromePermutation("aaaa"));
    System.out.println(isPalindromePermutation("aaa"));
    System.out.println(isPalindromePermutation("tacocat"));
    System.out.println(isPalindromePermutation("taco cat"));
    System.out.println(isPalindromePermutation("bakabakab"));
    System.out.println(isPalindromePermutation("bakaakab"));
    System.out.println(isPalindromePermutation("bkbkaabaa"));
    System.out.println(isPalindromePermutation("back"));
  }

  static boolean isPalindromePermutation(String s){
    Set<Character> testSet = new HashSet<>();
    char current;
    for(int i=0;i<s.length();i++){
      current = s.charAt(i);
      if(!testSet.contains(current)){
        testSet.add(current);
      }
      else{
        testSet.remove(current);
      }
    }
    return testSet.isEmpty()||testSet.size()==1;
  }

  static boolean isPalindrome(String s){

    //create a map of characters and int
    Map<Character, Integer> palindateMap = new HashMap<>();
    char currentChar;
    for(int i=0;i<s.length();i++){
      currentChar = s.charAt(i);
      if(currentChar==' '){
        continue;
      }
      if(palindateMap.containsKey(currentChar)){
        int count = palindateMap.get(currentChar);
        palindateMap.replace(currentChar, ++count);
      }
      else{
        palindateMap.put(currentChar, 1); 
      }
    }
  
    //check map for all even or one odd
    //int oddCount
    int oddCount = 0;
    for(int value:palindateMap.values()){
      if(value%2==1){
        oddCount++;
      }
    }
    return oddCount==0||oddCount==1;
  }
}