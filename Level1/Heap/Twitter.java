package Level1.Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashSet;

class Twitter {
    class Post{
        int tweetId;
        int time;
        Post(int tweetId, int time){
            this.tweetId = tweetId;
            this.time = time;
        }
    }
    HashMap<Integer, ArrayList<Post>> users = new HashMap<>();
    HashMap<Integer, Set<Integer>> followers = new HashMap<>();
    int time = 0;
    public Twitter() {
        users = new HashMap<>();
        followers = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Post post = new Post(tweetId, time++);
        if(!users.containsKey(userId)){
            ArrayList<Post> list = new ArrayList<>();
            list.add(post);

            users.put(userId, list);
        }else{
            users.get(userId).add(post);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Post> pq = new PriorityQueue<>((a,b) -> b.time - a.time);
        for(Post post : users.getOrDefault(userId, new ArrayList<>())){
            pq.add(post);
        }
        for(int follower : followers.getOrDefault(userId, new HashSet<>())){
            for(Post post:users.getOrDefault(follower, new ArrayList<>())){
                pq.add(post);
            }
        }
        while(!pq.isEmpty() && ans.size() <10){
            Post post = pq.remove();
            ans.add(post.tweetId);
        }
        return ans;
       
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followers.containsKey(followerId)){
            Set<Integer> list = new HashSet<>();
            list.add(followeeId);
            followers.put(followerId, list);
        }else{
            Set<Integer> list = followers.get(followerId);
            list.add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> list = followers.getOrDefault(followerId, new HashSet<>());
        if(list.contains(followeeId))
            list.remove(followeeId);
        if(list.size()==0){
            followers.remove(followerId);
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