public class reverse {
  //i just assume there is only space in this sentence.
   void reverseString(char[] arry, int start, int end){
    char tmp;
    while (end > start) {
      tmp = arry[start];
      arry[start] = arry[end];
      arry[end] = tmp;
      start ++;
      end --;
    }
   }
   
   char[] reverseSentence(char[] sentence) {
    int length = sentence.length;
    int start = 0;
    int end = 1;
    reverseString(sentence, start, length-1);
    System.out.println(sentence);
    while (end < length) {
      if (sentence[end] == ' ' && end != (length-1)) {
        if (end == 0) {
          reverseString(sentence, start, end); 
        } else {
          reverseString(sentence, start, end-1);
        }
       start = end+1; 
      } else if (end == (length-1)) {
       reverseString(sentence, start, end);
         start = end+1; 
      }
      end ++;
    }
    return sentence;
   }
   
   public static void main(String[] args) {
     reverse myReverse = new reverse();
     String myString = "Hello   world nima ";
     char[] charArry = myString.toCharArray();
     System.out.println(charArry);
     charArry = myReverse.reverseSentence(charArry);
     System.out.println(charArry);
   }
}

