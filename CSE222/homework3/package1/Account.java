
/**
 * 
 * @author Selim Aynigul
 * 
 */
package package1;
import java.util.ArrayList;

public class Account 
{
    private int accountId;
    private String username;
    private String birthdate;
    private String location;
    private ArrayList<Post> posts;
    private ArrayList<Message> inbox;
    private ArrayList<Message> outbox;
    private ArrayList<Account> following;
    private ArrayList<Account> followers;
    private ArrayList<Account> blockedAccounts;
    private ArrayList<String> history;
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
        this.posts = new ArrayList<>();
        this.inbox = new ArrayList<>();
        this.outbox = new ArrayList<>();
        this.following = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.blockedAccounts = new ArrayList<>();
        this.history = new ArrayList<>();
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
    
    public ArrayList<Post> getPosts() {
        return posts;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public ArrayList<Message> getInbox() {
        return inbox;
    }

    public ArrayList<Message> getOutbox() {
        return outbox;
    }

    public ArrayList<Account> getFollowing() {
        return following;
    }

    public ArrayList<Account> getFollowers() {
        return followers;
    }

    public ArrayList<Account> getBlockedAccounts() {
        return blockedAccounts;
    }

    public int getBlockedAccountsCount() {
        return blockedAccountsCount;
    }


    // Other functions

    /**
     * if account is not logged in then change isloggedin variable to true
     * 
     * @param accounts to check if any other account has been logged in 
     */
    public void login(ArrayList<Account> accounts) {
        if(isLoggedIn) {
            System.out.println("ERROR: You already logged in!");
            return;
        }
        for(Account account : accounts) {
            if(account.getIsLoggedIn()) {
                System.out.println("ERROR: You logged in an another account already...\n");
                return;
            }
        }       
        isLoggedIn = true;
        System.out.println("Logging into " + username + "'s account...");
        addtoHistory("You logged in");
    }

    /**
     * if account is logged in then change isloggedin variable to false
     */
    public void logout() {
        if(isLoggedIn) {
            isLoggedIn = false;
            System.out.println("\nLogging out from " + username + "'s account...");
            addtoHistory("You logged out");
        }
        else 
            System.out.println("Already logged out!");
    }

    /**
     * if logged in return true, otwerwise return false
     * 
     * @param isLoggedIn to check if logged in before
     * @return boolean
     */
    public boolean checkLogin(boolean isLoggedIn) {
        if(!isLoggedIn) {
            System.out.println("ERROR: You have to login to execute an operation...\n"); 
            return false;
        }
        return true;
    }

    /**
     * add post object into post array
     * 
     * @param post will be added into posts object array
     */
    public void addPost(Post post) { 
        System.out.print("\nSharing a post...");
        // check if logged in
        if(!checkLogin(isLoggedIn)) return;

        posts.add(post);
        postsCount++;
        addtoHistory("You shared a post");
    }
    
    /**
     * print detailed information on the screen 
     * 
     * @param account will be printed on the screen
     */
    public void viewProfile(Account account) {
        System.out.println("\nViewing " + account.getUsername() + "'s profile...");
        // check if logged in
        if(!checkLogin(isLoggedIn)) return;

        // check if blocked
        if(account.blockedAccounts.contains(this)) {
            System.out.println("\nERROR: You can't view " + account.getUsername() + "'s profile', you are BLOCKED!!!");
            return;
        }
        // if not blocked print profile information
        System.out.println("----------------------------");
        System.out.println("User ID: " + account.getAccountId());
        System.out.println("Username: " + account.getUsername());
        System.out.println("Location: " + account.getLocation());
        System.out.println("Birth Date: " + account.getBirthdate());
        System.out.println(account.getUsername() + " is following " + account.getFollowingCount() + " account(s) and has " + account.getFollowersCount() + " followers.");
        
        // print following accounts
        if(account.getFollowingCount() != 0) {
            System.out.print(account.getUsername() + " is folowing: ");
            for (Account followingAccount : account.getFollowing()) {
            //    if(followingAccount != null) 
                    System.out.print(followingAccount.getUsername() + " ");
            }
        }
        else {
            System.out.print(account.getUsername() + " follows nobody.");
        }
        // print followers accounts
        if(account.getFollowersCount() != 0) {
            System.out.print("\n" + account.getUsername() + "'s followers: ");
            for (Account followerAccount : account.getFollowers()) 
                    System.out.print(followerAccount.getUsername() + " ");
        }
        else {
            System.out.print("\n" + account.getUsername() + " has no followers.");
        }
        System.out.println("\n" + account.getUsername() + " has " + account.getPostsCount() + " post(s).");
        System.out.println("----------------------------");
        addtoHistory("You viewed " + account.getUsername() + "'s profile");
    }
    
    /**
     * Account's posts (if any) will be printed on the screen with detailed information
     * 
     * @param account 
     */
    public void viewPosts(Account account) {
            System.out.println("Viewing " + account.getUsername() + "'s posts...");
            // check if logged in
            if(!checkLogin(isLoggedIn)) return;

            // check if blocked
            if(account.blockedAccounts.contains(this)) {
                System.out.println("\nERROR: You can't view posts of " + account.getUsername() + ", you are BLOCKED!!!");
                return;
            }
            // if not blocked print posts information
            System.out.println("----------------------------");
            ArrayList<Post> posts = account.getPosts();
            if (posts.size() == 0) {
                System.out.println("No posts found.");
            } else {
                for (Post post : posts) {
                    System.out.print("(Post ID: " + post.getPostId() + ") ");
                    System.out.println(account.getUsername() + ": " + post.getContent());
                }
            }
            System.out.println("----------------------------");
            addtoHistory("You viewed " + account.getUsername() + "'s posts...");
        }
        
     /**
     * Prints detailed information of account's posts (likes, comments etc.)
     * 
     * @param account 
     * @param accounts will be checked to print senders' usernames
     */
    public void viewInteractions(Account account, ArrayList<Account> accounts) {    
        System.out.println("\nViewing " + account.getUsername() + "'s post interactions...");
        // check if logged in
        if(!checkLogin(isLoggedIn)) return;

        // check if blocked
        if(account.blockedAccounts.contains(this)) {
            System.out.println("\nERROR: You can't view interactions of " + account.getUsername() + ", you are BLOCKED!!!");
            return;
        }
        ArrayList<Post> posts = account.getPosts();
        if(posts.size() == 0) {
            System.out.println("No posts found!");
            return;
        } 
        // if not blocked and have posts, print interaction information
        for(int i = 1; i <= posts.size(); i++) {
            System.out.println("----------------------------");
            System.out.println("(PostID: " + i + "): " + posts.get(i - 1).getContent());
    
            // print likes
            if(posts.get(i - 1).getLikeCount() == 0)
                System.out.print("The post has no likes.");
            else {
                System.out.print("The post was liked by the following account(s): ");
                ArrayList<Like> likes = posts.get(i - 1).getLikes();
                for(int j = 0; j <  posts.get(i - 1).getLikeCount(); j++) 
                    System.out.print(accounts.get(likes.get(j).getAccountId() - 1).getUsername() + " "); 
            }
            // print comments
            System.out.println("\nThe post has " + posts.get(i - 1).getCommentCount() + " comment(s)...");
            ArrayList<Comment> comments = posts.get(i - 1).getComments();
            for(int j = 1; j <= posts.get(i - 1).getCommentCount(); j++) {
                System.out.print("Comment " + j + ": ");
                System.out.println(accounts.get(comments.get(j - 1).getAccountId() - 1).getUsername() + " said \"" + comments.get(j - 1).getContent() + "\""); 
            }
        }
        System.out.println("----------------------------");
        addtoHistory("You viewed " + account.getUsername() + "'s interactions");
    }    
   
    /**
     * Add user into parameters followers array
     * Add parameter into users followings array
     * 
     * @param account will be added into followings array
     */
    public void follow(Account account) {
        System.out.print("\nFollowing " + account.getUsername() + "'s account...");
        // check if logged in
        if(!checkLogin(isLoggedIn)) return;

        // check if blocked
        if(account.blockedAccounts.contains(this)) {
            System.out.println("\nERROR: You can't follow " + account.getUsername() + ", you are BLOCKED!!!");
            return;
        }
        // check if already following
        if(following.contains(account)) {
            System.out.println("\nERROR: You are already following " + account.getUsername() + "'s account!\n");
            return;
        }
        // check if an account trying to follow themself
        if(account == this) {
            System.out.println("\nERROR: You can't follow yourself!");
            return;
        }
        // if not blocked and not following, execute the operation
        following.add(account);
        followingCount++;
        account.followers.add(this);
        account.increaseFollowersCount();
        addtoHistory("You followed " + account.getUsername());
    }

    /**
     * remove account from followings list
     * also remove this from account's followers list
     * 
     * @param account will be removed
     */
    public void unfollow(Account account) {
        System.out.print("\nUnfollowing " + account.getUsername() + "'s account...");
        // check if logged in
        if(!checkLogin(isLoggedIn)) return;

        // check if following to unfollow
        if(following.contains(account)) {
            following.remove(account);
            followingCount--;
            account.followers.remove(this);
            account.decreaseFollowersCount();
            addtoHistory("You unfollowed " + account.getUsername());
            return;
        }
        System.out.println("ERROR: You do NOT follow them...");
    }
  
    public void increaseFollowersCount() {
        followersCount++;
    }

    public void decreaseFollowersCount() {
        followersCount--;
    }

    public void decreaseFollowingCount() {
        followingCount--;
    }
 
    /**
     * Add parameter into blockedAccounts array
     * 
     * @param account check if it is blocked
     */
    public void block(Account account) {
        System.out.println("Blocking " + account.getUsername() + "'s account...");
        // check if logged in
        if(!checkLogin(isLoggedIn)) return;

        // check if blocked
        if(blockedAccounts.contains(account)) {
            System.out.println("ERROR: You already blocked " + account.getUsername() + "'s account!\n");
            return;
        }
        // remove from both accounts' following and followers lists
        if(following.contains(account)) {
            following.remove(account);
            followingCount--;
            account.followers.remove(this);
            account.decreaseFollowersCount();
        }
        if(followers.contains(account)) {
            followers.remove(account);
            followersCount--;
            account.following.remove(this);
            account.decreaseFollowingCount();
        }
        blockedAccounts.add(account);
        blockedAccountsCount++;
        addtoHistory("You blocked " + account.getUsername());
    }

    /**
     * remove account from blocked accounts list
     * 
     * @param account will be removed 
     */
    public void unblock(Account account) {
        System.out.println("Unblocking " + account.getUsername() + "'s account...");
        // check if logged in
        if(!checkLogin(isLoggedIn)) return;

        // check if blocked to unblock
        if(blockedAccounts.contains(account)) {
            blockedAccounts.remove(account);
            addtoHistory("You unblocked" + account.getUsername());
            return;
        }
        System.out.println("ERROR: You did NOT blocked " + account.getUsername() + "'s account!\n");
    }

    /**
     * @param message add into inbox array
     */
    public void addMessagetoInbox(Message message) {
        inbox.add(message);
        inboxCount++;
    }

    /**
     * 
     * @param message add into outbox array
     */
    public void addMessagetoOutbox(Message message) {
        outbox.add(message);
        outboxCount++;
    }

    /**
     * Add message into receivers inbox array
     * Add message into users outbox array
     * 
     * @param message  
     * @param receiver the account owner to send the message
     */
    public void sendMessage(Message message, Account receiver) {
        System.out.println("\nSending a message to " + receiver.getUsername() + "...");
        // check if logged in
        if(!checkLogin(isLoggedIn)) return;

        // check if blocked
        if(receiver.blockedAccounts.contains(this)) {
            System.out.println("ERROR: You can't send message to " + receiver.getUsername() + ", you are BLOCKED!!!");
            return;
        }
        // check if following
        if(following.contains(receiver)) {
            addMessagetoOutbox(message);
            receiver.addMessagetoInbox(message);
            addtoHistory("You sent a message to " + receiver.getUsername());
        }
        else
            System.out.println("ERROR: You have to follow " + receiver.getUsername() + " to send a message...\n");
    }

    /**
     * print number of messages in the inbox array
     */
    public void checkInbox() {
        System.out.println("Checking " + username + "'s inbox...");
        System.out.println("There is " + inboxCount + " messages in the " + username + "'s inbox!");
        addtoHistory("You checked your inbox");
    }

    /**
     * print number of messages in the outbox array
     */
    public void checkOutbox() {
        System.out.println("Checking " + username + "'s outbox...");
        System.out.println("There is " + outboxCount + " messages in the " + username + "'s outbox!");  
        addtoHistory("You checked your outbox");
    }

    /**
     * Print messages (if any) in the inbox array
     * 
     * @param accounts will be checked to print senders' usernames
     */
    public void viewInbox(ArrayList<Account> accounts) {
        System.out.println("Viewing " + username + "'s inbox...");
        // check if logged in 
        if(!checkLogin(isLoggedIn)) return;

        System.out.println("----------------------------");
        for(int i = 0; i < inbox.size(); i++) {
                System.out.println("Message ID: " + inbox.get(i).getMessageId());
                System.out.println("From: " + accounts.get(inbox.get(i).getSenderId() - 1).getUsername());
                System.out.println("To: " + username);
                System.out.println("Message: " + inbox.get(i).getContent());
                System.out.println("----------------------------");
        }
        addtoHistory("You viewed your inbox");
    }

    /**
     * print all the executions an account's done
     */
    public void showHistory() {
        System.out.println("Viewing " + username + "'s history...");
        // check if logged in
        if(!checkLogin(isLoggedIn)) return;
        
        // check if history is empty 
        if(history.size() == 0) {
            System.out.println("\nYour history is empty...");
            return;
        }
        // if not empty print history
        System.out.println("----------------------------");
        for(String str : history)  
            System.out.println(str);
        System.out.println("----------------------------\n"); 	
        addtoHistory("You viewed your history");	   
    }

    /**
     * add the operation into history list
     * 
     * @param event will be added to history
     */
    public void addtoHistory(String event) {
        history.add(event);
    }
}





 





