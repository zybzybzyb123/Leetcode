/**
 * 本次就简单保存了所有的tweet, 针对最近10条进行了简单的过滤
 * 可以维护多用户的tweet进行多路合并
 */

class Twitter {

    private static class Info {
        private int tweetId;
        private int userId;
        private int timestamp;
    }

    private Map<Integer, Set<Integer>> user2FollowMap;
    private Map<Integer, List<Integer>> user2RecentTweetMap;
    private Set<Info> postTweetSet;
    private int id;

    /** Initialize your data structure here. */
    public Twitter() {
        id = 0;
        user2FollowMap = new HashMap<>();
        user2RecentTweetMap = new HashMap<>();
        postTweetSet = new TreeSet<>(Comparator.comparing(info -> info.id, Comparator.reverseOrder()));
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Info info = new Info();
        info.timestamp = ++id;
        info.tweetId = tweetId;
        info.userId = userId;
        postTweetSet.add(info);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followSet = user2FollowMap.getOrDefault(userId, new HashSet<>());
        followSet.add(userId);
        List<Integer> recentTweetIds =
                postTweetSet
                        .stream()
                        .filter(info -> followSet.contains(info.userId))
                        .limit(10)
                        .map(info -> info.tweetId)
                        .collect(Collectors.toList());
        return recentTweetIds;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> followSet = user2FollowMap.getOrDefault(followerId, new HashSet<>());
        if (followSet.add(followeeId)) {
            user2FollowMap.put(followerId, followSet);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followSet = user2FollowMap.getOrDefault(followerId, new HashSet<>());
        if (followSet.remove(followeeId)) {
            user2FollowMap.put(followerId, followSet);
        }
    }
}