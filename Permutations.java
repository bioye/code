import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Permutations{

  public static void main(String[]args){
    System.out.println(getPermutations("abc"));
  }

  static Set<String> getPermutations(String s){
    List<Character> stringList = new LinkedList<>();
    Set<String> stringSet = new HashSet<>();
    for(int i=0;i<s.length();i++){
      stringList.add(s.charAt(i));
    }
    stringSet.add(s);
    for(int i=0;i<s.length();i++){
      char current = stringList.remove(i);
      for(int j=0;j<s.length();j++){
        stringList.add(j, current);
        stringSet.add(listToString(stringList));
        System.out.println("string list = " + stringList);
        stringList.remove(j);
      }
      stringList.add(i, current);
    }
    return stringSet;
  }

  static String listToString(List<Character> stringList){
    char[] characters = new char[stringList.size()];
    for(int i=0;i<stringList.size();i++){
      characters[i]=stringList.get(i);
    }
    return new String(characters);
  }
}