//View the animation: http://visualgo.net/sorting
//The complexity best/worst is O(n + k), space is O(k), where k is the range of the number, though this k can be very large
//we can say the complexity is O(n). This sorting algorithm suits small range of number where you know the range
//https://rosettacode.org/wiki/Sorting_algorithms/Counting_sort#Java
public void counting sort(int[] nums, int min, int max){
    int[] count = new int[max - min + 1];
    for(int num : nums){
      count[num - min]++;
    }
    
    //copy the count back to original array
    int j = 0;
    for(int i = min; i <= max; i++){
        if(count[i - min] != 0) nums[j++] = i;
        count[i - min]--;
    }
}
