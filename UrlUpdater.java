import java.time.Duration;
import java.time.Instant;

public class UrlUpdater {

  public static void main(String[] args) {
    Instant start = Instant.now();
    for(int i=0;i<1000;i++){
      //System.out.println(
        toUrlLong("it   is   a   goal");
      //);
    }
    System.out.println(Duration.between(start, Instant.now()).toNanos()+"s");
    start = Instant.now();
    for(int i=0;i<1000;i++){
      //System.out.println(
        toUrl("it   is   a   goal");
      //);
    }
    System.out.println(Duration.between(start, Instant.now()).toNanos()+"s");
  }

  // tokenize and concat
  static String toUrl(String s){
    if(s==null||s.trim()=="") return s;
    String[] tokens = s.split("\\s+");
    int length = tokens.length;
    if(length<2)return s;
    StringBuilder builder = new StringBuilder();  
    for(int i=0;i<length-1;i++){
      builder.append(tokens[i]);
      builder.append("%20");
    }
    builder.append(tokens[length-1]);
    return builder.toString();
  }

  static String toUrlLong(String s) {
    // convert to char[]
    int length = s.length();
    char[] stringChars = s.toCharArray();
    int i = 0;
    while (i < length) {
      // insert the string
      if (stringChars[i] == ' ') {
        insertCode(stringChars, i);
        i = i + 3;
      }
      i++;
    }
    return new String(stringChars);
  }

  static void insertCode(char[] stringChars, int index) {
    int spaceCount = 1;
    // how many spaces?
    if (index>=stringChars.length-2) {
      return; 
    }
    for (int i = index + 1;stringChars[i] == ' '; i++) {
      spaceCount++;
      if (i>stringChars.length-2){
        return;
      } 
    }
    int spaceDiff = spaceCount - 3;
    if (spaceDiff < 0) {
      // increase space
      int indexAfterSpace = index + spaceCount;
      for (int i = stringChars.length - 1 + spaceDiff; i > index; i--) {
        if (i >= indexAfterSpace) {
          stringChars[i - spaceDiff] = stringChars[i];
        } else {
          stringChars[i] = ' ';
        }
      }
    } else if (spaceDiff > 0) {
      // reduce space
      for (int i = index + 3; i < stringChars.length; i++) {
        stringChars[i] = stringChars[i + spaceDiff];
      }
    }
    // insert
    stringChars[index] = '%';
    stringChars[index + 1] = '2';
    stringChars[index + 2] = '0';
  }

}
