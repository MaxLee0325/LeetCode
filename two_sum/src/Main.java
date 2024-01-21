import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int target = 9;
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        //1.use hashmap to store the integers and its index
        //2.use containsKey to determine if there's a match
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                res[1] = i;
                res[0] = map.get(target - nums[i]);
            }
            map.put(nums[i], i);
        }

        return res;
    }
}