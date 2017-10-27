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
