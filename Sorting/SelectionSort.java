import java.util.Arrays;
//Selection sort does have the advantage that it requires at most n – 1 swaps. 
//In situations in which moving data elements is more expensive than comparing them, 
//selection sort may perform better than other algorithms.
public class SelectionSorting {
    int[] selectionSort(int[] data) {
       sortProcess(data, 0); 
       return data;
    }
  
    void sortProcess(int[] data, int start) {
      if (start < data.length) {
      //first find the minimum of this recursion
      int minimumPosition = start;
      for(int i = start; i < data.length; i++) {
        if ( data[i] < data[minimumPosition]) {
          minimumPosition = i;
        }
      }
      //second swap the found minimum and the element at the start position
      int tmp = data[start];
      data[start] = data[minimumPosition];
      data[minimumPosition] = tmp;
      
      //recursion again
      sortProcess(data, start+1);
      }
      
    }
  
    public static void main(String[] args) {
      SelectionSorting mySelect = new SelectionSorting();
      int[] testInt = new int[] {3,1,123,4,6,8,9,3};
      System.out.println(Arrays.toString(mySelect.selectionSort(testInt)));
    }
}

