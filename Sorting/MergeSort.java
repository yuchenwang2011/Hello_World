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
public static void mergeSort(int[] a) {
  int[] tmpArray = new int[a.length];
  mergeSort(a, tmpArray, 0, a.length - 1);
}

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
