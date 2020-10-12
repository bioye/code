public class CompressString {

  public static void main(String[] args) {
    System.out.println(convertToCompressed("aabcccccaaa"));
    System.out.println(compressBad("aabcccccaaa"));
  }

  static String compressBad(String str){
    String compressString = "";
    int countConsecutive = 0;
    for (int i = 0; i < str.length(); i++) {
      countConsecutive++;
      if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
        compressString += "" + str.charAt(i) + countConsecutive;
        countConsecutive = 0;
      }
    }
    return compressString.length() < str.length() ? compressString : str;
  }

  //I got this wrong.  Though my compression is higher, it doesn't conform to the spec.
  static String convertToCompressedWrong(String s){
    int currentCount = 1;
    StringBuilder builder = new StringBuilder();
    char currentChar;
    int length = s.length();
    for(int i=0; i<length; i++){
      currentChar = s.charAt(i);
      if(i!=length-1 && currentChar==s.charAt(i+1)){
        currentCount++;
      }
      else{
        builder.append(currentChar);
        if(currentCount==2){
          builder.append(currentChar); 
        }
        else if(currentCount>2){
          builder.append(currentCount);
        }
        currentCount = 1;
      }
    }
    return builder.toString();
  }
  
}
