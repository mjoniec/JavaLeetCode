package mediumArray;

public class _0011_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length-1;

        while(left<right){
            int waterLevel = Math.min(height[left], height[right]);
            int water = waterLevel * (right - left);

            //System.out.println("left: " + left + " right: " + right + " tab[left]: " + height[left] + " tab[right]: " + height[right] + " Water: " + water);

            if(water>max){
                max = water;
            }

            if(height[left] < height[right]){//key to algorithm - we want to move the lower wall
                left++;
            }
            else{
                right--;
            }
        }

        return max;
    }

    public void run() {
        System.out.println("_0011_ContainerWithMostWater: ");
        System.out.println("Input: [1,8,6,2,5,4,8,3,7] Expected: 49 Actual: "
                + maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
