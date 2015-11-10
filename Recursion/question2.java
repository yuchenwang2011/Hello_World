public class BinarySearch {
//2 methods will be used, one is recursive, second is iterative
   int binarySearch(int num, int[] array) throws BSException {
     return binarySearchCal(num, array, 0, array.length-1);
   }
   
   int binarySearchCal(int num, int[] array, int start, int end) 
                                          throws BSException{
     int mid = (start+end)/2;
     int result;
     if (start == end && array[mid] != num) {
      throw new BSException("number not in the array");
     }
     
     if (num < array[mid]) {
      end = mid-1;
      result = binarySearchCal(num, array, start, end);
     } else if (num > array[mid]) {
      start = mid+1;
      result = binarySearchCal(num, array, start, end);
     } else {
      result = array[mid];  
     }
     
     return result;
   }
   
   
   int binarySearch2(int num, int[] array) throws BSException {
     int start = 0;
     int end = array.length-1;
     int mid = (start+end)/2;
     while(true) {
      mid = (start+end)/2;
       if (start == end && num != array[start]) {
         throw new BSException("Number is not in the array");
       } 
      if(num < array[mid]) {
        end = mid-1;
      } else if (num > array[mid]) {
        start = mid+1; 
      } else {
        return array[mid];
      }
     }
   }
   
   
   public static void main(String[] args) {
     BinarySearch mySearch = new BinarySearch();
     int[] myInt = new int[] {1, 2, 3, 4, 5, 6, 7};
     int[] myInt2 = new int[] {1,2,3,4,5,6,7,8};
     try {
       System.out.println(mySearch.binarySearch(5, myInt));
       System.out.println(mySearch.binarySearch(1, myInt2));
       System.out.println(mySearch.binarySearch2(1, myInt));
       System.out.println(mySearch.binarySearch2(9, myInt2));
     } catch (BSException e) {
     System.err.println(e);
     }
   }
  
}

