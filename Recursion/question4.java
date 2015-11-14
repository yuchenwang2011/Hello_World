public class Combine {
   void combination(String str) {
     StringBuilder builder = new StringBuilder();
     combine(str, builder, 0);
   }
  
   void combine(String str, StringBuilder builder, int start) {
     if (builder.length() == str.length()) {
       return;
     }
     for (int i = start; i< str.length(); i++) {
       builder.append(str.charAt(i));
       System.out.println(builder);
       combine(str, builder, i+1);
       builder.setLength(builder.length()-1);
     }
   }
  
   public static void main(String[] args) {
     Combine myCombine = new Combine();
     myCombine.combination("1234");
   }
}

