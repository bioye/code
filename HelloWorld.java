import java.util.*;
import java.io.*;
import java.util.stream.Stream;
import java.lang.*;

public class HelloWorld{

     public static void main(String []args){
        String hashedPassword = "AAT7X0Hs0S6twhx4UeKN5SfL2A4zfCiVEVa2JHJo4o5zDm+yp9x1WWQhUKrbJXJO9A==";
        
        byte[] buffer = Base64.getDecoder().decode(hashedPassword);
        printbytearr2(buffer);
        printbytearr(buffer);
     }
     
     private static void printbytearr(byte[] arr) {
        for(int i=0; i< arr.length ; i++) {
            System.out.print(unsignedToBytes(arr[i]) +" ");
        }

        System.out.println("");
    }
    
    private static void printbytearr2(byte[] arr) {
        for(int i=0; i< arr.length ; i++) {
            System.out.print(arr[i] +" ");
        }

        System.out.println("");
    }
    
    public static int unsignedToBytes(byte b) {
        return b & 0xFF;
    }
    
}