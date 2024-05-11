package arraystring;

public class daily2079 {
    public static void main(String[] args) {

    }
}

class Solution2079 {
    public int wateringPlants(int[] plants, int capacity) {
        // 给植物浇水
        // 思路：按题意模拟即可

        int ans = 0, water = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (water >= plants[i]) {
                water -= plants[i];
                ans += 1;
            } else {
                water = capacity - plants[i];
                ans += i * 2 + 1;
            }
        }

        return ans;
    }
}