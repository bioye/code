import java.util.Arrays;

public class NonTriplicate{

    public static void main(String[] args) {
        NonTriplicate testClass = new NonTriplicate();
        int nonTriplicate = testClass.getNonTriplicate(new int[]{6, 1, 3, 3, 3, 6, 6});
        System.out.println(nonTriplicate);
        nonTriplicate = testClass.getNonTriplicate(new int[]{13, 19, 13, 13});
        System.out.println(nonTriplicate);
    }
    
    //quicket solution, sort and do a walkthrough.
    int getNonTriplicate(int[]triplicatesButOne){

        Arrays.sort(triplicatesButOne);
        int candidate = triplicatesButOne[0];
        int count=1;
        for (int i = 1; i < triplicatesButOne.length; i++) {
            if(candidate==triplicatesButOne[i]){
                count++;
            }
            else if(candidate!=triplicatesButOne[i]){
                if(count==1) return candidate;
                else return triplicatesButOne[i];
            }
        }
        return candidate;
    }

    //ideal solution
    int getNonTriplicate0(int[]triplicatesButOne){
        //use base 3 arithmetic building on XOR
        
        return 0;
    }

}