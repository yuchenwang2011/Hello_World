public class Telephone {
  char keyHelper(int number, int digit) {
    String[] phoneDic = new String[]{"0","1","ABC","DEF","GHI","JKL","MNO","PRS","TUV","WXY"};
    
    if (number > 9 || number <0 || digit >3 || digit <1) {
      System.err.println("Input not valid");
      return '\0';
    } else {
      if(number == 0 || number ==1) {
        digit = 1;
      }
      return phoneDic[number].charAt(digit-1);
    }
    }
  
  public static void main(String[] args) {
    Telephone myTel = new Telephone();
    int key = 9;
    int digit = 3;
    System.out.println(myTel.keyHelper(key, digit) + " nima");
  }
  
  
}

