package Problem_0355_设计推特;

import java.util.*;

class Twitter {

    long twitterNo = 0L;
    Map<Integer, List<Long[]>> twiterListMap = new HashMap<>();//key:发送人，value:发送实体
    Map<Integer, Set<Integer>> followMap = new HashMap<>();//key:用户id，value：关注list

    /**
     * Initialize your data structure here.
     */
    public Twitter() {

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        List<Long[]> twitterList = twiterListMap.get(userId);
        if (twitterList == null) {
            twitterList = new ArrayList<>();
            twiterListMap.put(userId, twitterList);
        }
        twitterList.add(new Long[]{Long.valueOf(tweetId), twitterNo++});
        if (twitterList.size() > 10) twitterList.remove(0);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Long[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] < o2[1]) return -1;
            else if (o1[1] > o2[1]) return 1;
            else return 0;
        });
        Set<Integer> followSet = followMap.get(userId);
        if (followSet != null && !followSet.isEmpty()) {
            for (Integer followeeId : followSet) {
                List<Long[]> postedTwitters = twiterListMap.get(followeeId);
                if (postedTwitters == null || postedTwitters.isEmpty()) continue;
                queue.addAll(postedTwitters);
            }
        }
        List<Long[]> myTwitters = twiterListMap.get(userId);
        if (myTwitters != null && !myTwitters.isEmpty()) queue.addAll(myTwitters);
        while (queue.size() > 10) queue.poll();
        List<Integer> results = new ArrayList<>(10);
        while (!queue.isEmpty()) results.add(0, queue.poll()[0].intValue());
        return results;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        Set<Integer> followSet = followMap.get(followerId);
        if (followSet == null) {
            followSet = new HashSet<>();
            followMap.put(followerId, followSet);
        }
        followSet.add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followSet = followMap.get(followerId);
        if (followSet == null) {
            followSet = new HashSet<>();
            followMap.put(followerId, followSet);
        }
        followSet.remove(followeeId);
    }

}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

class Test {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        twitter.postTweet(1, 4);
        twitter.postTweet(2, 5);
        twitter.unfollow(1, 2);
        twitter.follow(1, 2);
        twitter.getNewsFeed(1);
    }
}

