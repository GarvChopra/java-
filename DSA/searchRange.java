
import java.util.*;
class Solution {
    public int[] searchRange(int[] nums, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                list.add(i);
               
            }
        }if(list.size()==0){
            return new int[]{-1,-1};
            }

    
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
            
        }
        return arr;

        }
        
        public static void main(String[] args) {
            Solution sol = new Solution();
            int[] nums = {5,7,7,8,8,10};
            int target = 8;
            int[] result = sol.searchRange(nums, target);
            System.out.println("Indices of target " + target + ": [" + result[0] + ", " + result[1] + "]");
        }
}
