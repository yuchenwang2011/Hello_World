//First one is from Internet, second is CS61B's, third one is mine
//This picture is super good
//http://java2novice.com/images/merge_sort.png
/* *************************************************************** */
public class MyMergeSort {
    
    private int[] array;
    private int[] tempMergArr;
    private int length;
 
    public static void main(String a[]){
         
        int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
        MyMergeSort mms = new MyMergeSort();
        mms.sort(inputArr);
        for(int i:inputArr){
            System.out.print(i);
            System.out.print(" ");
        }
    }
     
    public void sort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }
 
    private void doMergeSort(int lowerIndex, int higherIndex) {
         
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
 
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
 
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
//I don't understand this part, I think it's wrong
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
 
    }
}


/* *************************************************************** */
private static void mergeSort(int[] a, int[] tmpArray, int left, int right) {
    if (left < right) {
      int center = (left + right) / 2;
      mergeSort(a, tmpArray, left, center);
      mergeSort(a, tmpArray, center + 1, right);
      merge(a, tmpArray, left, center + 1, right);
    }
  }

  private static void merge(int[] a, int[] tmpArray, int leftPos, int rightPos,
                            int rightEnd) {
    int leftEnd = rightPos - 1;
    int tmpPos = leftPos;
    int numElements = rightEnd - leftPos + 1;

    // Main loop
    while (leftPos <= leftEnd && rightPos <= rightEnd) {
      if (a[leftPos] < a[rightPos]) {
        tmpArray[tmpPos++] = a[leftPos++];
      } else {
        tmpArray[tmpPos++] = a[rightPos++];
      }
    }
    while (leftPos <= leftEnd) {
      tmpArray[tmpPos++] = a[leftPos++];
    }
    while(rightPos <= rightEnd) {
      tmpArray[tmpPos++] = a[rightPos++];
    }
    // Copy TmpArray back
    for (int i = 0; i < numElements; i++, rightEnd--) {
      a[rightEnd] = tmpArray[rightEnd];
    }
  }

/* *************************************************************** */

import java.util.Arrays;
public class MergeSort {
  void mergeSort(int[] data) {
    if (data.length <=1) {
       return;
    }
    sortProcess(data, 0, data.length-1);    
  }
  
    void sortProcess(int[] data, int low, int high) {
      if(low < high) {  //here it must be low < high, which means now there are 2 elements
        int middle = (high + low)/2;
        sortProcess(data, low, middle);
        sortProcess(data, middle+1, high);
        mergeProcess(data, low, middle, high);
      }
    }
       
    void mergeProcess (int[] data, int low, int middle, int high) {  
        int[] tmpArry = new int[high - low + 1];
        //System.arraycopy(data, low, tmpArry, 0, high-low+1);
        int i = low, j = middle+1, k = 0;
        while (i <= middle && j <= high) {
          if (data[i] <= data[j]) {
             tmpArry[k] = data[i];
             i++;
          } else {
             tmpArry[k] = data[j] ;
             j++;
          }
          k++;
        }
        while(i <= middle) {
          tmpArry[k] = data[i];
          i++;
          k++;
        }
        while(j <= high) {
          tmpArry[k] = data[j];
          j++;
          k++;
        }
        System.arraycopy(tmpArry, 0, data, low, high-low+1);  
    }
      
  
  public static void main(String[] args) {
    MergeSort mySort = new MergeSort();
    int[] testInt = new int[] {1,2,3,6,89,3,4,2,-5,-5,6,7,6,10,2};
    mySort.mergeSort(testInt);
    System.out.println(Arrays.toString(testInt));
  }
  
}
