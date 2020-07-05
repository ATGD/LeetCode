package Problem_5297_跳跃游戏3;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean canReach(int[] arr, int start) {
        Set<Integer> set = new HashSet<>();
        return canInLoop(set, arr, start);
    }

    private boolean canInLoop(Set<Integer> set, int[] arr, int i) {
        if (!isInRange(arr, i))
            return false;
        if (set.contains(i))
            return false;
        if (arr[i] == 0)
            return true;
        set.add(i);
        if (isInRange(arr, i + arr[i])) {
            if (!set.contains(i + arr[i])) {
                boolean b = canInLoop(set, arr, i + arr[i]);
                if (b)
                    return true;
            }
        }
        if (isInRange(arr, i - arr[i])) {
            if (!set.contains(i - arr[i])) {
                boolean b = canInLoop(set, arr, i - arr[i]);
                if (b)
                    return true;
            }
        }
        return false;
    }

    private boolean isInRange(int[] arr, int position) {
        if (arr == null)
            return false;
        else if (arr.length <= position)
            return false;
        else if (position < 0)
            return false;
        else
            return true;
    }
}
