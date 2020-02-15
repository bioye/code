public class Palindrome{

  public static void main(String[] args) {
    System.out.println(new Palindrome().checkPalindrome("aabaa"));
  }

  boolean checkPalindrome(String inputString) {
    //if the size is even
    //split is half
    //if the size is odd
    //split in half+1
    //if left equals right, palindrome
    int length = inputString.length();
    int half =  0;
    String leftString = "";
    String rightString = "";
    if(length%2==0) {
      half = length/2;
      rightString = inputString.substring(half,length);
    }
    else {
      half = (int)Math.ceil(length/2);
      rightString = inputString.substring(half+1,length);
    }
    leftString = inputString.substring(0,half+1);
    boolean palindrome = true;
    for(int i=0;i<half;i++){
        System.out.println(leftString.charAt(i));
        System.out.println(rightString.charAt(half-1-i));
        if(!(leftString.charAt(i)==(rightString.charAt(half-1-i)))) return false;
    }
    return palindrome;
  }
}