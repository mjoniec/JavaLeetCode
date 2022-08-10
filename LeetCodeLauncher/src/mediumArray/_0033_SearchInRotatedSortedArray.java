package mediumArray;

public class _0033_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int[] tab = nums;
        int left = 0; //binary search pointers
        int right = nums.length-1;
        int mid;

        while(left <= right)
        {
            mid = (left+right) / 2;

            if(tab[mid] == target){
                return mid;
            }

            if(tab[mid] >= tab[left]){ //not affected by rotation
                if(target >= tab[left] && target < tab[mid]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            else { //affected by rotation

            }
        }

        return -1;
    }

    public void run() {
        System.out.println("_0033_SearchInRotatedSortedArray: ");
        System.out.println("Given: [4,5,6,7,0,1,2] target = 0 Expected: 4 Actual: "
                + search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println("Given: [4,5,6,7,0,1,2] target = 3 Expected: -1 Actual: "
                + search(new int[]{4,5,6,7,0,1,2}, 3));
    }
}
