/**
 * @author Selim Aynigul
 */
package package1;

public class Interaction {
    
    private int interactionId;
    private int accountId;
    private int postId;

    /**
     * 
     * @param interactionId
     * @param accountId
     * @param postId
     */
    Interaction(int interactionId, int accountId, int postId) {
        this.interactionId = interactionId;
        this.accountId = accountId;
        this.postId = postId;
    }

    public int getGetInteractionId() {
        return interactionId;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getPostId() {
        return postId;
    }
}
