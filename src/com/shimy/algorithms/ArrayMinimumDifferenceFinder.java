import java.util.Arrays;

public class ArrayMinimumDifferenceFinder {

  /**
   * Finds the minimum absolute difference between any two elements in the given array. This solution is O(nlg(n)) on
   * average but has a worst case runtime of O(n^2) because of quicksort
   */
  public int minimumAbsoluteDifference(int[] arr) {
    int result = Integer.MAX_VALUE;
    // sort the array O(nlg(n))
    Arrays.sort(arr);
    // find the abs of each element to it's neighbours O(n)
    for (int i = 0; i < arr.length - 1; i++) {
      int a = arr[i];
      int b = arr[i + 1];
      int abs = Math.abs(a - b);
      if (abs < result) {
        result = abs;
      }
    }
    return result;
  }

}
