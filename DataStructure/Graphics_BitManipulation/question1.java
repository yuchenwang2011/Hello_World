public class Solution {
//there is actually another easier method O(m) instead of this O(n) solution
//The other solution is: number-1=subNum; number AND subNum, repeat until reach 0
//count how many times it needs to reach 0
   public int countOnes(int number) {
     int numOnes = 0;
     while(number != 0) {
       if ( (number & 1) == 1) {
         numOnes++;
       }
       number = number >>> 1;
     }
     return numOnes;
   }
   
   public static void main(String[] args) {
     Solution mySol = new Solution();
     int result = mySol.countOnes(5);//5=0xxx01001
     System.out.println(result);
   }
}

