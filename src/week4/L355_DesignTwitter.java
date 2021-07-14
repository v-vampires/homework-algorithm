package week4;


import java.util.*;

public class L355_DesignTwitter {
    public static void main(String[] args) {
        Twitter twitter = new L355_DesignTwitter().new Twitter();
        twitter.postTweet(1, 1);

        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(2, 1);
        System.out.println(twitter.getNewsFeed(2));
        twitter.unfollow(2, 1);
        System.out.println(twitter.getNewsFeed(2));

    }

    class Twitter {

        private Map<Integer, List<Tweet>> tweetMap;//每一个用户发的tweet,由于没有删除，链表顺序就是发布的顺序
        private Map<Integer, Set<Integer>> follows;//用户关注了谁

        /**
         * Initialize your data structure here.
         */
        public Twitter() {
            tweetMap = new HashMap<>();
            follows = new HashMap<>();
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            List<Tweet> list = tweetMap.get(userId);
            if (list == null) {
                list = new ArrayList<>();
                tweetMap.put(userId, list);
            }
            list.add(new Tweet(tweetId, System.nanoTime()));
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            final List<Tweet> tweets = tweetMap.get(userId);
            final PriorityQueue<Tweet> queue = new PriorityQueue<>();
            System.out.println();
            getLastN(queue, tweets, 10);
            final Set<Integer> followers = follows.get(userId);
            if(followers != null){
                for (Integer follower : followers) {
                    final List<Tweet> tw = tweetMap.get(follower);
                    getLastN(queue, tw, 10);
                }
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < 10 && !queue.isEmpty(); i++) {
                res.add(queue.poll().id);
            }
            return res;
        }
        //取倒数的n个
        private void getLastN(PriorityQueue<Tweet> queue, List<Tweet> tweets, int n) {
            if (tweets != null && n != 0) {
                n = Math.min(n, tweets.size());
                for (int i = 1; i <= n; i++) {
                    queue.offer(tweets.get(tweets.size() - i));
                }
            }
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            Set<Integer> followees = follows.get(followerId);
            if (followees == null) {
                followees = new HashSet<>();
                follows.put(followerId, followees);
            }
            followees.add(followeeId);
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            Set<Integer> followees = follows.get(followerId);
            if (followees != null && followees.contains(followeeId)) {
                followees.remove(followeeId);
            }
        }

        class Tweet implements Comparable<Tweet> {
            int id;
            long ts;

            public Tweet(int id, long ts) {
                this.id = id;
                this.ts = ts;
            }

            @Override
            public int compareTo(Tweet o) {
                return (int) (o.ts - this.ts);
            }

            @Override
            public String toString() {
                return "Tweet{" +
                        "id=" + id +
                        ", ts=" + ts +
                        '}';
            }
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

}