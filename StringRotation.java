import java.util.Set;
import java.util.HashSet;

public class StringRotation {

  public static void main(String[] args) {
    System.out.println(isRotation(null, null));
  }

  static boolean isRotation(String s1, String s2){
    if(s2==s1){
      return true;
    }
    if(s2==null||s1==null){
      return false;
    }
    if(s2.equals(s1)){
      return true;
    }
    if(s2.length()!=s1.length()){
      return false;
    }
    char testChar = s1.charAt(0);
    int index = s2.indexOf(testChar);
    if(index==-1){
      return false;
    }
    String subString=s2;
    while(index>-1){
      StringBuilder builder = new StringBuilder(
            s2.substring(index, s2.length()));
      builder.append(s2.substring(0, index));
      System.out.println(builder.toString());
      System.out.println(s1);
      if(s1.equals(builder.toString())){
        return true;
      }
      else{
       subString = subString.substring(index+1, subString.length());
       index = subString.indexOf(testChar);
      }
    }
    return false;
  }
}