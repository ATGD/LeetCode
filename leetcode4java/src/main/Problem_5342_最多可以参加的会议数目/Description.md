### [5342\. 最多可以参加的会议数目](https://leetcode-cn.com/contest/weekly-contest-176/problems/maximum-number-of-events-that-can-be-attended/)

Difficulty: **Medium**

给你一个数组 `events`，其中 `events[i] = [startDay<sub style="display: inline;">i</sub>, endDay<sub style="display: inline;">i</sub>]` ，表示会议 `i` 开始于 `startDay<sub style="display: inline;">i</sub>` ，结束于 `endDay<sub style="display: inline;">i</sub>` 。

你可以在满足 `startDay<sub style="display: inline;">i</sub> <= d <= endDay<sub style="display: inline;">i</sub>`中的任意一天 `d` 参加会议 `i` 。注意，一天只能参加一个会议。

请你返回你可以参加的 **最大 **会议数目。

**示例 1：**

![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/16/e1.png)

```
输入：events = [[1,2],[2,3],[3,4]]
输出：3
解释：你可以参加所有的三个会议。
安排会议的一种方案如上图。
第 1 天参加第一个会议。
第 2 天参加第二个会议。
第 3 天参加第三个会议。
```

**示例 2：**

```
输入：events= [[1,2],[2,3],[3,4],[1,2]]
输出：4
```

**示例 3：**

```
输入：events = [[1,4],[4,4],[2,2],[3,4],[1,1]]
输出：4
```

**示例 4：**

```
输入：events = [[1,100000]]
输出：1
```

**示例 5：**

```
输入：events = [[1,1],[1,2],[1,3],[1,4],[1,5],[1,6],[1,7]]
输出：7
```

**提示：**

*   `1 <= events.length <= 10^5`
*   `events[i].length == 2`
*   `1 <= events[i][0] <= events[i][1] <= 10^5`

#### Solution

Language: **Java**

```java
class Solution {
    public int maxEvents(int[][] events) {
        
    }
}
```