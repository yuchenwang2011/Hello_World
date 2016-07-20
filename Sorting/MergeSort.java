//First one is from Internet, second is CS61B's, third one is mine
//http://java2novice.com/images/merge_sort.png
//https://github.com/szpssky/sort-tool/blob/master/animation/Merge_sort_animation2.gif
Merge Sort is stable and fast, it guarantees O(nlogn), and needs space O(n)
public static void mergeSort(int[] a) {
  int[] tmpArray = new int[a.length];
  mergeSort(a, tmpArray, 0, a.length - 1);
}

private static void mergeSort(int[] a, int[] tmpArray, int start, int end) {
    if (start < end) {
      int middle = start + (end - start) / 2;
      mergeSort(a, tmpArray, start, middle);
      mergeSort(a, tmpArray, middle + 1, end);
      merge(a, tmpArray, start, center + 1, end);
    }
  }

  private static void merge(int[] a, int[] tmpArray, int leftPos, int rightPos, int rightEnd) {
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
