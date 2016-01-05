//the first method uses an array to implement, very inefficient but gives you the idea how it works
//Say the 5(1) 3 5(2) 2 --> 2 3 5(2) 5(1), unstable  
//but now it's stalbe, 5(1) 3 5(2) 2 --> 2 5(1) 3 5(2) --> 2 3 5(1) 5(2)
import java.util.Arrays;
public class stableSelectionSorting {
  public int[] stableSort(int[] data) {
    sortProcess(data,0);
    return data;
  }
  
  public void sortProcess(int[] data, int start) {
  if (start < data.length) {
    int minimalIndex = start;
    for(int i = start; i < data.length; i++) {
      if( data[i] < data[minimalIndex]) {
      minimalIndex = i;
      }
    }
    int minimal = data[minimalIndex];
    System.arraycopy(data, start, data, start+1, minimalIndex-start);
    data[start] = minimal;
    sortProcess(data, start+1);
    }
  }
  public static void main(String[] args) {
  int[] testData = new int[] {1,-3,5,2,56,2,6,2,4};
  stableSelectionSorting mySort = new stableSelectionSorting();
  testData = mySort.stableSort(testData);
  System.out.println(Arrays.toString(testData));
  }
}
//second method use CursorableLinkedList.Cursor which i don't understand at all, i will do it the second round
