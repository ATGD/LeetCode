### [5296\. 两棵二叉搜索树中的所有元素](https://leetcode-cn.com/contest/weekly-contest-169/problems/all-elements-in-two-binary-search-trees/)

Difficulty: **Medium**

给你 `root1` 和 `root2` 这两棵二叉搜索树。

请你返回一个列表，其中包含 **两棵树 **中的所有整数并按 **升序** 排序。.

**示例 1：**

![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/12/29/q2-e1.png)

```
输入：root1 = [2,1,4], root2 = [1,0,3]
输出：[0,1,1,2,3,4]
```

**示例 2：**

```
输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
输出：[-10,0,0,1,2,5,7,10]
```

**示例 3：**

```
输入：root1 = [], root2 = [5,1,7,0,2]
输出：[0,1,2,5,7]
```

**示例 4：**

```
输入：root1 = [0,-10,10], root2 = []
输出：[-10,0,10]
```

**示例 5：**

![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/12/29/q2-e5-.png)

```
输入：root1 = [1,null,8], root2 = [8,1]
输出：[1,1,8,8]
```

**提示：**

*   每棵树最多有 `5000` 个节点。
*   每个节点的值在 `[-10^5, 10^5]` 之间。

#### Solution

Language: **Java**

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        
    }
}
```