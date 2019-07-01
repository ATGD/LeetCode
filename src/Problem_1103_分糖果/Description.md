####我们通过以下方式向一排n = num_people人分发一些糖果：

####然后我们给第一个人送1个糖果，给第二个人送2个糖果，依此类推，直到我们给最后一个人送糖果。

####然后，我们回到行的开头，向第一个人提供n + 1个糖果，向第二个人提供n + 2个糖果，依此类推，直到我们向最后一个人提供2 * n个糖果。

####这个过程重复进行（每次我们再给一个糖果，并在我们到达结束后移动到行的开始），直到我们用完糖果。 最后一个人将收到我们所有剩余的糖果（不一定比以前的礼物多一个）。

####返回一个数组（长度为num_people和总和糖果），代表糖果的最终分布。

示例1:
```
Input: candies = 7, num_people = 4
Output: [1,2,3,1]
Explanation:
On the first turn, ans[0] += 1, and the array is [1,0,0,0].
On the second turn, ans[1] += 2, and the array is [1,2,0,0].
On the third turn, ans[2] += 3, and the array is [1,2,3,0].
On the fourth turn, ans[3] += 1 (because there is only one candy left), and the final array is [1,2,3,1].
```
Example 2:
```
Input: candies = 10, num_people = 3
Output: [5,2,3]
Explanation: 
On the first turn, ans[0] += 1, and the array is [1,0,0].
On the second turn, ans[1] += 2, and the array is [1,2,0].
On the third turn, ans[2] += 3, and the array is [1,2,3].
On the fourth turn, ans[0] += 4, and the final array is [5,2,3].
 ```

限制:
```
1 <= candies <= 10^9
1 <= num_people <= 1000
```