import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class ZeroMatrix {

  public static void main(String[] args) {
    int[][] matrix = new int[3][2];
    matrix[0] = new int[]{1, 8};
    matrix[1] = new int[]{9, 4};
    matrix[2] = new int[]{5, 0};
    System.out.println(Arrays.deepToString(convertToZeroMatrix(matrix)));
  }
  
  static int[][] convertToZeroMatrix(int[][] matrix){
    Set<Integer> zeroRows = new HashSet<>();
    Set<Integer> zeroColumns = new HashSet<>();
    for(int i=0; i<matrix.length; i++){
      for(int j=0; j<matrix[0].length; j++){
        if(matrix[i][j]==0){
          zeroRows.add(i);
          zeroColumns.add(j);
        }
      }
    }
    for(int row:zeroRows){
      for(int j=0; j<matrix[0].length;j++){
        matrix[row][j]=0;
      }
    }
    for(int j=0; j<matrix.length;j++){
      for(int column:zeroColumns){
        matrix[j][column]=0;
      }
    }
    return matrix;
  }
}