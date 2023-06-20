/**
 * @author Selim Aynigül
 */

package package1;

public class Message {

    private int messageId;
    private int senderId;
    private int receiverId;
    private String content;

    /**
     * 
     * @param messageId 
     * @param senderId
     * @param receiverId
     * @param content
     */
    public Message(int messageId, int senderId, int receiverId, String content) {
        this.messageId = messageId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
    }

    public int getMessageId() {
        return messageId;
    }
    
    public int getSenderId() {
        return senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public String getContent() {
        return content;
    }

}
