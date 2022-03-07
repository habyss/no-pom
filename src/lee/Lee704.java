package lee;

public class Lee704 {
    public static int search(int[] nums, int target) {
        // 二分 nums 升序
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int m = l + (r - l) / 2;
            if (nums[m] == target){
                return m;
            }else if (nums[m] > target){
                r = m - 1;
            }else {
                l = m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] param = {-1,0,3,5,9,12};
        int search = search(param, 13);
    }
}
