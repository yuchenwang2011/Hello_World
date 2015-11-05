public class StringInt {
    int stringToInt(String str) {
         int result = 0;
         int i = 0;
         boolean isNega = false;
       if (str.charAt(0) == '-') {
      isNega = true;
      i++;
     } 
         while (i < str.length()) {
             if (str.charAt(0) == '-') {
                isNega = true;
             } 
         result = result*10 + (str.charAt(i) - '0');   
         i++;
         }
     
       if (isNega == true) {
           result = -result;
       }
         return result;
    }
  
    String intToString(int num) {
         String str = new String();
         int maxDigits = 10;
         char[] tmp = new char[maxDigits+1];
         int i = 0;
         if (num < 0) {
           num = -num;
             str = str + '-';
         }
         if (num == 0) {
           str = str + num;
         }
         while (num != 0) {
          tmp[i] = (char) (num % 10 + '0');
          num = num/10;
          i++; // i is the number of digits of num
         }
         
         while (i != 0) {
           str = str + tmp[i-1];
           i--;
         }
         return str;
    }
    
    public static void main(String[] args) {
        StringInt myTest = new StringInt();
        String str = "12";
        int num = 123;
        System.out.println(myTest.stringToInt(str));
        System.out.println(myTest.intToString(num));
    }
}

