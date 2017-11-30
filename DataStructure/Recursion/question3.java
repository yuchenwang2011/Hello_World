c class Permutation {
    void permutation(String origin) {
         StringBuilder builder = new StringBuilder(origin.length());
         boolean[] used = new boolean[origin.length()];
         permutationProcess(builder, origin, used);
    }
  
    //actually just think from the view of a StringBuilder
    void permutationProcess(StringBuilder builder, String origin, boolean[] used) {
        if (builder.length() == origin.length()) {
         System.out.println(builder);
         return;
        }
        
        for (int i = 0; i < origin.length(); i++) {
        if (used[i] == false) {
          builder.append(origin.charAt(i));
          used[i] = true;
          permutationProcess(builder, origin, used);
          used[i] = false;
          builder.setLength(builder.length()-1);
        } else {
          continue;
        }
        }
    }
    
   public static void main(String[] args) {
     Permutation myPer = new Permutation();
   myPer.permutation("abcd");
   }
  
}

