/**
 * @author Selim Aynigul
 */
package package1;

import java.util.ArrayList;

public class TestClass4 {

    public static void main(String[] args) {

        /* * * * Scenario 1 * * * */
        System.out.println("\n********************************************");
        System.out.println("                 SCENARIO 4                  ");
        System.out.println("********************************************");

        Account gizemsungu = new Account(1, "gizemsungu", "19.06.1992", "istanbul");
        Account sibelgulmez = new Account(2, "sibelgulmez", "04.01.1995", "bursa");
        Account gokhankaya = new Account(3, "gokhankaya", "24.11.1985", "yalova");
        Account account4 = new Account(4, "account4", "19.06.1992", "ankara");
        Account account5 = new Account(5, "account5", "04.01.1995", "mersin");
        Account account6 = new Account(6, "account6", "24.11.1985", "denizli");
        Account account7 = new Account(7, "account7", "19.06.1992", "karabük");
        Account account8 = new Account(8, "account8", "04.01.1995", "sivas");
        Account account9 = new Account(9, "account9", "24.11.1985", "rize");
        Account account10 = new Account(10, "account10", "19.06.1992", "diyarbakır");
        ArrayList<Account> accounts = new ArrayList<Account>();
        accounts.add(gizemsungu);
        accounts.add(sibelgulmez);
        accounts.add(gokhankaya);
        accounts.add(account4);
        accounts.add(account5);
        accounts.add(account6);
        accounts.add(account7);
        accounts.add(account8);
        accounts.add(account9);
        accounts.add(account10);

        // testing follow - unfollow
        System.out.println("\n********************************************");
        System.out.println("          TESTING FOLLOW - UNFOLLOW           ");
        System.out.println("********************************************\n\n");
        gokhankaya.login(accounts);
        gokhankaya.follow(gokhankaya);
        gokhankaya.follow(account6);
        gokhankaya.follow(account7);
        gokhankaya.follow(account8);
        gokhankaya.follow(account9);
        gokhankaya.follow(account10);
        gokhankaya.follow(gizemsungu);
        gokhankaya.viewProfile(gokhankaya);
        gokhankaya.unfollow(account8);
        gokhankaya.viewProfile(gokhankaya);
        gokhankaya.unfollow(account7);
        gokhankaya.viewProfile(gokhankaya);
        gokhankaya.logout();

        // testing block - unblock
        System.out.println("\n********************************************");
        System.out.println("          TESTING BLOCK - UNBLOCK           ");
        System.out.println("********************************************\n\n");
        gizemsungu.login(accounts);
        gizemsungu.follow(gokhankaya);
        gizemsungu.follow(sibelgulmez);
        gizemsungu.follow(account7);
        gizemsungu.follow(account10);
        gizemsungu.viewProfile(gokhankaya);
        gizemsungu.viewProfile(gizemsungu);
        gizemsungu.block(gokhankaya);
        gizemsungu.block(sibelgulmez);
        gizemsungu.viewProfile(gokhankaya);
        gizemsungu.viewProfile(gizemsungu);
        gizemsungu.logout();
        gokhankaya.login(accounts);
        gokhankaya.follow(gizemsungu);
        gokhankaya.viewProfile(gizemsungu);
        gokhankaya.logout();
        gizemsungu.login(accounts);
        gizemsungu.unblock(gokhankaya);
        gizemsungu.logout();
        gokhankaya.login(accounts);
        gokhankaya.follow(gizemsungu);
        gokhankaya.viewProfile(gizemsungu);
        gokhankaya.viewProfile(gokhankaya);
        gokhankaya.logout();
    
        // testing unlike - uncomment
        System.out.println("\n********************************************");
        System.out.println("          TESTING COMMENT - UNCOMMENT        ");
        System.out.println("********************************************\n\n");
        account4.login(accounts);
        Post post1 = new Post(1, "Nice day!");
        account4.addPost(post1);
        account4.logout();
        sibelgulmez.login(accounts);
        Like like1 = new Like(1, sibelgulmez.getAccountId(), post1.getPostId());
        post1.addLike(like1, sibelgulmez, account4);
        Comment comment1 = new Comment(2, sibelgulmez.getAccountId(), post1.getPostId(), "Really!");
        post1.addComment(comment1, sibelgulmez, account4);
        sibelgulmez.viewProfile(account4);
        sibelgulmez.viewPosts(account4);
        sibelgulmez.viewInteractions(account4, accounts);
        post1.unlike(like1, sibelgulmez, account4);
        post1.uncomment(comment1, sibelgulmez, account4);
        sibelgulmez.viewInteractions(account4, accounts);

        // testing showing history
        System.out.println("\n********************************************");
        System.out.println("          TESTING SHOWING HISTORY           ");
        System.out.println("********************************************\n\n");
        sibelgulmez.showHistory();
        Message message1 = new Message(1, 2, 6, "what's up");
        sibelgulmez.sendMessage(message1, account6);
        sibelgulmez.follow(account6);
        sibelgulmez.sendMessage(message1, account6);
        sibelgulmez.showHistory();
        sibelgulmez.logout();
        account6.login(accounts);
        account6.checkInbox();
        account6.checkOutbox();
        account6.viewInbox(accounts);
        account6.follow(account4);
        account6.viewInteractions(account5, accounts);
    }
}


