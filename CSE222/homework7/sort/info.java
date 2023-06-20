/**
 * @author Selim Aynigul
 */
package sort;
/**
 * Hold count values and words for the characters.
 */
public class info {
    private int count = 0;
    private String[] words;
    /**
     * Constructor method add words to words list when a character appeared first time
     * @param word will be added
     */
    public info(String word) { 
        push(word); 
    }
    /**
     * getter for count
     * @return count 
     */
    public int getCount() { return count; }
    /**
     * getter for words array
     * @return words array
     */
    public String[] getWords() { return words; }
    /**
     * Add new word to words string array.
     * 
     * @param word will be added to the words array
     */
    public void push(String word) {
        String[] newStr = new String[++count];
        for(int i = 0; i < count - 1; i++) {
            newStr[i] = words[i];
        }
        newStr[count - 1] = word;
        words = newStr;
    }
}
