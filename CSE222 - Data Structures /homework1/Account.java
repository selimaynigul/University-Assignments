/**
 * 
 * @author Selim Aynigul
 * 
 */

package homework1;

public class Account 
{
    private int accountId;
    private String username;
    private String birthdate;
    private String location;
    private Post[] posts;
    private Message[] inbox;
    private Message[] outbox;
    private Account[] following;
    private Account[] followers;
    private Account[] blockedAccounts;
    private int blockedAccountsCount;
    private int followingCount;
    private int followersCount;
    private int inboxCount;
    private int outboxCount;
    private int postsCount;
    private boolean isLoggedIn;

    /**
     * Constructor creates an account object
     * 
     * @param accountId
     * @param username
     * @param birthdate
     * @param location
     * 
     */
    public Account(int accountId, String username, String birthdate, String location) {
        this.accountId = accountId;
        this.username = username;
        this.birthdate = birthdate;
        this.location = location;
        this.posts = new Post[10];
        this.inbox = new Message[10];
        this.outbox = new Message[10];
        this.following = new Account[10];
        this.followers = new Account[10];
        this.blockedAccounts = new Account[10];
        this.blockedAccountsCount = 0;
        this.followingCount = 0;
        this.followersCount = 0;
        this.inboxCount = 0;
        this.outboxCount = 0;
        this.postsCount = 0;
        isLoggedIn = false;
        System.out.println("An account with username " +  username + " has been created...");
    }

