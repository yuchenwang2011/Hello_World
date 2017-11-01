//First one is from Internet, second is CS61B's, third one is mine
//http://java2novice.com/images/merge_sort.png
//https://github.com/szpssky/sort-tool/blob/master/animation/Merge_sort_animation2.gif
Merge Sort is stable and fast, it guarantees O(nlogn), and needs space O(n)
public class Nana1{
	public static void main(String[] args) {
		int[] nums = new int[] {10,34,2,56,7,67,88,42};
		int[] tmpArray = new int[nums.length];
		mergeSort(nums, tmpArray, 0, nums.length -1);
		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
  }
	
	public static void mergeSort(int[] nums, int[] tmpArray, int start, int end) {
		if(start < end) {
			int mid = start + (end - start ) / 2;
			mergeSort(nums, tmpArray, start, mid);
			mergeSort(nums, tmpArray, mid + 1, end);		
			merge(nums, tmpArray, start, mid + 1, end);
		}
	}
	public static void merge(int[] nums, int[] tmpArray, int left, int right, int rightEnd) {
		int backLeft = left;
		int backEnd = rightEnd;
		
		int leftEnd = right - 1;
		int tmpPos = left;
		
		while(left <= leftEnd && right <= rightEnd) {
			if(nums[left] <= nums[right]) {
				tmpArray[tmpPos++] = nums[left++];
			} else {
				tmpArray[tmpPos++] = nums[right++];
			}
		}
		while(left<=leftEnd) {
			tmpArray[tmpPos++] = nums[left++];
		}
		while(right<=rightEnd) {
			tmpArray[tmpPos++] = nums[right++];
		}
		for(int i = backLeft; i <= backEnd; i++) {
			nums[i] = tmpArray[i];
		}
	}
}
