
public class Day6 {
	
	    public static void main(String[] args) {
	        int[] nums1 = {1, 3, 5, 7};
	        int[] nums2 = {2, 4, 6, 8, 9};

	        int[] merged = mergeSortedArrays(nums1, nums2);

	        System.out.print("Merged Sorted Array: ");
	        for (int num : merged) {
	            System.out.print(num + " ");
	        }
	    }

	    public static int[] mergeSortedArrays(int[] nums1, int[] nums2) {
	        int i = 0, j = 0, k = 0;
	        int[] result = new int[nums1.length + nums2.length];

	        // Merge elements while comparing
	        while (i < nums1.length && j < nums2.length) {
	            if (nums1[i] <= nums2[j]) {
	                result[k++] = nums1[i++];
	            } else {
	                result[k++] = nums2[j++];
	            }
	        }

	        // Copy remaining elements
	        while (i < nums1.length) {
	            result[k++] = nums1[i++];
	        }

	        while (j < nums2.length) {
	            result[k++] = nums2[j++];
	        }

	        return result;
	    }
	}


