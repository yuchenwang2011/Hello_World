//this is the example, mine is the second one
public class QuickSort {
  public static void main(String[] args) {
    int[] x = { 9, 2, 4, 7, 3, 7, 10 };
    System.out.println(Arrays.toString(x));
 
    int low = 0;
    int high = x.length - 1;
 
    quickSort(x, low, high);
    System.out.println(Arrays.toString(x));
  }
 
  public static void quickSort(int[] arr, int low, int high) {
    if (arr == null || arr.length == 0)
      return;
 
    if (low >= high)
      return;
 
    // pick the pivot
    int middle = low + (high - low) / 2;
    int pivot = arr[middle];
 
    // make left < pivot and right > pivot
    int i = low, j = high;
    while (i <= j) {
      while (arr[i] < pivot) {
        i++;
      }
 
      while (arr[j] > pivot) {
        j--;
      }
 
      if (i <= j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }
    }
 
    // recursively sort two sub parts
    if (low < j)
      quickSort(arr, low, j);
 
    if (high > i)
      quickSort(arr, i, high);
  }
}

import java.util.Arrays;
public class QuickSort {
    void quickSort(int[] data, int low, int high) {
      if( data == null || data.length ==0) {
        return;
      }
      
      if(low >= high) {
        return;
      }
      
      int middle = low + (high - low)/2;
      int pivot = data[middle];
      int i = low; int j = high;
      while(i <= j) {
        //try to find a bigger element, can't be equal
        while (data[i] < pivot) {
          i++;
        }
        while (data[j] > pivot) {
          j--;
        }
        
        if (i <= j) {
          int tmp = data[i];
          data[i] = data[j];
          data[j] = tmp;
          i++;
          j--;
        }
      }     
      //until now, I don't need to worry about any details about the array, whatever
      //I just need to know that all the elements before i are smaller than pivot
      //And all the elements after j are bigger than pivot
      if(low < j) {   //error tolerance
        quickSort(data, low, j);
      }
      if(high > i) {
        quickSort(data, i, high);
      }   
    }
    
    public static void main(String[] args) {
      QuickSort mySort = new QuickSort();
      int[] testInt = new int[] {2,2,1,3,45,6,2,-5,8,3,7};
      mySort.quickSort(testInt, 0, testInt.length-1);
      System.out.println(Arrays.toString(testInt));
    }
}

