/**
 * @author Selim Aynigül
 */

package homework1;

public class Post {

    private int postId;
    private String content;
    private Comment[] comments;
    private Like[] likes;
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
        this.comments = new Comment[10];
        this.likes = new Like[10];
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

    public Comment[] getComments() {
        return comments;
    }

    public Like[] getLikes() {
        return likes;
    }

    /**
     * Add like into likes array
     * 
     * @param like 
     *  
     */
    public void addLike(Like like) {
        System.out.print("\nLiking a post . . .");
        likes[likeCount] = like;
        likeCount++;
    }

    /**
     * Add comment into comment array
     * 
     * @param comment
     */
    public void addComment(Comment comment) {
        System.out.println("Adding a comment on a post . . .");
        comments[commentCount] = comment;
        commentCount++;
    }
}
