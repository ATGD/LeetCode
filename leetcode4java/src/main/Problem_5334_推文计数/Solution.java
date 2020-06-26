package Problem_5334_推文计数;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TweetCounts {

    public Map<String, List<Tweet>> tweetMap = new HashMap<>();

    public TweetCounts() {
    }

    public void recordTweet(String tweetName, int time) {
        List<Tweet> tweets = tweetMap.get(tweetName);
        if (tweets == null) tweetMap.put(tweetName, tweets = new ArrayList<>());
        tweets.add(new Tweet(tweetName, time));
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Tweet> tweets = tweetMap.get(tweetName);
        if (tweets == null) tweets = new ArrayList<>();
        int delta = freq.equals("minute") ? 60 : freq.equals("hour") ? 3600 : 3600 * 24;
        int barrel = (int) Math.ceil((endTime + 1 - startTime) / ((float) delta));
        int[] results = new int[barrel];
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < tweets.size(); i++) {
            Tweet tweet = tweets.get(i);
            int index = (tweet.time - startTime) / delta;
            if (tweet.time >= startTime
                    && index < barrel
                    && tweet.time < Math.min(startTime + (delta * (index + 1)), endTime + 1)) {
                results[index]++;
            }
        }
        for (int result : results) resultList.add(result);
        return resultList;
    }

    public class Tweet {
        public String tweetName;
        public int time;

        public Tweet(String tweetName, int time) {
            this.tweetName = tweetName;
            this.time = time;
        }
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */

class Test {
    public static void main(String[] args) {
        TweetCounts tweetCounts = new TweetCounts();
        tweetCounts.recordTweet("tweet0", 33);
        tweetCounts.recordTweet("tweet1", 89);
        tweetCounts.recordTweet("tweet2", 99);
        tweetCounts.recordTweet("tweet3", 53);
        tweetCounts.recordTweet("tweet4", 3);
        tweetCounts.getTweetCountsPerFrequency("hour", "tweet0", 89, 3045);
    }
}