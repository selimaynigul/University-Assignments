
/**
 * @author Selim Aynigül
 */

package package2;

import java.util.LinkedList;

public class Post {
    
    private int postId;
    private String content;
    private LinkedList<Comment> comments;
    private LinkedList<Like> likes;
    private int commentCount;
    private int likeCount;

    /**
     * 
     * @param postId
     * @param content
     */
    public Post(int postId, String content) {
        this.postId = postId;
        this.content = content;
        this.commentCount = 0;
        this.likeCount = 0;
        this.comments = new LinkedList<>();
        this.likes = new LinkedList<>();
    }

    public int getCommentCount() {
        return commentCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public int getPostId() {
        return postId;
    }

    public String getContent() {
        return content;
    }

    public LinkedList<Comment> getComments() {
        return comments;
    }

    public LinkedList<Like> getLikes() {
        return likes;
    }

    /**
     * Add like into likes array
     * 
     * @param like this like will be added
     * @param account account owner who liked - parameter needed to get username info to add history
     * @param account2 post owner - parameter needed to get username info to add history
     *  
     */
    public void addLike(Like like, Account account, Account account2) {
        System.out.print("\nLiking a post . . .");
        likes.add(like);
        likeCount++;
        account.addtoHistory("You liked "+ account2.getUsername() + "'s post id: " + postId);
    }

    /**
     * Add comment into comment array
     * 
     * @param comment this comment will be added
     * @param account account owner who commented - parameter needed to get username info to add history
     * @param account2 post owner - parameter needed to get username info to add history
     */
    public void addComment(Comment comment, Account account, Account account2) {
        System.out.println("\nAdding a comment on a post . . .");
        comments.add(comment);
        commentCount++;
        account.addtoHistory("You commented "+ account2.getUsername() + "'s post id: " + postId);
    }
    /**
     * Remove like from likes array
     * 
     * @param like this like will be removed
     * @param account account owner who unliked - parameter needed to get username info to add history
     * @param account2 post owner - parameter needed to get username info to add history 
     */
    public void unlike(Like like, Account account, Account account2) {
        System.out.print("\nUnliking a post . . .");
        if(likes.contains(like)) {
            likes.remove(like);
            likeCount--;
            account.addtoHistory("You unliked " + account2.getUsername() + "'s post id: " + postId);
            return;
        }
        System.out.println("ERROR: You did NOT like the post!");
    }

    /**
     * Remove comment from comment array
     * 
     * @param comment this comment will be removed
     * @param account account owner who uncommented - parameter needed to get username info to add history
     * @param account2 post owner - parameter needed to get username info to add history
     */
    public void uncomment(Comment comment, Account account, Account account2) {
        System.out.println("\nRemoving a comment on a post . . .");
        if(comments.contains(comment)) {
            comments.remove(comment);
            commentCount--;
            account.addtoHistory("You uncommented "+ account2.getUsername() + "'s post id: " + postId);
            return;
        }
        System.out.println("ERROR: You did NOT comment this!");
    }
}

