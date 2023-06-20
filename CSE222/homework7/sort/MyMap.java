/**
 * @author Selim Aynigul
 */
package sort;

import java.util.Map;
import java.util.LinkedHashMap;
/**
 * Rearrange given input and create linkedhashmap.
 */
public class MyMap {
    private LinkedHashMap<Character, info> map;
    private String str;
    /**
     * Constructor method to create empty map.
     * 
     * @param str will be asssigned as str
     */
    public MyMap(String str) {
        this.str = str;
        map = new LinkedHashMap<>();
        str = rearrange();
        buildMap(str);
    }
    /**
     * Contructor method to assign new map.
     * 
     * @param map will be assigned as map
     */
    public MyMap(LinkedHashMap<Character, info> map) {
        this.map = map;
    }
    /**
     * Getter for map
     * @return map
     */
    public LinkedHashMap<Character, info> getMap() { return map; }
    /**
     * Assign given map as map
     * @param map will be assigned
     */
    public void setMap(LinkedHashMap<Character, info> map) {
        this.map = map; 
    }
    /**
     * Remove characters that are not space or letter.
     * 
     * @return arranged string with lowercase letters
     */
    private String rearrange() {
        StringBuilder newStr = new StringBuilder();
        for(char ch : str.toCharArray()) {
            if ((ch >= 'a' && ch <= 'z') || ch == ' ') {
                newStr.append(ch);
            }
            else if(ch >= 'A' && ch <= 'Z') {
                // convert to lowercase
                newStr.append((char)(ch + 32));
            }
        }
        return newStr.toString();
    }
    /**
     * Put every character, how many times and in which word they appeared in a map
     * 
     * @param preProcessed will be used while adding chars to map
     */
    private void buildMap(String preProcessed) {
        for(int i = 0; i < preProcessed.length(); ++i) {
            if(preProcessed.charAt(i) != ' ') {
                // getting word 
                int startIndex = preProcessed.lastIndexOf(" ", i) + 1;
                int endIndex = preProcessed.indexOf(" ", i);
                if (endIndex == -1) {
                    endIndex = preProcessed.length();
                }
                String word = preProcessed.substring(startIndex, endIndex);
                // if doesn't contain add to map, if contains increase value by one
                if(!map.containsKey(preProcessed.charAt(i))) {
                    map.put(preProcessed.charAt(i), new info(word));
                } 
                else {
                    info info = map.get(preProcessed.charAt(i));
                    info.push(word);
                    map.put(preProcessed.charAt(i), info);
                }
            }
        }
    } 
    /**
     * Print map
     */
    public void printMap() {
        for (Map.Entry<Character, info> entry : map.entrySet()) {
            System.out.print("Letter: " + entry.getKey() + " - " + " Count: " + entry.getValue().getCount() + " - " + "Words: [");
            for(int i = 0; i < entry.getValue().getWords().length; i++) {
                System.out.print(entry.getValue().getWords()[i]);
                if(i != entry.getValue().getWords().length - 1)
                    System.out.print(", ");
            }
            System.out.println("]");
        }
    }
}
