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
  
  void phoneWord (int[] phoneNumber) {
	 char[] word = new char[phoneNumber.length];
	 convert(phoneNumber,word, 0);
  }
  
  void convert(int[] phoneNumber, char[] word, int start) {
	  if(start == phoneNumber.length) {
		  //System.out.println(Arrays.toString(word));
		  System.out.println(new String(word));
		  return;
	  }
	  
	  for(int i = 1; i <= 3; i++) {
		  word[start] = keyHelper(phoneNumber[start], i);
		  convert(phoneNumber, word, start+1);
		  //this is actually useless because the array element is replaced
		  //word[start] = '\0';
	  }
  }
  
  public static void main(String[] args) {
    Telephone myTel = new Telephone();
    int key = 9;
    int digit = 3;
    int[] myNumber = new int[] {2,2,3};
    System.out.println(myTel.keyHelper(key, digit) + " nima");
    myTel.phoneWord(myNumber);
  }
  
}

