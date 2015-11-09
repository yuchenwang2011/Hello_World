import java.util.Arrays;

public class Factoria {
   //Three methods will be used to finish this, assume all numbers are positive
   //First, general recursive method
  int factMethod1(int num) {
    if (num == 1) {
      return 1;
    } else {
      return num * factMethod1(num-1);
    }
  }
  
   //Second, using a wrapper function
  int[] factMethod2Wrap(int num) {
    int[] results = new int[num];
    int level = 0;
    factMethod2Cal(results, num, level);
    return results; 
  }
  
  int factMethod2Cal(int[] results, int num, int level) {
    if (num == 1) {
      if (level == 0) {
        results[level] = 1;
      } else {
        results[level] = 1;
      }
      return 1;
    } else {
      results[level] = num * factMethod2Cal(results, num-1, level+1);
      return results[level];
    }
  }
  
   //Third, use iterative instead of recursive.
  int factMethod3(int num) {
    int result = 1;
      while(num > 1) {
          result = result * num;
          num --;
      }
      if (num == 1) {
          result = result * 1;
      }
      return result;
  }
  
  public static void main(String[] args) {
    Factoria myFact = new Factoria();
    System.out.println(myFact.factMethod1(3));
      int[] testArray = myFact.factMethod2Wrap(14);
    System.out.println(Arrays.toString(testArray));
    System.out.println(myFact.factMethod3(3));
  }
}

