//Selection sort does have the advantage that it requires at most n – 1 swaps. 
//In situations in which moving data elements is more expensive than comparing them, 
//selection sort may perform better than other algorithms.
//https://en.wikipedia.org/wiki/File:Selection-Sort-Animation.gif
//https://github.com/szpssky/sort-tool/raw/master/animation/Selection_sort_animation.gif
//Average, best, worst complexity are all O(n^2), memory O(1)
//http://javahungry.blogspot.com/2013/06/java-sorting-program-code-selection-sort.html

public void selectionSort(int[] nums){
	for(int i = 0; i < nums.length - 1; i++){
		int minIdx = i;
		for(int j = i + 1; j < nums.length; j++){
			if(nums[j] < nums[minIdx]) minIdx =j;
		}
		swap(nums, i, minIdx);
	}

}

public void swap(int[] nums, int i, int j){
	int tmp = nums[i];
	nums[i] = nums[j];
	nums[j] = tmp;
}
