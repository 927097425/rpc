package Leetcode;
import java.util.*;

public class _15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Map<Integer,Integer> numsSet = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i<nums.length;i++) numsSet.put(nums[i],i);

        for(int i = 0;i<nums.length-1;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            for(int j = i+1;j<nums.length;j++){
                if(numsSet.containsKey(-nums[i]-nums[j])){
                    int k = numsSet.get(-nums[i]-nums[j]);
                    if(k>i&&k>j) result.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],-nums[i]-nums[j])));
                }
            }
        }

        return result;
    }
}
