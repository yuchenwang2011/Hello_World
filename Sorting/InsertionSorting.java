import java.util.Arrays;
public class InsertionSorting {
    
    int[] insertSorting(int[] data) {
       for (int i = 1; i < data.length; i++) {    
            for (int j = 0; j < i; j++) {  
                 if (data[j] >= data[i]) {
                     int tmp = data[i];
               System.arraycopy(data, j, data, j+1, i-j);
               data[j] = tmp;
                 }
            }
       }
     return data;
    }
  
    public static void main(String[] args) {
        InsertionSorting myInsert = new InsertionSorting();
        int[] testInt = new int[] {4,1,3,6,9,12,4,2};
        System.out.println(Arrays.toString(myInsert.insertSorting(testInt)));
    }
}

