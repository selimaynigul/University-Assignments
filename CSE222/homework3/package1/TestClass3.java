/**
 * @author Selim Aynigul
 */
package package1;

import java.util.ArrayList;

public class TestClass3 {

    public static void main(String[] args) {

         /* * * * Scenario 1 * * * */
         System.out.println("\n********************************************");
         System.out.println("                 SCENARIO 1                 ");
         System.out.println("********************************************");
 
         /* Step 1 */
         System.out.println("\nStep 1... Creating accounts...");
         Account gizemsungu = new Account(1, "gizemsungu", "19.06.1992", "istanbul");
         Account sibelgulmez = new Account(2, "sibelgulmez", "04.01.1995", "bursa");
         Account gokhankaya = new Account(3, "gokhankaya", "24.11.1985", "yalova");
         ArrayList<Account> accounts = new ArrayList<Account>();
         accounts.add(gizemsungu);
         accounts.add(sibelgulmez);
         accounts.add(gokhankaya);
 
         /* Step 2-5 */
         System.out.print("\nStep 2... ");
         sibelgulmez.login(accounts);
         Post post1 = new Post(1, "I like Java.");
         System.out.print("\nStep 3... ");
         sibelgulmez.addPost(post1);
         Post post2 = new Post(2, "Java the coffee...");
         sibelgulmez.addPost(post2);
         System.out.print("\n\nStep 4... ");
         
         sibelgulmez.follow(gizemsungu);
         sibelgulmez.follow(gokhankaya);
 
         System.out.print("\n\nStep 5... ");
         sibelgulmez.logout();
 
         /* Step 6-13 */
         System.out.print("\nStep 6... ");
         gokhankaya.login(accounts);
         System.out.print("\nStep 7... ");
         gokhankaya.viewProfile(sibelgulmez);
         System.out.print("\nStep 8... ");
         gokhankaya.viewPosts(sibelgulmez);
         Like like1 = new Like(1, gokhankaya.getAccountId(), post1.getPostId());
         System.out.print("\nStep 9... ");
         post1.addLike(like1, gokhankaya, sibelgulmez);
         Comment comment1 = new Comment(2, gokhankaya.getAccountId(), post1.getPostId(), "Me too!");
         System.out.print("\n\nStep 10... ");
         post1.addComment(comment1, gokhankaya, sibelgulmez);
         System.out.print("\nStep 11... ");
         gokhankaya.follow(sibelgulmez);
         gokhankaya.follow(gizemsungu);
         Message message1 = new Message(1, 3, 1, "This homework is too easy!");
         System.out.print("\n\nStep 12... ");
         gokhankaya.sendMessage(message1, gizemsungu);
         System.out.print("\nStep 13... ");
         gokhankaya.logout();
 
         /* Step 14-22 */
         System.out.print("\nStep 14... ");
         gizemsungu.login(accounts);
         System.out.print("\nStep 15... ");
         gizemsungu.checkOutbox();
         System.out.print("\nStep 16... ");
         gizemsungu.checkInbox();
         System.out.print("\nStep 17... ");
         gizemsungu.viewInbox(accounts);
         System.out.print("\nStep 18... ");
         gizemsungu.viewProfile(sibelgulmez);
         System.out.print("\nStep 19... ");
         gizemsungu.viewPosts(sibelgulmez);
         System.out.print("\nStep 20... ");
         gizemsungu.viewInteractions(sibelgulmez, accounts);
         System.out.print("\nStep 21... ");
         Like like2 = new Like(3, gizemsungu.getAccountId(), post1.getPostId());
         post1.addLike(like2, gizemsungu, gizemsungu);
         Like like3 = new Like(4, gizemsungu.getAccountId(), post2.getPostId());
         post2.addLike(like3, gizemsungu, gizemsungu);   
         System.out.print("\n\nStep 22.. ");
         gizemsungu.viewInteractions(sibelgulmez, accounts);
         
 
         /* * * * Scenario 2 * * * */
         System.out.println("\n********************************************");
         System.out.println("                 SCENARIO 2                 ");
         System.out.println("********************************************");
 
         /* Step 1 */
         System.out.print("\nStep 23... ");
         Post post3 = new Post(3, "This is post3!");
         gizemsungu.addPost(post3);
         Post post4 = new Post(4, "This is post4!");
         gizemsungu.addPost(post4);
         System.out.print("\n\nStep 24... ");
         gizemsungu.logout();
         
         /* Step 2 */
         System.out.print("\nStep 25... ");
         sibelgulmez.login(accounts);
         System.out.print("\nStep 26... ");
         sibelgulmez.viewProfile(gizemsungu);
         Like like4 = new Like(5, sibelgulmez.getAccountId(), post1.getPostId());
         System.out.print("\nStep 27... ");
         post1.addLike(like4, sibelgulmez, gizemsungu);
         System.out.print("\n\nStep 28... ");
         sibelgulmez.logout();
 
         /* Step 3 */
         System.out.print("\nStep 29... ");
         gokhankaya.login(accounts);
         System.out.print("\nStep 30... ");
         gokhankaya.viewProfile(gizemsungu);
         Comment comment2 = new Comment(6, gokhankaya.getAccountId(), post2.getPostId(), "Nice!");
         System.out.print("\nStep 31... ");
         post2.addComment(comment2, gokhankaya, gizemsungu);
         Message message2 = new Message(2, 3, 1, "Hello!");
         System.out.print("\nStep 32... ");
         gokhankaya.sendMessage(message2, gizemsungu);
         System.out.print("\nStep 33... ");
         gokhankaya.logout();
 
         /* Step 4 */
         System.out.print("\nStep 34... ");
         gizemsungu.login(accounts);
         System.out.print("\nStep 35... ");
         gizemsungu.viewProfile(gizemsungu);
         System.out.print("\nStep 36... ");
         gizemsungu.viewInbox(accounts);
        

        /* * * * Scenario 3 * * * */
        System.out.println("\n********************************************");
        System.out.println("                 SCENARIO 3                 ");
        System.out.println("********************************************\n");

        /* Step 1 */
        System.out.print("\nStep 37... ");
        gizemsungu.block(sibelgulmez);
        System.out.print("\nStep 38... ");
        gizemsungu.logout();

        /* Step 2 */
        System.out.print("\nStep 39... ");
        sibelgulmez.login(accounts);
        Message message3 = new Message(3, 2, 1, "Why did you remove your profile picture?");
        System.out.print("\nStep 40... ");
        sibelgulmez.sendMessage(message3, gizemsungu);
    }
}


