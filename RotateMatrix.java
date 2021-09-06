import java.util.Arrays;

public class RotateMatrix {

  public static void main(String[] args) {
    char[][] squareMatrix = new char[4][4];
    squareMatrix[0]= new char[]{'a','b','c','d'};
    squareMatrix[1]= new char[]{'e','f','g','h'};
    squareMatrix[2]= new char[]{'i','j','k','l'};
    squareMatrix[3]= new char[]{'m','n','o','p'};
    System.out.println(Arrays.deepToString(rotateMatrix(squareMatrix)));
  }

  static char[][] rotateMatrix(char[][] squareMatrix){
    int n = squareMatrix[0].length;
    char[][] rotatedMatrix = new char[n][n];
    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        rotatedMatrix[i][j]=squareMatrix[j][n-i-1];
      }    
    }  
    return rotatedMatrix;
  }

  static char[][] rotateMatrixLinear(char[][] squareMatrix){
    int n = squareMatrix[0].length;
    int offset = 0;
    for(int i=0;i<n;i++){
      offset++;
      for(int j=0;j<n;j++){
        //rotatedMatrix[i][j]=squareMatrix[j][n-i-1];
      }    
    }  
    return null;//ßrotatedMatrix;
  }
  
  static int convertToLinear(int i, int j, int n){
    return (i*n)+j;
  }
  
  static char getCharByLinear(int linear, int n, char[][] matrix){
    int i = linear/n;
    int j = linear%n;
    return matrix[i][j];
  }
  
}
