//http://www.java-examples.com/java-bubble-sort-example
//https://github.com/szpssky/sort-tool/raw/master/animation/Bubble_sort_animation.gif
Best case O(n), worse case and average O(n^2), memory O(1) auxiliary
	//sorting in an ascending order
	public void bubbleSort(int[] nums){
		int n = nums.length;
		for(int i = 0; i < nums.length; i++){
		//start from 1 prevent outof idx, n - i because after first round, the last element is already the largest
		//in the second round, the last second one is the second largest, no need to compare the last two elements
			for(int j = 1; j < n - i; j++){
			
				if(nums[j - 1] > nums[j]) {
					//swap them
					int tmp = nums[j - 1];
					nums[j - 1] = nums[j];
					nums[j] = tmp;
				}
				
			}
			
		}
		
	}
The best case O(n) is when the array is already sorted, but from above code, it's hard to understand. Actually, we need optimize
the code.
//According to this blog, http://www.cnblogs.com/melon-h/archive/2012/09/20/2694941.html
public void bubbleSort(int arr[]) {
    boolean didSwap;
    for(int i = 0, len = arr.length; i < len - 1; i++) {
        didSwap = false;
        for(int j = 0; j < len - i - 1; j++) {
            if(arr[j + 1] < arr[j]) {
                swap(arr, j, j + 1);
                didSwap = true;
            }
        }
        if(didSwap == false)
            return;
    }    
}
