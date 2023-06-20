/**
 * 
 * @author Selim Aynigul
 */
package homework4;

import java.util.Stack;

public class Main {

    /**
     * main function to run the test cases with differents inputs
     * 
     * @param args
     */
    public static void main(String[] args) {

        // Testing officers' username and passwords validations
        TestClass.tryToEnter(new Officer("sibelgulmez","[rac()ecar]",74));
        TestClass.tryToEnter(new Officer("","[rac()ecar]",74));
        TestClass.tryToEnter(new Officer("sibel1","[rac()ecar]",74));
        TestClass.tryToEnter(new Officer("sibel","pass[]",74));
        TestClass.tryToEnter(new Officer("sibel","abcdabcd",74));
        TestClass.tryToEnter(new Officer("sibel","[[[[]]]]",74));
        TestClass.tryToEnter(new Officer("sibel","'[no](no)",74));
        TestClass.tryToEnter(new Officer("sibel","[rac()ecar]]",74));
        TestClass.tryToEnter(new Officer("sibel","[rac()ecars]",74));
        TestClass.tryToEnter(new Officer("sibel","[rac()ecar]",5));
        TestClass.tryToEnter(new Officer("sibel","[rac()ecar]",35));
    }
}