    /* Getter functions*/
    public boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    public int getFollowingCount() {
        return followingCount;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void increaseFollowersCount() {
        followersCount++;
    }

    public int getInboxCount() {
        return inboxCount;
    }

    public int getOutboxCount() {
        return outboxCount;
    }

    public int getAccountId() {
        return accountId;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getBirthdate() {
        return birthdate;
    }
    
    public String getLocation() {
        return location;
    }
    
    public Post[] getPosts() {
        return posts;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public Message[] getInbox() {
        return inbox;
    }

    public Message[] getOutbox() {
        return outbox;
    }

    public Account[] getFollowing() {
        return following;
    }

    public Account[] getFollowers() {
        return followers;
    }

    public Account[] getBlockedAccounts() {
        return blockedAccounts;
    }

    public int getBlockedAccountsCount() {
        return blockedAccountsCount;
    }

    /**
     * if account is not logged in then change isloggedin variable to true
     * 
     * @param accounts to check if any other account has been logged in 
     */
    public void login(Account[] accounts)
    {
        boolean control = true;
        for(Account account : accounts) {
            if(account != null) {
                if(account.getIsLoggedIn())
                    control = false;
            }
        }
        if(!control) {
            System.out.println("ERROR: You are logged in an another account already...\n");
        }
        else {
            if(!isLoggedIn) {
                isLoggedIn = true;
                System.out.println("Logging into " + username + "'s account...");
            }
            else 
            System.out.println("Already logged in!");
        }
    }

    /**
     * if account is logged in then change isloggedin variable to false
     */
    public void logout() 
    {
        if(isLoggedIn) {
            isLoggedIn = false;
            System.out.println("Logging out from " + username + "'s account...");
        }
        else 
            System.out.println("Already logged out!");
    }
    
    /**
     * add post object into post array
     * 
     * @param post will be added into posts object array
     */
    public void addPost(Post post) 
    { 
        System.out.print("\nSharing a post...");
        if(!isLoggedIn) {
            System.out.println("ERROR: You have to login to execute an operation...\n"); 
            return;
        }
        posts[postsCount] = post;
        postsCount++;
    }
    
    /**
     * print detailed information on the screen 
     * 
     * @param account will be printed on the screen
     */
    public void viewProfile(Account account) 
    {
        System.out.println("Viewing " + account.getUsername() + "'s profile...");
        if(!isLoggedIn) {
            System.out.println("ERROR: You have to login to execute an operation...\n"); 
            return;
        }
        System.out.println("----------------------------");
        System.out.println("User ID: " + account.getAccountId());
        System.out.println("Username: " + account.getUsername());
        System.out.println("Location: " + account.getLocation());
        System.out.println("Birth Date: " + account.getBirthdate());
        System.out.println(account.getUsername() + " is following " + account.getFollowingCount() + " account(s) and has " + account.getFollowersCount() + " followers.");
        
        if(account.getFollowingCount() != 0)
        {
            System.out.print(account.getUsername() + " is folowing: ");
            for (Account followingAccount : account.getFollowing()) {
                if(followingAccount != null)
                System.out.print(followingAccount.getUsername() + " ");
            }
        }
        else {
            System.out.print(account.getUsername() + " follows nobody.");
        }

        if(account.getFollowersCount() != 0)
        {
            System.out.print("\n" + account.getUsername() + "'s followers: ");
            for (Account followerAccount : account.getFollowers()) {
                if(followerAccount != null)
                    System.out.print(followerAccount.getUsername() + " ");
            }
        }
        System.out.println("\n" + account.getUsername() + " has " + account.getPostsCount() + " post(s).");
        System.out.println("----------------------------");
    }
    
    /**
     * Account's posts (if any) will be printed on the screen with detailed information
     * 
     * @param account 
     */
    public void viewPosts(Account account) 
    {
            System.out.println("Viewing " + account.getUsername() + "'s posts...");
            if(!isLoggedIn) {
                System.out.println("ERROR: You have to login to execute an operation...\n"); 
                return;
            }
            System.out.println("----------------------------");
            Post[] posts = account.getPosts();
            if (posts.length == 0) {
                System.out.println("No posts found.");
            } else {
                for (Post post : posts) {
                    if(post != null) {
                        System.out.print("(Post ID: " + post.getPostId() + ") ");
                        System.out.println(account.getUsername() + ": " + post.getContent());
                    }
                }
            }
            System.out.println("----------------------------");
        }
        
    /**
     * Add user into parameters followers array
     * Add parameter into users followings array
     * 
     * @param account will be added into followings array
     */
    public void follow(Account account) 
    {
        System.out.print("\nFollowing " + account.getUsername() + "'s account...");
        if(!isLoggedIn) {
            System.out.println("ERROR: You have to login to execute an operation...\n"); 
            return;
        }
        for(int i = 0; i < followingCount; i++) {
            if(following[i] == account) {
                System.out.println("ERROR: You are already following " + account.getUsername() + "'s account!\n");
                return;
            }
        }
        following[followingCount] = account;
        followingCount++;
        account.followers[account.getFollowersCount()] = this;
        account.increaseFollowersCount();
    }

    /**
     * Add parameter into blockedAccounts array
     * 
     * @param account check if it is blocked
     */
    public void block(Account account) {
        System.out.println("Blocking " + account.getUsername() + "'s account...");
        blockedAccounts[blockedAccountsCount] = account;
        blockedAccountsCount++;
    }
    /**
     * @param message add into inbox array
     */
    public void addMessagetoInbox(Message message) 
    {
        inbox[inboxCount] = message;
        inboxCount++;
    }

    /**
     * 
     * @param message add into outbox array
     */
    public void addMessagetoOutbox(Message message) 
    {
        outbox[outboxCount] = message;
        outboxCount++;
    }

    /**
     * Add message into receivers inbox array
     * Add message into users outbox array
     * 
     * @param message 
     * @param receiver
     */
    public void sendMessage(Message message, Account receiver) 
    {
        System.out.println("Sending a message to " + receiver.getUsername() + "...");
        if(!isLoggedIn) {
            System.out.println("ERROR: You have to login to execute an operation...\n"); 
            return;
        }

        boolean blockControl = true;
        for(int i = 0; i < receiver.getBlockedAccountsCount(); i++) {
            if(receiver.blockedAccounts[i] == this)
                blockControl = false;
        }
        if(!blockControl) {
            System.out.println("ERROR: You can't send message to " + receiver.getUsername() + ", you are BLOCKED!!!");
            return;
        }

        boolean control = false;
        for(int i = 0; i < followingCount; i++) {
            if(following[i].getAccountId() == receiver.getAccountId())
                control = true;
        }
        if(control) {
            addMessagetoOutbox(message);
            receiver.addMessagetoInbox(message);
        }
        else
            System.out.println("ERROR: You have to follow " + receiver.getUsername() + " to send a message...\n");
    }

    /**
     * print number of messages in the inbox array
     */
    public void checkInbox() 
    {
        System.out.println("Checking " + username + "'s inbox...");
        System.out.println("There is " + inboxCount + " messages in the " + username + "'s inbox!");
    }

    /**
     * print number of messages in the outbox array
     */
    public void checkOutbox() 
    {
        System.out.println("Checking " + username + "'s outbox...");
        System.out.println("There is " + outboxCount + " messages in the " + username + "'s outbox!");  
    }

    /**
     * Print messages (if any) in the inbox array
     * 
     * @param accounts will be checked to print senders' usernames
     */
    public void viewInbox(Account[] accounts) 
    {
        System.out.println("Viewing " + username + "'s inbox...");
        if(!isLoggedIn) {
            System.out.println("ERROR: You have to login to execute an operation...\n"); 
            return;
        }
        System.out.println("----------------------------");
        for(int i = 0; i < inboxCount; i++) {
            if(inbox[i] != null) {
                System.out.println("Message ID: " + inbox[i].getMessageId());
                System.out.println("From: " + accounts[inbox[i].getSenderId() - 1].getUsername());
                System.out.println("To: " + username);
                System.out.println("Message: " + inbox[i].getContent());
                System.out.println("----------------------------");
            }
        }
    }

    /**
     * Prints detailed information of account's posts (likes, comments etc.)
     * 
     * @param account 
     * @param accounts will be checked to print senders' usernames
     */
    public void viewInteractions(Account account, Account[] accounts) 
    {    
        System.out.println("Viewing " + account.getUsername() + "'s post interactions...");
        if(!isLoggedIn) {
            System.out.println("ERROR: You have to login to execute an operation...\n"); 
            return;
        }
        Post[] posts = account.getPosts();
        for(int i = 1; i <= posts.length; i++) 
        {
            if(posts[i - 1] != null) {
                System.out.println("----------------------------");
                System.out.println("(PostID: " + i + "): " + posts[i - 1].getContent());
                
                if(posts[i - 1].getLikeCount() == 0)
                    System.out.print("The post has no likes.");
                else 
                {
                    System.out.print("The post was liked by the following account(s): ");
                    Like[] likes = posts[i - 1].getLikes();
                    for(int j = 0; j <  posts[i - 1].getLikeCount(); j++) 
                        System.out.print(accounts[likes[j].getAccountId() - 1].getUsername() + " "); 
                }
                System.out.println("\nThe post has " + posts[i - 1].getCommentCount() + " comment(s)...");
                Comment[] comments = posts[i - 1].getComments();
                for(int j = 1; j <= posts[i - 1].getCommentCount(); j++) 
                {
                    if(comments[j - 1] != null)
                    {
                        System.out.print("Comment " + j + ": ");
                        System.out.println(accounts[comments[j - 1].getAccountId() - 1].getUsername() + " said \"" + comments[j - 1].getContent() + "\""); 
                    }
                }
            }
        }
        System.out.println("----------------------------");
    }
}
