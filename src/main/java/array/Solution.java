package array;

import java.util.*;

class IntersectionOfArray {
    public static void main(String[] args) {
        // Sample data for nums1 and nums2
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        // Create an instance of IntersectionOfArrays class
        IntersectionOfArray intersectionOfArrays = new IntersectionOfArray();

        // Call the intersect method with nums1 and nums2
        int[] result = intersectionOfArrays.intersect(nums1, nums2);

        // Print the result
        System.out.println("Intersection of arrays: " + Arrays.toString(result));
        
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        // create a hash map that stores the frequency of elements
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums1) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // create a list that will store the intersection elements
        List<Integer> intersection = new ArrayList<>();

        // Itereate through num2 and add elements to intersection list if are present in num1
        for (int num : nums2) {
            if (frequencyMap.containsKey(num) && frequencyMap.get(num) > 0) {
                intersection.add(num);
                frequencyMap.put(num, frequencyMap.get(num) - 1);
            }
        }

        // convert the list in to array
        int[] result = new int[intersection.size()];
        int index = 0;
        for (int num : intersection) {
            result[index++] = num;
        }
        return  result;

    }
}