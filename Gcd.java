// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
class Gcd
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int generalizedGCD(int num, int[] arr)
    {
        // WRITE YOUR CODE HERE
        //obtain smallest integer in group;
        int smallest=(arr[0]);
        for(int i=1;i<num;i++){
            if(arr[i]<arr[i-1]) arr[i]=smallest;
        }
        int gcd = 1;
        for(int i=1;i<=smallest;i++){
            boolean divisible = true;
            for(int j=0;j<num;j++){
                //if divisible, true
                divisible = (arr[j]%i==0)&&divisible;
            }
            if (divisible) gcd=i;
        }
       return gcd;
    }
    // METHOD SIGNATURE ENDS
}