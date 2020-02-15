// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.List;
import java.util.ArrayList;
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
//public class Solution
public class CompeteCells
{        
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days)
    {
    // WRITE YOUR CODE HERE
        for(int i=0;i<days;i++){
            //make a copy of states before updates
            int[]statesBeforeUpdate=new int[8];
            for(int k=0;k<states.length;k++){
                statesBeforeUpdate[k]=states[k];
            }
            //update each cell
            for(int j=0;j<statesBeforeUpdate.length;j++){
                //if j=0;
                if(j==0){
                    if(statesBeforeUpdate[1]==0) states[0]=0;
                    else states[0]=1;
                }
                else
                //if j=7;
                if(j==7){
                    if(statesBeforeUpdate[6]==0) states[7]=0;
                    else states[7]=1;
                }
                else{
                    if(statesBeforeUpdate[j-1]==statesBeforeUpdate[j+1]) states[j]=0;
                    else states[j]=1;
                }
            }
        }
        List<Integer> stateList = new ArrayList<Integer>();
        for(int i=0;i<states.length;i++){
            stateList.add(states[i]);
        }
        return stateList;
    }
  // METHOD SIGNATURE ENDS
}