public class SearchInRotatedSortedArray {
	public static int search(int[] nums, int target) {
		if(nums.length == 0)
			return -1;
        int start = 0, end = nums.length-1, mid;
        while(start + 1 < end) {
        	mid = start + (end - start ) / 2;
        	if(nums[mid] == target)
        		return mid;
        	//[start, mid] 与 [mid, end] 中必有一个有序
        	if(nums[start] < nums[mid]) {   //前半部分有序
        		if (nums[start] <= target && target <= nums[mid]) {
        			end = mid;
        		} else {
        			start = mid;
        		}
        	} else {	//后半部分有序
        		if(nums[mid] <= target && target <= nums[end]) {
        			start = mid;
        		} else {
        			end = mid;
        		}
        	}
        }
        if (nums[start] == target) {
        	return start;
        }
        if (nums[end] == target) {
        	return end;
        }
        return -1;
    }

    public static void main(String[] args) {
 		int[] nums = {4, 5, 6, 7, 0, 1, 2};
 		int pos = search(nums, 7);
 		System.out.println(pos);
    }
}