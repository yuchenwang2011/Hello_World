//http://i.stack.imgur.com/CK6vC.jpg
//https://github.com/szpssky/sort-tool/blob/master/animation/Insertion_sort_animation.gif
//http://www.java2novice.com/java-sorting-algorithms/insertion-sort/
The best case when the array is already sorted, so O(n)
The average case is O(n^2)
The worst case is the list is already reverse order sorted, so O(n^2)
public void insertionSort(int[] nums){
    for(int i = 1; i < nums.length; i++){
        int tmp;
        for(int j = i; j >= 0; i--){
            if(nums[j] < nums[j - 1]) {
                tmp = nums[j-1];    //it's like bubble sorting here
                nums[j - 1] = nums[j];
                nums[j] = tmp;
            }
        }
    }
}

