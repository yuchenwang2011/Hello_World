//this is the example, mine is the second one
//https://github.com/szpssky/sort-tool/blob/master/animation/Sorting_quicksort_anim.gif?raw=true
//The best case and average O(nlogn), worst case O(n^2) because of each time pivot is a min or max
//space complexity is O(logn), it's the stack space, even in the worst case.
public void quickSort(int[] arr, int low, int high) {
  if (arr == null || arr.length == 0 || low >= high) return;
  int pivot = arr[low + (high - low) / 2];
  // make left elements < pivot and right elements > pivot
  int i = low, j = high;
  while (i <= j) {
    while (arr[i] < pivot) i++; //means it's good
    while (arr[j] > pivot) j--; //means it's good
    if (i <= j) {
      swap(arr, i, j);
      i++; j--;
    }
  }
  if (j > low) quickSort(arr, low, j);
  if (i < high) quickSort(arr, i, high);
}

public void swap(int[] nums, int i, int j){
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}
